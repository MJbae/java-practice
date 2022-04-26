package mj.practice.Interface;

import mj.practice.Category;
import mj.practice.Task;

import java.util.List;

public interface ITaskService {
    List<Task> showAll();
    List<Task> showBy(Integer categoryId);
    Task create(Integer categoryId, Task task);
    Task update(Integer categoryId, Task task);
    Task delete(Integer categoryId, Task task);
}
