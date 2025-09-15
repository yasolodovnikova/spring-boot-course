package ru.diasoft.springbootcourse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * DTO для передачи задач.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    /** Уникальный идентификатор задачи */
    private long id;

    /** Название или описание задачи */
    private String name;

    /** Список комментариев к задаче */
    private Set<CommentDto> comments;
}
