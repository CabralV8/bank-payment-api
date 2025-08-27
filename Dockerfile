# ===== STAGE 1: BUILD =====
FROM gradle:8.7-jdk17-alpine AS builder
WORKDIR /app

COPY . .

RUN ./gradlew --no-daemon clean bootJar

# ===== STAGE 2: RUNTIME =====
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

EXPOSE 8080

ENV SERVER_PORT=8080
ENV SPRING_PROFILES_ACTIVE=prod

COPY --from=builder /app/build/libs/*.jar /app/app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]
