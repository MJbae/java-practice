package mj.practice;

import mj.practice.Interface.ITask;

import java.time.LocalDate;
import java.time.LocalTime;

public class Task implements ITask {
    private Integer id;
    private String title;
    private LocalDate date;
    private LocalTime time;
    private String content;
    private Boolean completed;
    public Task(Integer id, String title) {
        this.id = id;
        this.title = title;
        this.completed = false;
    }
    public Task(Integer id, String title, LocalDate date, LocalTime time, String content) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.time = time;
        this.content = content;
        this.completed = false;
    }
    public void update(Task newTask){
        setTitle(newTask.title);
        setDate(newTask.date);
        setTime(newTask.time);
        setContent(newTask.content);
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public LocalTime getTime() {
        return this.time;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public void complete() {
        this.completed = true;
    }

    @Override
    public boolean isCompleted() {
        return this.completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                '}';
    }
}
