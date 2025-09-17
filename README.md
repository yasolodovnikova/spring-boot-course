# Задание 6: Транзакции в Spring Framework

## Структура проекта

```
src/main/java/
  └── ru.diasoft.springbootcourse
    └── service/
        ├── TaskService.java        # Интерфейс сервиса
        └── TaskServiceImpl.java    # Реализация сервиса с использованием транзакций
```

---

## Реализация

### Сервис и транзакции

- `TaskServiceImpl` работает с `TaskRepository` и выполняет все CRUD-операции с задачами.
- Для методов работы с базой данных используются аннотации `@Transactional`:
  - Методы **чтения** (`getAll`, `getById`) используют `@Transactional(readOnly = true)` — оптимизация для операций только чтения.
  - Методы **изменения данных** (`create`, `update`, `deleteById`) используют обычный `@Transactional`, что обеспечивает атомарность и откат транзакции при ошибках.
