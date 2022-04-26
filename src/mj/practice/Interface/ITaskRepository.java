package mj.practice.Interface;

import mj.practice.Category;
import mj.practice.Task;

import java.util.List;

public interface ITaskRepository {
    List<Task> findAllByCompletedFalse();
    List<Task> findAllByCategoryAndCompletedFalse(Integer categoryId);
    Task save(Integer categoryId, Task task);
    Task update(Integer categoryId, Task task);
    Task delete(Integer categoryId, Task task);
}
