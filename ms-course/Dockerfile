# 1. Java runtime
FROM eclipse-temurin:17-jre

# 2. Container daxilində iş qovluğu
WORKDIR /app

# 3. Build olunmuş jar-ı container-ə kopyala
COPY build/libs/ms-course-0.0.1-SNAPSHOT.jar app.jar

# 4. Port aç (Spring Boot default)
EXPOSE 7575

# 5. App-i işə sal
ENTRYPOINT ["java", "-Xmx512m", "-jar", "app.jar"]