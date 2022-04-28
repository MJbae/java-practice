package mj.practice;

import mj.practice.Interface.ITaskService;

import java.util.List;

public class TaskService implements ITaskService {
    TaskRepository taskRepository;

    TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> showAll() {
        return taskRepository.findAllByCompletedFalse();
    }

    @Override
    public List<Task> showBy(Integer categoryId) {
        return taskRepository.findAllByCategoryAndCompletedFalse(categoryId);
    }

    @Override
    public Task create(Integer categoryId, Task task) {
        return taskRepository.save(categoryId, task);
    }

    @Override
    public Task update(Integer categoryId, Task task) {
        return null;
    }

    @Override
    public Task delete(Integer categoryId, Task task) {
        return null;
    }
}
