package ru.karelin.tmweb.repository;

public class TaskRepository {
    private static final  TaskRepository ourInstance  = new TaskRepository();
    public static TaskRepository getInstance() {
        return ourInstance;
    }
    private TaskRepository(){};
}
