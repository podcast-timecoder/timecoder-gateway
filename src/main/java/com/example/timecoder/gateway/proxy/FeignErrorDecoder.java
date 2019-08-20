package com.example.timecoder.gateway.proxy;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

@Component
@Primary
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        if (response.body() != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> errors = null;
            try {
                String message = IOUtils.toString(response.body().asInputStream(), Charset.defaultCharset());
                errors = objectMapper.readValue(message, Map.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new ResponseStatusException(HttpStatus.valueOf(response.status()), errors.get("message"));
        }

        return new ResponseStatusException(HttpStatus.valueOf(response.status()), s);

    }
}
