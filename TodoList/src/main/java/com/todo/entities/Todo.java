package com.todo.entities;

public class Todo {
    String title;
    String description;
    int priority;

    public Todo(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public void display() {
        System.out.println("Title       : " + this.title);
        System.out.println("Description : " + this.description);
        System.out.println("Priority    : " + this.priority);
    }
}
