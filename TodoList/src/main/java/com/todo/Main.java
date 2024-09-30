package com.todo;

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

        System.out.println("Masukkan prioritas");
        System.out.print("> ");
        int priority = scanner.nextInt();

        // membuat object todo baru
        Todo todo = new Todo(title, description, priority);

        // menampilkan todo ke console
        todo.display();

        scanner.close();
    }
}