FROM openjdk:21-jdk AS build
WORKDIR /app
COPY. /app
RUN./mvnw clean package -DskipTests

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/target/productos-service-0.0.1-SNAPSHOT.jar /app/productos-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/productos-service.jar"]