package mj.practice;

import mj.practice.Interface.ITaskRepository;

import java.util.*;

public class TaskRepository implements ITaskRepository {
    Map<Category, List<Task>> categories = new HashMap<>();

    TaskRepository(){
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

    @Override
    public List<Task> findAllByCompletedFalse() {
        List<Task> result = new LinkedList<>();
        for (List<Task> tasks : categories.values()) {
            for(Task task : tasks){
                if(!task.isCompleted()){
                    result.add(task);
                }
            }
        }
        return result;
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
