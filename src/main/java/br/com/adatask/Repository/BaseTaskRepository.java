package br.com.adatask.Repository;

import br.com.adatask.Domain.BaseTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseTaskRepository<T extends BaseTask> implements TaskRepository<T>{
    private final List<T> tasks = new ArrayList<>();
    @Override
    public void saveTask(T taskToAdd) {
        this.tasks.add(taskToAdd);
    }

    @Override
    public void removeTask(T taskToRemove) {
        tasks.removeIf(task -> task.getRandomID().equals(taskToRemove.getRandomID()));
    }

    @Override
    public void updateTask(T taskToUpdate) {
        for(int i = 0; i < tasks.size(); i++){
            T registeredTask = tasks.get(i);
            if(registeredTask.getRandomID().equals(taskToUpdate.getRandomID())){
                tasks.set(i, taskToUpdate);
                return;
            }
        }
    }

    @Override
    public List<T> getAllTasks() {
        if(!tasks.isEmpty()){
            return tasks;
        }
        return new ArrayList<>();
    }

    @Override
    public T getTaskById(String id) {
        for(T task: tasks){
            if(Objects.equals(task.getRandomID(), id)){
                return task;
            }
        }
        return null;
    }

}
