package ru.diasoft.springbootcourse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.diasoft.springbootcourse.dto.TaskDto;
import ru.diasoft.springbootcourse.service.TaskService;

import java.util.List;

/**
 * REST-контроллер для управления задачами.
 * Поддерживает операции CRUD.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/edu/v1")
public class TaskController {

    private final TaskService taskService;

    /**
     * Создать новую задачу.
     *
     * @param task объект задачи
     * @return созданная задача
     */
    @PostMapping("/task")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDto create(@RequestBody TaskDto task) {
        return taskService.create(task);
    }

    /**
     * Получить список всех задач.
     *
     * @return список задач
     */
    @GetMapping("/task")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskDto> getAll() {
        return taskService.getAll();
    }

    /**
     * Получить задачу по её ID.
     *
     * @param id идентификатор задачи
     * @return найденная задача
     */
    @GetMapping("/task/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDto getById(@PathVariable long id) {
        return taskService.getById(id);
    }

    /**
     * Обновить задачу по её ID.
     *
     * @param id   идентификатор задачи
     * @param task новая версия задачи
     * @return обновлённая задача
     */
    @PutMapping("/task/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskDto update(@PathVariable long id, @RequestBody TaskDto task) {
        return taskService.update(id, task);
    }

    /**
     * Удалить задачу по её ID.
     *
     * @param id идентификатор задачи
     */
    @DeleteMapping("/task/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable long id) {
        taskService.deleteById(id);
    }
}
