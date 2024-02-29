FROM openjdk:17-jdk-slim

ENV JAVA_OPTS "-Dspring.config.location=file:///application.properties"

ADD build/libs/*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
