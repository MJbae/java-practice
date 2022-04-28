package mj.practice;

import mj.practice.Interface.ITaskRepository;

import java.util.*;

public class TaskRepository implements ITaskRepository {
    Map<Category, List<Task>> categories = new HashMap<>();

    TaskRepository(){
        initialize_categories();
    }

    @Override
    public List<Task> findAllByCompletedFalse() {
        List<Task> result = new LinkedList<>();
        for (List<Task> tasks : categories.values()) {
            tasks.stream()
                .filter(task -> !task.isCompleted())
                .forEach(result::add);
        }
        return result;
    }

    @Override
    public List<Task> findAllByCategoryAndCompletedFalse(Integer categoryId) {
        List<Task> result = new LinkedList<>();
        for (Category category : categories.keySet()) {
            if (Objects.equals(category.getId(), categoryId)){
                categories.get(category).stream()
                        .filter(task -> !task.isCompleted())
                        .forEach(result::add);
            }
        }
        return result;
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

    private void initialize_categories() {
        Category personalCategory = new Category(0, "Personal");
        Category businessCategory = new Category(1, "Business");
        categories.put(personalCategory, new LinkedList<>());
        categories.put(businessCategory, new LinkedList<>());

        Task helloTask = new Task(999, "Hello");
        helloTask.complete();
        Task worldTask = new Task(998, "World");
        Task byeTask = new Task(997, "Bye");
        List<Task> personalCategoryTasks = categories.get(personalCategory);
        List<Task> businessCategoryTasks = categories.get(businessCategory);
        personalCategoryTasks.add(helloTask);
        personalCategoryTasks.add(worldTask);
        businessCategoryTasks.add(byeTask);
    }
}
