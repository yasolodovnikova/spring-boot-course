package ru.diasoft.springbootcourse.service;

import ru.diasoft.springbootcourse.dto.TaskDto;

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
    TaskDto create(TaskDto task);

    /**
     * Получить все задачи.
     *
     * @return список задач
     */
    List<TaskDto> getAll();

    /**
     * Найти задачу по ID.
     *
     * @param id идентификатор задачи
     * @return найденная задача
     */
    TaskDto getById(long id);

    /**
     * Обновить задачу по ID.
     *
     * @param id   идентификатор задачи
     * @param task новая версия задачи
     * @return обновлённая задача
     */
    TaskDto update(long id, TaskDto task);

    /**
     * Удалить задачу по ID.
     *
     * @param id идентификатор задачи
     */
    void deleteById(long id);
}
