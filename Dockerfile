# Estágio de Build
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio de Execução
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
RUN groupadd -r appgroup && useradd -r -g appgroup -u 1001 appuser
COPY --from=build --chown=appuser:appgroup /app/target/*.jar app.jar
EXPOSE 8080
USER appuser
ENTRYPOINT ["java", "-jar", "app.jar"]
