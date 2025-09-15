package ru.diasoft.springbootcourse.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.diasoft.springbootcourse.domain.Task;

import java.util.List;

/**
 * Репозиторий для работы с сущностью {@link Task}.
 * Использует Spring Data JPA для доступа к данным в базе.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Найти все задачи с подгрузкой связанных комментариев.
     *
     * @return список задач
     */
    @Override
    @EntityGraph(attributePaths = "comments")
    List<Task> findAll();
}
