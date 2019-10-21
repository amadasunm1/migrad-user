FROM gradle:5.6.2-jdk12 AS build

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle clean --no-daemon

RUN gradle build --no-daemon

FROM openjdk:12-alpine

LABEL maintainer="amadasunm1@gmail.com"

VOLUME /tmp

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/user.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/user.jar"]