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

        categories.values().stream()
                .flatMap(Collection::stream)
                .filter(task -> !task.isCompleted())
                .forEach(result::add);

        return result;
    }

    @Override
    public List<Task> findAllByCategoryAndCompletedFalse(Integer categoryId) {
        List<Task> result = new LinkedList<>();

        categories.keySet().stream()
                .filter(category -> Objects.equals(category.getId(), categoryId))
                .forEach(category -> categories.get(category).stream()
                        .filter(task -> !task.isCompleted())
                        .forEach(result::add));

        return result;
    }

    @Override
    public Task save(Integer categoryId, Task newTask) {
        Category savingCategory = null;
        for (Category category : categories.keySet()){
            if(Objects.equals(category.getId(), categoryId)){
                savingCategory = category;
                break;
            }
        }

        if (savingCategory == null){
            throw new IllegalArgumentException("유효하지 않은 categoryId입니다.");
        }

        List<Task> targetTasks = categories.get(savingCategory);
        targetTasks.add(newTask);
        return newTask;
    }

    @Override
    public Task update(Integer categoryId, Task updatingTask) {
        Category savingCategory = null;
        for (Category category : categories.keySet()){
            if(Objects.equals(category.getId(), categoryId)){
                savingCategory = category;
                break;
            }
        }

        if (savingCategory == null){
            throw new IllegalArgumentException("유효하지 않은 categoryId입니다.");
        }

        List<Task> targetTasks = categories.get(savingCategory);

        Task oldTask = targetTasks.stream()
                .filter(task -> task.getId() == updatingTask.getId())
                .findAny().get();

        oldTask.update(updatingTask);
        return updatingTask;
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
