package mj.practice.Interface;

import mj.practice.Category;
import mj.practice.Task;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ITask {
    void setId(int id);
    void setTitle(String title);
    void setDate(LocalDate date);
    void setTime(LocalTime time);
    void setContent(String content);

    int getId();
    String getTitle();
    LocalDate getDate();
    LocalTime getTime();
    String getContent();

    Task complete();
    boolean isCompleted();
}
