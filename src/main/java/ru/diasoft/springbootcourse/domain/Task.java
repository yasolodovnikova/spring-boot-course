package ru.diasoft.springbootcourse.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Объект для представления задачи.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    /** Уникальный идентификатор задачи */
    private long id;

    /** Название или описание задачи */
    private String name;
}
