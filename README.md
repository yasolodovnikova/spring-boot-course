# Задание 1: Введение в микросервисную архитектуру и Spring Framework (расширенная реализация)

## Структура проекта

```
src/main/java/
└── ru.diasoft.springbootcourse
    ├── App.java                        # Главный класс приложения
    ├── controller/
    │   └── DoublingController.java     # REST-контроллер для обработки запросов удвоения числа
    ├── service/
    │   ├── DoublingService.java        # Интерфейс сервиса с методом getDoubling
    │   └── DoublingServiceImpl.java    # Реализация сервиса, вычисляющая удвоение и формирующая DTO
    └── domain/
        └── Doubling.java               # Объект для передачи результата операции удвоения
```

---

## Реализация

### Контроллер

- `DoublingController` обрабатывает GET-запросы `/doubling`.
- Параметр запроса: `value` (необязательный).
- Передаёт значение в сервис и возвращает объект `Doubling`.

### Сервис

- **Интерфейс `DoublingService`**:
    - Объявляет метод `getDoubling(Integer value)`, который возвращает объект `Doubling`.
- **Реализация `DoublingServiceImpl`**:
    - Вычисляет удвоение числа.
    - Генерирует уникальный `id` для каждого запроса.
    - Формирует объект `Doubling` с `id`, `doublingValue` и `message`.

### Объект `Doubling`

- Поля объекта:
    - `id` — уникальный идентификатор запроса.
    - `doublingValue` — удвоенное число.
    - `message` — текстовое описание результата.
- Используется для передачи данных от сервиса к контроллеру и в JSON-ответе API.

---

## Пример запроса и ответа

1. Запрос с числом:

    ```
    GET /doubling?value=7
    ```
    
    Ответ (JSON):
    
    ```json
    {
      "id": 1,
      "doublingValue": 14,
      "message": "Удвоенное значение: 14"
    }
    ```

2. Запрос без параметра:

    ```
    GET /doubling
    ```
    Ответ (JSON):
    
    ```json
    {
      "id": 2,
      "doublingValue": 0,
      "message": "Удвоенное значение: 0"
    }
    ```
