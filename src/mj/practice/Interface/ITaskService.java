package mj.practice.Interface;

import mj.practice.TaskDto;

import java.util.List;

public interface ITaskService {
    List<TaskDto> showAll();
    List<TaskDto> showBy(TaskDto task);
    TaskDto create(TaskDto task);
    TaskDto update(TaskDto task);
    TaskDto delete(TaskDto task);
}
