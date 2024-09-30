package com.todo.entities;

public class Todo {
    String title;
    String description;
    boolean isCompleted;

    /**
     * constructor digunakan untuk meng-assign nilai attribute dari object
     * to-do. pada code berikut terdapat 2 buah constructor dimana
     * constructor pertama hanya membutuhkan parameter title,
     * sedangkan constructor kedua membutuhkan parameter title dan description
     */
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
}
