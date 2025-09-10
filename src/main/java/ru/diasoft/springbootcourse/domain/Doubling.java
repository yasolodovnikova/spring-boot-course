package ru.diasoft.springbootcourse.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Объект для передачи результата операции удвоения.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doubling {
    /** Уникальный идентификатор запроса */
    private long id;

    /** Удвоенное число */
    private Integer doublingValue;

    /** Сообщение с текстовым описанием результата */
    private String message;
}
