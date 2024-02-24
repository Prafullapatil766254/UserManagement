
# Stage 1: Build the application
FROM gradle:7.3.3-jdk8 AS gradle
WORKDIR /app
COPY . /app
RUN gradle clean build

# Stage 2: Create a lightweight image with only JRE and the compiled application
FROM openjdk:8-jre-slim
WORKDIR /app
COPY --from=gradle /app/build/libs/CSVProject-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]