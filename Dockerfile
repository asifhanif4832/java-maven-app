
FROM amazoncorretto:17-alpine

WORKDIR /usr/app

COPY target/simple-java-app-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
