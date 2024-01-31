package br.com.adatask.Service;

import br.com.adatask.Domain.BaseTask;
import br.com.adatask.Repository.TaskRepository;

import java.util.List;

public class BaseTaskService<T extends BaseTask> implements TaskService<T> {

    private final TaskRepository<T> taskRepository;

    public BaseTaskService(TaskRepository<T> taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void addNewTask(T task) {
        this.taskRepository.saveTask(task);
    }

    @Override
    public void removeTask(T task) {
        taskRepository.removeTask(task);
    }

    @Override
    public void updateTask(T task) {
        taskRepository.updateTask(task);
    }

    @Override
    public List<T> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    @Override
    public T getTaskById(String id) {
        return taskRepository.getTaskById(id);
    }


}