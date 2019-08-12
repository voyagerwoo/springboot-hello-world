FROM adoptopenjdk/openjdk8:x86_64-alpine-jre8u222-b10
RUN apk --no-cache add curl
RUN adduser -D -s /bin/sh voyagerwoo
USER voyagerwoo

ARG APP_NAME=app
ARG LIB_DIR=target/unpack-lib
ARG APP_DIR=target/unpack-app

RUN mkdir /home/voyagerwoo/${APP_NAME}
WORKDIR /home/voyagerwoo/${APP_NAME}

COPY ${LIB_DIR} BOOT-INF/lib
COPY ${APP_DIR} .
ENV PROFILE=local

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=${PROFILE}","org.springframework.boot.loader.JarLauncher"]