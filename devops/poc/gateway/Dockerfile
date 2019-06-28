FROM spirogov/timecoder-gateway:latest

WORKDIR /root/

COPY jacoco/jacocoagent.jar .

ENTRYPOINT ["java", "-javaagent:/jacocoagent.jar=port=36321,output=tcpserver,address=0.0.0.0", "-cp", "/app/resources:/app/classes:/app/libs/*", "com.example.timecoder.gateway.GatewayApplication"]