package ru.karelin.tmweb.service;

import ru.karelin.tmweb.entity.Task;
import ru.karelin.tmweb.repository.TaskRepository;
import ru.karelin.tmweb.repository.TaskRepositoryImpl;

import java.util.List;

public class TaskService {
    private final TaskRepository taskRepository = TaskRepositoryImpl.getInstance();

    private static TaskService ourInstance = new TaskService();

    public static TaskService getInstance() {
        return ourInstance;
    }

    private TaskService() {
    }

    public Task findByIdAndUserId(String id, String userId) {
        return taskRepository.findByIdAndUserId(id, userId);
    }

    public List<Task> findAllByUserId(String userId) {
        return taskRepository.findAllByUserId(userId);
    }

    public List<Task> findAllByUserIdAndProjectId(String userId, String projectId) {
        return taskRepository.findAllByUserIdAndProjectId(userId, projectId);
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public void remove(String id, String userId) {
        Task task = taskRepository.findByIdAndUserId(id, userId);
        if (task!=null) taskRepository.remove(task);
    }
}
