package ru.karelin.tmweb.repository;

import ru.karelin.tmweb.entity.Task;

import java.util.List;

public interface TaskRepository extends EntityRepository<Task> {
    List<Task> findAllByUserIdAndProjectId(String userId, String projectId);
}
