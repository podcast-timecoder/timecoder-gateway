package com.example.timecoder.gateway;

import com.example.timecoder.gateway.proxy.FeignErrorDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.annotation.PostConstruct;
import java.util.TimeZone;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EntityScan(basePackageClasses = {
		GatewayApplication.class,
		Jsr310JpaConverters.class
})
public class GatewayApplication {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public FeignErrorDecoder errorDecoder() {
		return new FeignErrorDecoder();
	}
}
