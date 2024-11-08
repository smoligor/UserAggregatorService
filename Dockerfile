# Use an OpenJDK image as the base
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the application jar file to the container
COPY target/UserAggregatorService-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]