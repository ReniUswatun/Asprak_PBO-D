package com.todo.entities;

public class Todo {
    private String title;
    private String description;
    private boolean isCompleted;

    /**
     * constructor digunakan untuk meng-assign nilai attribute dari object
     * to-do. pada code berikut terdapat 2 buah constructor dimana
     * constructor pertama hanya membutuhkan parameter title,
     * sedangkan constructor kedua membutuhkan parameter title dan description
     */
    public Todo() {
    }

    public Todo(String title) {
        this.title = title;
    }

    public Todo(String title, String description) {
        this.title = title;
        this.description = description;

        // ketika pertama kali dibuat, status selesai dari to-do adalah false
        // atau belum selesai
        this.isCompleted = false;
    }

    /**
     * method untuk menampilkan informasi dari object to-do
     */
    public void display() {
        System.out.println("Title       : " + this.title);
        System.out.println("Description : " + this.description);
        System.out.println("Completed   : [" + (this.isCompleted ? "v" : " ") + "]");
    }

    public void markAsDone() {
        this.isCompleted = true;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}
