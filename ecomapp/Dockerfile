FROM maven:3.8.5-openjdk-17 as builder
WORKDIR /ecomapp
COPY ecomapp/pom.xml .
RUN mvn dependency:go-offline
COPY ecomapp/src/ ./src/
RUN mvn clean package -DskipTests=true




# Start with a base image - in this case JDK 8 Alpine
FROM openjdk:17-jdk-alpine
WORKDIR /ecomapp
RUN mkdir /target
# Copy the JAR
COPY --from=builder /ecomapp/target/*.jar app.jar
EXPOSE 8080

# Set ENTRYPOINT in exec form to run the container as an executable
ENTRYPOINT ["java","-jar","/app.jar"]