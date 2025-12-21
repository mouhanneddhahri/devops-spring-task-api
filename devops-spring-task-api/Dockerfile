# ---------- STAGE 1: Build the application ----------
# Use Maven + JDK 17 image for building the jar
FROM maven:3.9.2-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies first (leverages Docker cache)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Package the application (skip tests for speed if needed)
RUN mvn clean package -DskipTests

# ---------- STAGE 2: Create the runtime image ----------
# Use lightweight JDK runtime image for production
FROM eclipse-temurin:17-jre

# Set working directory
WORKDIR /app

# Copy the fat jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
