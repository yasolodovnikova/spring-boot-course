package ru.diasoft.springbootcourse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.diasoft.springbootcourse.dao.TaskRepository;
import ru.diasoft.springbootcourse.domain.Task;
import ru.diasoft.springbootcourse.dto.TaskDto;
import ru.diasoft.springbootcourse.dto.converter.TaskConverter;
import ru.diasoft.springbootcourse.exception.NoSuchTaskException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    @Override
    public TaskDto create(TaskDto taskDto) {
        Task task = TaskConverter.toEntity(taskDto);

        return TaskConverter.toDto(repository.save(task));
    }

    @Override
    public List<TaskDto> getAll() {
        return repository.findAll().stream()
                .map(TaskConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto getById(long id) {
        Optional<Task> optionalTask = repository.findById(id);

        if (optionalTask.isEmpty()) {
            throw new NoSuchTaskException("Task with id " + id + " not found!");
        }

        return TaskConverter.toDto(optionalTask.get());
    }

    @Override
    public TaskDto update(long id, TaskDto taskDto) {
        Task updateTask = repository.findById(id)
                .orElseThrow(() -> new NoSuchTaskException("Task with id " + id + " not found!"));

        updateTask.setName(taskDto.getName());

        return TaskConverter.toDto(repository.save(updateTask));
    }

    @Override
    public void deleteById(long id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new NoSuchTaskException("Task with id " + id + " not found!"));

        repository.delete(task);
    }
}
