package mj.practice.Interface;

import mj.practice.TaskDto;

import java.util.List;

public interface ITaskRepository {
    List<TaskDto> findAllByCompletedFalse();
    List<TaskDto> findAllByCategoryAndCompletedFalse(TaskDto task);
    TaskDto save(TaskDto task);
    TaskDto update(TaskDto task);
    TaskDto delete(TaskDto task);
}
