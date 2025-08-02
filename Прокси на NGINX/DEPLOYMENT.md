# Инструкция по развертыванию

## Быстрый запуск с Docker Compose

1. Убедитесь, что у вас установлен Docker и Docker Compose
2. Клонируйте репозиторий
3. Выполните команду:
```bash
docker-compose up --build
```

## Локальное развертывание

### 1. Запуск Spring Boot приложения

```bash
# Сборка проекта
mvn clean package

# Запуск приложения
java -jar target/auth-service-1.0.0.jar
```

Приложение будет доступно на порту 8080.

### 2. Настройка NGINX

1. Установите NGINX:
```bash
# Ubuntu/Debian
sudo apt-get install nginx

# macOS
brew install nginx
```

2. Скопируйте конфигурацию:
```bash
sudo cp nginx.conf /etc/nginx/sites-available/auth-service
sudo ln -s /etc/nginx/sites-available/auth-service /etc/nginx/sites-enabled/
```

3. Скопируйте HTML файл:
```bash
sudo cp static/signin.html /usr/share/nginx/html/
```

4. Перезапустите NGINX:
```bash
sudo systemctl restart nginx
```

## Тестирование

1. Откройте браузер и перейдите на `http://localhost/signin`
2. Введите тестовые данные:
   - Логин: `admin`
   - Пароль: `password`
3. Нажмите "Submit"

## Проверка работы

- `http://localhost/signin` - форма авторизации
- `http://localhost/health` - проверка состояния сервиса
- `http://localhost/authorize?user=admin&password=password` - прямая авторизация 