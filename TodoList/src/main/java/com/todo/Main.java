package com.todo;

import com.todo.entities.PriorityTodo;
import com.todo.entities.Todo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // menginsialisasi scanner
        Scanner scanner = new Scanner(System.in);

        // meminta user untuk memasukkan beberapa input
        System.out.println("Masukkan judul");
        System.out.print("> ");
        String title = scanner.nextLine();

        System.out.println("Masukkan deskripsi");
        System.out.print("> ");
        String description = scanner.nextLine();

        // membuat object to-do tanpa priority baru
        Todo todo = new Todo(title, description);

        // menampilkan to-do tanpa priority ke console
        todo.display();

        System.out.println("Mengubah isCompleted menjadi true...");
        todo.markAsDone();

        // menampilkan ulang to-do tanpa priority ke console
        todo.display();

        // meminta user untuk memasukkan beberapa input
        System.out.println("Masukkan judul");
        System.out.print("> ");
        String title2 = scanner.nextLine();

        System.out.println("Masukkan deskripsi");
        System.out.print("> ");
        String description2 = scanner.nextLine();

        System.out.println("Masukkan prioritas");
        System.out.print("> ");
        int prioritas2 = scanner.nextInt();

        // membuat object to-do dengan priority baru
        PriorityTodo priorityTodo = new PriorityTodo(title2, description2, prioritas2);

        // menampilkan to-do dengan priority ke console
        priorityTodo.display();

        System.out.println("Mengubah isCompleted menjadi true...");
        priorityTodo.markAsDone();

        // menampilkan ulang to-do dengan priority ke console
        priorityTodo.display();

        scanner.close();

        // maaf seadanya, udah trauma dicopas soalnya :)
    }
}