FROM openjdk:17-jdk-slim

WORKDIR /app

# Копируем Maven файлы
COPY pom.xml .
COPY src ./src

# Устанавливаем Maven и собираем приложение
RUN apt-get update && apt-get install -y maven
RUN mvn clean package -DskipTests

# Копируем собранный JAR файл
COPY target/auth-service-1.0.0.jar app.jar

# Открываем порт 8080
EXPOSE 8080

# Запускаем приложение
CMD ["java", "-jar", "app.jar"] 