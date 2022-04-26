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

}
