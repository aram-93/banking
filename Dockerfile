# Stage 1: Build the application using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application with JDK
FROM eclipse-temurin:11-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar hcc-armenia-docker.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
