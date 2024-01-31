package br.com.adatask.Repository;

import br.com.adatask.Domain.BaseTask;

import java.util.List;

public interface TaskRepository<T extends BaseTask> {
    void saveTask(T task);
    void removeTask(T task);
    void updateTask(T task);
    List<T> getAllTasks();
    T getTaskById(String id);
}
