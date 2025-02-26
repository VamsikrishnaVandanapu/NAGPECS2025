# Start with a base image - in this case JDK 8 Alpine
FROM openjdk:17-jdk-alpine
EXPOSE 8080
# Specify JAR location
ARG JAR_FILE=target/*.jar
# Copy the JAR
COPY ${JAR_FILE} app.jar
# Set ENTRYPOINT in exec form to run the container as an executable
ENTRYPOINT ["java","-jar","/app.jar"]