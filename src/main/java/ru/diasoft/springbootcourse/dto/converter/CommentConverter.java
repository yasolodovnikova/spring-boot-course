package ru.diasoft.springbootcourse.dto.converter;

import lombok.experimental.UtilityClass;
import ru.diasoft.springbootcourse.domain.Comment;
import ru.diasoft.springbootcourse.domain.Task;
import ru.diasoft.springbootcourse.dto.CommentDto;


/**
 * Конвертер между сущностью {@link Comment} и DTO {@link CommentDto}.
 */
@UtilityClass
public class CommentConverter {

    /**
     * Преобразовать DTO комментария в сущность.
     *
     * @param commentDto DTO комментария
     * @param task задача, к которой относится комментарий
     * @return сущность {@link Comment}
     */
    public Comment toEntity(CommentDto commentDto, Task task) {
        return Comment.builder()
                .id(commentDto.getId())
                .text(commentDto.getText())
                .task(task)
                .build();
    }

    /**
     * Преобразовать сущность комментария в DTO.
     *
     * @param comment сущность {@link Comment}
     * @return DTO {@link CommentDto}
     */
    public CommentDto toDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .text(comment.getText())
                .build();
    }
}
