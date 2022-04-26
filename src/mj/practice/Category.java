package mj.practice;

import mj.practice.Interface.ICategory;

public class Category implements ICategory {
    private Integer id;
    private String title;

    public Category(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getTitle() {
        return this.title;
    }
}
