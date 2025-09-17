# Задание 5: Создание и обновление структуры базы данных с Liquibase

## Структура ресурсов

```
src/main/resources/
    ├── application.yml                                 # Конфигурация приложения
    └── db.changelog/
        ├── rootChangeLog.xml                           # Корневой changelog Liquibase
        ├── 1.0/
        │   ├── 2025-09-16--0001-task.xml               # Создание таблицы task
        │   └── 2025-09-16--0001-comment.xml            # Создание таблицы comment
        └── data/
            ├── 2025-09-16--0001-task-data.xml          # Загрузка данных в таблицу task
            ├── 2025-09-16--0001-comment-data.xml       # Загрузка данных в таблицу comment
            └── csv/
                ├── 2025-09-16--0001-task-data.csv
                └── 2025-09-16--0001-comment-data.csv
```

---

## Конфигурация

- Hibernate: `ddl-auto: none` (структура БД не создается автоматически);
- Liquibase: включен и указывает на `db.changelog/rootChangeLog.xml`;
- Postgres: разворачивается в контейнере Docker, доступен на порту `5433`.

---

## Что сделано

- Настроено подключение к **Postgres** через Docker Compose.
- Добавлен **Liquibase**, который:
    - создает таблицы `task` и `comment` с нужными связями,
    - загружает тестовые данные из CSV.
- Отключено автоматическое создание схемы Hibernate (`ddl-auto: none`), чтобы структура управлялась только миграциями.

---

## Как запустить

1. Поднять Postgres в Docker;

2. Запустить Spring Boot приложение;

3. Liquibase автоматически применит миграции и загрузит данные.
