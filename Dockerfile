FROM openjdk:8-alpine

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/app.jar"]

ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/app.jar