FROM openjdk:11.0.7-slim
LABEL maintainer="juniorpaz99@gmail.com"

VOLUME /tmp

ENV LANG C.UTF-8

ARG JAR_FILE=eureka-server/build/libs/eureka-server-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

RUN bash -c 'touch /app.jar'

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "/app.jar"]
