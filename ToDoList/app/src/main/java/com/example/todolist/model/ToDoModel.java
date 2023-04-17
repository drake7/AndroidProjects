package com.example.todolist.model;

public class ToDoModel {

    private String task;
    private int id;
    private int status;

    public ToDoModel(String task, int id, int status) {
        this.task = task;
        this.id = id;
        this.status = status;
    }

    public ToDoModel() {

    }


    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
