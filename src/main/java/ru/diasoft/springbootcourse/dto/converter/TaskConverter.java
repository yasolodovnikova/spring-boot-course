package ru.diasoft.springbootcourse.dto.converter;

import lombok.experimental.UtilityClass;
import ru.diasoft.springbootcourse.domain.Task;
import ru.diasoft.springbootcourse.dto.TaskDto;

import java.util.stream.Collectors;

/**
 * Конвертер между сущностью {@link Task} и DTO {@link TaskDto}.
 */
@UtilityClass
public class TaskConverter {

    /**
     * Преобразовать DTO задачи в сущность.
     *
     * @param taskDto объект DTO
     * @return сущность {@link Task}
     */
    public Task toEntity(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setName(taskDto.getName());
        task.setComments(taskDto.getComments().stream()
                .map(comment -> CommentConverter.toEntity(comment, task))
                .collect(Collectors.toSet()));

        return task;
    }


    /**
     * Преобразовать сущность задачи в DTO.
     *
     * @param task сущность {@link Task}
     * @return DTO {@link TaskDto}
     */
    public TaskDto toDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .name(task.getName())
                .comments(task.getComments().stream().map(CommentConverter::toDto).collect(Collectors.toSet()))
                .build();
    }
}
