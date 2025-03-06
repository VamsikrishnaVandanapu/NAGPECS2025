# Start with a base image - in this case JDK 8 Alpine
FROM openjdk:17-jdk-alpine
EXPOSE 8080
# Copy the JAR
ADD ecomapp-v1.jar  app.jar
# Set ENTRYPOINT in exec form to run the container as an executable
ENTRYPOINT ["java","-jar","/app.jar"]