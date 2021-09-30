FROM openjdk:11.0.7-slim
LABEL maintainer="juniorpaz99@gmail.com"

VOLUME /tmp

ENV LANG C.UTF-8

ADD build/libs/*.jar /app/app.jar

EXPOSE 8765

ENTRYPOINT ["java", "-jar", "/app/app.jar"]