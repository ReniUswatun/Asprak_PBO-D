package com.todo.entities;

/**
 * merupakan object turunan dari to-do
 * yang membedakan adalah object ini memiliki semua attribute dari class to-do
 * sekaligus attribute priority
 */
public class PriorityTodo extends Todo {
    int priority;

    public PriorityTodo(String title, String description, int priority) {
        super(title, description);
        this.priority = priority;
    }

    /**
     * method display berikut merupakan method overriding
     * yang digunakan untuk menampilkan data to-do dengan prioritas.
     * method ini akan memanggil method pada parent, kemudian menampilkan
     * info prioritas ke console
     */
    @Override
    public void display() {
        // menggunakan super untuk memanggil fungsi parent
        // yaitu menampilkan title, description, dan isCompleted
        super.display();

        // selanjutnya, tampilkan informasi tambahan yang hanya ada di object ini
        // yaitu prioritas
        System.out.println("Prioritas   : " + this.priority);
    }
}
