# Прокси на NGINX

Этот проект демонстрирует настройку NGINX в качестве обратного прокси для Spring Boot приложения авторизации.

## Структура проекта

- `static/signin.html` - HTML форма для авторизации
- `nginx.conf` - конфигурация NGINX
- `src/` - Spring Boot приложение для авторизации
- `Dockerfile.nginx` - Dockerfile для NGINX
- `Dockerfile` - Dockerfile для Spring Boot приложения
- `docker-compose.yml` - конфигурация для запуска всей системы

## Конфигурация NGINX

NGINX настроен следующим образом:
- При обращении к `http://localhost/signin` возвращается статическая HTML форма
- Все остальные запросы проксируются на Spring Boot приложение на порту 8080

## Запуск проекта

### Вариант 1: С использованием Docker Compose

```bash
# Собрать и запустить все сервисы
docker-compose up --build

# Приложение будет доступно по адресу http://localhost
```

### Вариант 2: Локальный запуск

1. Запустить Spring Boot приложение:
```bash
mvn spring-boot:run
```

2. Установить и настроить NGINX:
```bash
# Скопировать nginx.conf в /etc/nginx/sites-available/
# Скопировать signin.html в /usr/share/nginx/html/
# Перезапустить NGINX
sudo systemctl restart nginx
```

## Тестирование

1. Откройте `http://localhost/signin` - должна отобразиться форма авторизации
2. Введите логин: `admin`, пароль: `password`
3. Нажмите "Submit" - запрос будет проксирован на Spring Boot приложение

## API эндпоинты

- `GET /authorize?user=admin&password=password` - авторизация
- `GET /health` - проверка состояния сервиса

## Тестовые данные

- Логин: `admin`
- Пароль: `password` 