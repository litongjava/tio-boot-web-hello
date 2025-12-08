FROM litongjava/jdk:21_0_6-stable-slim

# Set the working directory in the container
WORKDIR /app

# Copy the jar file into the container
COPY target/tio-boot-web-hello-1.0.0.jar /app/

# Command to run the jar file
ENTRYPOINT ["java", "-jar", "tio-boot-web-hello-1.0.0.jar"]