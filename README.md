# Задание 4: Работа с базой данных

## Структура проекта

```
src/main/java/
    └── ru.diasoft.springbootcourse
        ├── App.java                            # Главный класс приложения
        ├── config/ 
        │   └── SwaggerConfig.java              # Конфигурация Swagger для документации API
        ├── controller/
        │   └── TaskController.java             # REST-контроллер для CRUD-операций над задачами
        ├── dao/
        │   └── TaskRepository.java             # Репозиторий для работы с задачами (Spring Data JPA)
        ├── domain/
        │   ├── Task.java                       # Сущность задачи (Task)
        │   └── Comment.java                    # Сущность комментария (Comment), связь ManyToOne с Task
        ├── dto/
        │   ├── TaskDto.java                    # DTO для задачи
        │   ├── CommentDto.java                 # DTO для комментария
        │   └── converter/
        │       ├── TaskConverter.java          # Конвертер между Task и TaskDto
        │       └── CommentConverter.java       # Конвертер между Comment и CommentDto
        ├── exception/
        │   ├── NoSuchTaskException.java        # Исключение при отсутствии задачи
        │   └── advice/ 
        │       └── GlobalExceptionHandler.java # Глобальный обработчик исключений
        └── service/
            ├── TaskService.java                # Интерфейс сервиса
            └── TaskServiceImpl.java            # Реализация сервиса с бизнес-логикой
```

---

## Реализация

### Контроллер

- `TaskController` обрабатывает запросы к API `/edu/v1/task`:
    - `POST /task` — создать новую задачу,
    - `GET /task` — получить список всех задач (с комментариями),
    - `GET /task/{id}` — получить задачу по ID,
    - `PUT /task/{id}` — обновить задачу по ID,
    - `DELETE /task/{id}` — удалить задачу по ID.

### Сервис

- **Интерфейс `TaskService`**:
    - описывает CRUD-операции.
- **Реализация `TaskServiceImpl`**:
    - работает через `TaskRepository`,
    - использует DTO-конвертеры,
    - выбрасывает `NoSuchTaskException`, если задача не найдена.

### Репозиторий

- `TaskRepository` — наследуется от `JpaRepository<Task, Long>`,
- метод `findAll()` аннотирован `@EntityGraph`, чтобы загружать задачи вместе с комментариями.

### Сущности

- **`Task`**:
    - `id` — идентификатор задачи,
    - `name` — название задачи,
    - `comments` — список комментариев (OneToMany).
- **`Comment`**:
    - `id` — идентификатор комментария,
    - `text` — текст комментария,
    - `task` — ссылка на задачу (ManyToOne).

### DTO и конвертеры

- Используются `TaskDto` и `CommentDto` для передачи данных через API.
- Конвертеры (`TaskConverter`, `CommentConverter`) преобразуют сущности в DTO и обратно.

### Конфигурация H2

Файл `application.yml`:

```yaml
spring:
  h2:
    console:
      enabled: true

  jpa:
    generate-ddl: true
    hibernate:
      ddl-auto: create-drop
    show-sql: true

  datasource:
    url: jdbc:h2:mem:testdb
```

H2 Console доступна по адресу: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)  
URL для подключения: jdbc:h2:mem:testdb

---

## Примеры запросов и ответов
1. Создать задачу

    ```
    POST /edu/v1/task
    Content-Type: application/json
    
    {
      "name": "Выполнить практическое задание",
      "comments": [
        { "text": "Не забыть протестировать" },
        { "text": "Сделать скриншоты" }
      ]
    }
    ```
    
    Ответ (JSON):
    
    ```json
    {
      "id": 1,
      "name": "Выполнить практическое задание",
      "comments": [
        { "id": 1, "text": "Не забыть протестировать" },
        { "id": 2, "text": "Сделать скриншоты" }
      ]
    }
    ```

2. Получить список всех задач

    ```
    GET /edu/v1/task
    ```
    
    Ответ (JSON):
    
    ```json
    [
      {
        "id": 1,
        "name": "Выполнить практическое задание",
        "comments": [
          { "id": 1, "text": "Не забыть протестировать" },
          { "id": 2, "text": "Сделать скриншоты" }
        ]
      }
    ]
    ```

3. Получить задачу по ID
    
    ```
    GET /edu/v1/task/1
    ```
    
    Ответ (JSON):
    
    ```json
    {
      "id": 1,
      "name": "Выполнить практическое задание",
      "comments": [
        { "id": 1, "text": "Не забыть протестировать" },
        { "id": 2, "text": "Сделать скриншоты" }
      ]
    }
    ```
    
    Если задачи не существует:
    
    ```
    GET /edu/v1/task/99
    ```
    
    Ответ:
    
    ```
    HTTP 404 Not Found
    Task with id 99 not found!
    ```

4. Обновить задачу

    ```
    PUT /edu/v1/task/1
    Content-Type: application/json
    
    {
      "name": "Отправить практическое задание"
    }
    ```
    
    Ответ (JSON):
    
    ```json
    {
      "id": 1,
      "name": "Отправить практическое задание",
      "comments": [
        { "id": 1, "text": "Не забыть протестировать" },
        { "id": 2, "text": "Сделать скриншоты" }
      ]
    }
    ```

5. Удалить задачу

    ```
    DELETE /edu/v1/task/1
    ```
    
    Ответ:
    
    ```
    HTTP 200 OK
    ```