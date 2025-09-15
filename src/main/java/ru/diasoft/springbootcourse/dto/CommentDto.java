package ru.diasoft.springbootcourse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO для передачи комментариев.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    /** Уникальный идентификатор комментария */
    private long id;

    /** Текст комментария */
    private String text;
}
