FROM openjdk:11.0.7-slim
LABEL maintainer="juniorpaz99@gmail.com"

VOLUME /tmp

ENV LANG C.UTF-8

ARG JAR_FILE=cambio-service/target/*.jar

COPY ${JAR_FILE} app.jar

RUN bash -c 'touch /app.jar'

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "/app.jar"]