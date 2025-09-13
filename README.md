# Задание 3: Создание веб-приложений на Spring Framework

## Структура проекта


```
src/main/java/
└── ru.diasoft.springbootcourse
    ├── App.java                            # Главный класс приложения
    ├── config/
    │   └── SwaggerConfig.java              # Конфигурация Swagger для документации API
    ├── controller/
    │   └── TaskController.java             # REST-контроллер для CRUD-операций над задачами
    ├── domain/
    │   └── Task.java                       # Объект для представления задачи
    ├── exception/
    │   ├── NoSuchTaskException.java        # Исключение при отсутствии задачи с заданным ID
    │   └── advice/
    │       └── GlobalExceptionHandler.java # Глобальный обработчик исключений
    └── service/
        ├── TaskService.java                # Интерфейс сервиса для работы с задачами
        └── TaskServiceImpl.java            # Реализация сервиса с хранением задач в памяти
```

---

## Реализация

### Контроллер

- `TaskController` обрабатывает запросы к API `/edu/v1`:
  - `POST /task` — создать новую задачу,
  - `GET /task` — получить список всех задач,
  - `GET /task/{id}` — получить задачу по ID,
  - `PUT /task/{id}` — обновить задачу по ID,
  - `DELETE /task/{id}` — удалить задачу по ID.

### Сервис

- **Интерфейс `TaskService`**:
  - объявляет CRUD-методы для работы с задачами.
- **Реализация `TaskServiceImpl`**:
  - хранит задачи в памяти (`List<Task>`),
  - генерирует уникальные идентификаторы с помощью `AtomicLong`,
  - выбрасывает `NoSuchTaskException`, если задача не найдена.

### Исключения

- `NoSuchTaskException` используется при обращении к несуществующей задаче.
- `GlobalExceptionHandler` перехватывает исключения и возвращает корректный HTTP-ответ с кодом `404`.

### Swagger

- `SwaggerConfig` подключает документацию Swagger для тестирования и описания API.

### Объект `Task`

- Поля объекта:
  - `id` — уникальный идентификатор задачи,
  - `name` — название или описание задачи.

---

## Примеры запросов и ответов

1. Создать задачу:

    ```
    POST /edu/v1/task
    Content-Type: application/json

    {
      "name": "Выполнить практическое задание по курсу"
    }
    ```

   Ответ (JSON):

    ```json
    {
      "id": 1,
      "name": "Выполнить практическое задание по курсу"
    }
    ```

2. Получить список всех задач:

    ```
    GET /edu/v1/task
    ```

   Ответ (JSON):

    ```json
    [
      {
        "id": 1,
        "name": "Выполнить практическое задание по курсу"
      }
    ]
    ```

3. Получить задачу по ID:

    ```
    GET /edu/v1/task/1
    ```

   Ответ (JSON):

    ```json
    {
      "id": 1,
      "name": "Выполнить практическое задание по курсу"
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

4. Обновить задачу:

    ```
    PUT /edu/v1/task/1
    Content-Type: application/json

    {
      "name": "Выложить практическое задание"
    }
    ```

   Ответ (JSON):

    ```json
    {
      "id": 1,
      "name": "Выложить практическое задание"
    }
    ```

5. Удалить задачу:

    ```
    DELETE /edu/v1/task/1
    ```

   Ответ:

    ```
    HTTP 200 OK
    ```