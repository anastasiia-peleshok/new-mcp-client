FROM openjdk:17-jdk-slim
COPY target/mcp-client-0.0.1-SNAPSHOT.jar /client.jar
ENTRYPOINT ["java", "-jar", "/client.jar"]
