FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /app

COPY target/stctask-1.0-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
