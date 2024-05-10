FROM eclipse-temurin:21-jdk-alpine
LABEL maintainer="me@mail.com"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-app03.jar
ENTRYPOINT ["java","-jar","/ms-app03.jar"]
