package ru.karelin.tmweb.repository;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.karelin.tmweb.entity.Task;

import java.util.*;

public class TaskRepositoryImpl implements TaskRepository {

    private static final TaskRepository ourInstance = new TaskRepositoryImpl();

    public static TaskRepository getInstance() {
        return ourInstance;
    }

    private final HashMap<String, Task> taskMap = new LinkedHashMap<>();

    private TaskRepositoryImpl() {
    }


    @Override
    public List<Task> findAll() {
        return new ArrayList<>(taskMap.values());
    }

    @Override
    public List<Task> findAllByUserId(String userId) {
        return filterByUserId(findAll(), userId);
    }

    @Override
    public Task find(String id) {
        return taskMap.get(id);
    }

    @Override
    public Task findByIdAndUserId(String id, String userId) {
        return filterByUserId(find(id), userId);
    }

    @Override
    public void save(Task t) {
        taskMap.put(t.getId(), t);
    }

    @Override
    public void remove(Task t) {
        taskMap.remove(t.getId());
    }

    @Override
    public List<Task> findAllByUserIdAndProjectId(String userId, String projectId) {
        List<Task> list = findAllByUserId(userId);
        Iterator<Task> iter = list.iterator();
        while (iter.hasNext()) {
            Task task = iter.next();
            if (!task.getProjectId().equals(projectId)) {
                iter.remove();
            }
        }
        return list;
    }

    private List<Task> filterByUserId(@NotNull List<Task> tasks, String userId) {
        Iterator<Task> iter = tasks.iterator();
        while (iter.hasNext()) {
            Task task = iter.next();
            if (!task.getUserId().equals(userId)) {
                iter.remove();
            }
        }
        return tasks;
    }

    @Contract("null, _ -> null")
    @Nullable
    private Task filterByUserId(@Nullable Task task, String userId) {
        if (task != null && task.getUserId().equals(userId)) return task;
        else return null;
    }
}
