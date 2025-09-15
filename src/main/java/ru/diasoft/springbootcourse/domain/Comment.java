package ru.diasoft.springbootcourse.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;


/**
 * Сущность комментария к задаче.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "task")
@Table(name = "comment")
public class Comment {

    /** Уникальный идентификатор комментария */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** Текст комментария */
    @Column(name = "text")
    private String text;

    /** Задача, к которой относится комментарий */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;
}
