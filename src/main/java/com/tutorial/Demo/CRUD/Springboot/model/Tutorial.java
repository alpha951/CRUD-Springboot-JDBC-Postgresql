package com.tutorial.Demo.CRUD.Springboot.model;

public class Tutorial {
    private long id;
    private String title;
    private String description;
    private boolean published;

    public Tutorial() {

    }

    public Tutorial(long id, String title, String description, boolean published) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.published = published;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isPublished() {
        return this.published;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + this.id + ", title=" + this.title + ", desc=" + this.description + ", published=" + this.published + "]";
    }
}
