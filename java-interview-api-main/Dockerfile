# Use OpenJDK 21
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the correct Gradle build directory
COPY build/libs/java-interview-api.jar app.jar

# Expose the application port
EXPOSE 9000

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
