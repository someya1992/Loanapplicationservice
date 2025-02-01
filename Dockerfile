# Use OpenJDK 8 as base image
FROM openjdk:8-jdk-alpine

# Install curl
RUN apk --no-cache add curl

# Set the working directory
WORKDIR /app

# Copy the built jar file into the container
COPY target/loanapplicationservice-0.0.1-SNAPSHOT.jar loanapplicationservice-0.0.1-SNAPSHOT.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "loanapplicationservice-0.0.1-SNAPSHOT.jar"]
