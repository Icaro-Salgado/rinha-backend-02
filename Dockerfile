#FROM openjdk:23-slim
FROM eclipse-temurin:21.0.2_13-jdk-alpine

COPY ./build/libs/backend-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "app.jar"]