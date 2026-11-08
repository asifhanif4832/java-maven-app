
FROM amazoncorretto:17-alpine

WORKDIR /usr/app

COPY target/simple-java-app-*.jar app.jar

EXPOSE 8080

# ENTRYPOINT ["java", "-jar", "app.jar"]
CMD [ java -jar app.jar]
