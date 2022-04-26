package mj.practice;

import mj.practice.Interface.ITaskRepository;

import java.util.*;
import java.util.stream.Collectors;

public class TaskRepository implements ITaskRepository {
    Map<Integer, Category> categories = new HashMap<>();
    Map<Integer, Task> tasks = new HashMap<>();

    TaskRepository(){
        Category personalCategory = new Category(0, "Personal");
        Category businessCategory = new Category(1, "Business");
        categories.put(personalCategory.getId(), personalCategory);
        categories.put(businessCategory.getId(), businessCategory);

        Task helloTask = new Task(999, "Hello");
        Task worldTask = new Task(998, "World");
        Task byeTask = new Task(997, "Bye");
        tasks.put(personalCategory.getId(), helloTask);
        tasks.put(personalCategory.getId(), worldTask);
        tasks.put(businessCategory.getId(), byeTask);
    }

    @Override
    public List<Task> findAllByCompletedFalse() {
        return tasks.values().stream()
                .filter(task -> !task.isCompleted())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<Task> findAllByCategoryAndCompletedFalse(Integer categoryId) {
        return null;
    }

    @Override
    public Task save(Integer categoryId, Task task) {
        return null;
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
