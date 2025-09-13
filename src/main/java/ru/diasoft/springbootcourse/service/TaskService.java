package ru.diasoft.springbootcourse.service;

import ru.diasoft.springbootcourse.domain.Task;

import java.util.List;

/**
 * Сервис для управления задачами.
 */
public interface TaskService {

    /**
     * Создать новую задачу.
     *
     * @param task объект задачи
     * @return созданная задача
     */
    Task create(Task task);

    /**
     * Получить все задачи.
     *
     * @return список задач
     */
    List<Task> getAll();

    /**
     * Найти задачу по ID.
     *
     * @param id идентификатор задачи
     * @return найденная задача
     */
    Task getById(long id);

    /**
     * Обновить задачу по ID.
     *
     * @param id   идентификатор задачи
     * @param task новая версия задачи
     * @return обновлённая задача
     */
    Task update(long id, Task task);

    /**
     * Удалить задачу по ID.
     *
     * @param id идентификатор задачи
     */
    void deleteById(long id);
}
