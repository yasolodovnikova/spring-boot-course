package ru.diasoft.springbootcourse.service;

import org.springframework.stereotype.Service;
import ru.diasoft.springbootcourse.domain.Task;
import ru.diasoft.springbootcourse.exception.NoSuchTaskException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskServiceImpl implements TaskService {

    private final List<Task> taskList;
    private final AtomicLong atomicLong;

    public TaskServiceImpl() {
        this.taskList = new ArrayList<>();
        this.atomicLong = new AtomicLong();
    }

    @Override
    public Task create(Task task) {
        task.setId(atomicLong.incrementAndGet());
        taskList.add(task);
        return task;
    }

    @Override
    public List<Task> getAll() {
        return taskList;
    }

    @Override
    public Task getById(long id) {
        return taskList.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchTaskException("Task with id " + id + " not found!"));
    }

    @Override
    public Task update(long id, Task task) {
        taskList.removeIf(t -> t.getId() == id);

        task.setId(id);
        taskList.add(task);

        return task;
    }

    @Override
    public void deleteById(long id) {
        taskList.removeIf(t -> t.getId() == id);
    }
}
