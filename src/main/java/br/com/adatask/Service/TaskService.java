package br.com.adatask.Service;

import br.com.adatask.Domain.BaseTask;
import br.com.adatask.Domain.PersonalTask;
import br.com.adatask.Repository.TaskRepository;

import java.util.List;

public interface TaskService<T extends BaseTask> {

    void addNewTask(T task);

    void removeTask(T task);

    void updateTask(T task);

    List<T> getAllTasks();

    T getTaskById(String id);

}
