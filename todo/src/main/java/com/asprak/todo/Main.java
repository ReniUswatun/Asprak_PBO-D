package com.asprak.todo;

import java.util.Scanner;

import com.asprak.todo.data.entities.PriorityTodo;
import com.asprak.todo.data.entities.Todo;
import com.asprak.todo.data.repositories.TodoRepositoryImpl;
import com.asprak.todo.domain.repositories.TodoRepository;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final TodoRepository repository = new TodoRepositoryImpl();

    public static void main(String[] args) {
        Main main = new Main();

        main.displayMenu();
    }

    private void displayMenu() {
        while (true) {
            System.out.println("Asprak Todo List");
            System.out.println("1. Tambah todo");
            System.out.println("2. Lihat daftar todo");
            System.out.println("3. Ubah status selesai");
            System.out.println("4. Hapus todo");
            System.out.println("5. Keluar program");

            System.out.print("> ");
            int input = scanner.nextInt();

            if (input == 1)
                createTodo();
            else if (input == 2)
                showAllTodos();
            else if (input == 3)
                updateCompleted();
            else if (input == 4)
                deleteTodo();
            else {
                this.scanner.close();
                System.out.println("Keluar program...");
                break;
            }
        }
    }

    private void createTodo() {
        System.out.println("\nTambah Todo\n");

        System.out.println("Masukkan index [0-9]");
        int index = this.scanner.nextInt();
        this.scanner.nextLine();

        System.out.println("\nPilih jenis todo:");
        System.out.println("1. Biasa");
        System.out.println("2. Prioritas");
        int type = scanner.nextInt();
        this.scanner.nextLine();

        System.out.println("\nMasukkan judul");
        String title = this.scanner.nextLine();

        System.out.println("\nMasukkan deskripsi");
        String description = this.scanner.nextLine();

        int priority = 0;
        if (type == 2) {
            System.out.println("\nMasukkan prioritas");
            priority = this.scanner.nextInt();
        }

        try {
            if (type == 1) {
                Todo todo = new Todo();
                todo.setTitle(title);
                todo.setDescription(description);
                todo.setCompleted(false);

                if (this.repository.create(index, todo))
                    System.out.println("Berhasil menambahkan todo!\n");
            } else {
                PriorityTodo todo = new PriorityTodo();
                todo.setTitle(title);
                todo.setDescription(description);
                todo.setCompleted(false);
                todo.setPriority(priority);

                if (this.repository.create(index, todo))
                    System.out.println("Berhasil menambahkan todo!\n");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void showAllTodos() {
        System.out.println("\nDaftar Todo\n");

        int index = 0;
        for (Todo todo : this.repository.getAll()) {
            if (todo != null) {
                System.out.printf("- [%d] %s\n", index, todo.getTitle());
                System.out.println("  " + todo.getDescription());
                System.out.printf("  Status   : [%s]\n", (todo.isCompleted() ? "v" : " "));
                if (todo instanceof PriorityTodo)
                    System.out.printf("  Prioritas: %d\n", ((PriorityTodo) todo).getPriority());
            }
            index++;
        }

        System.out.println();
    }

    private void updateCompleted() {
        System.out.println("\nUbah Status Completed\n");

        System.out.println("Masukkan index [0-9]");
        int index = this.scanner.nextInt();

        if (!this.repository.updateCompleted(index))
            System.out.println("Gagal mengubah status completed!\n");
    }

    private void deleteTodo() {
        System.out.println("\nHapus Todo\n");

        System.out.println("Masukkan index [0-9]");
        int index = this.scanner.nextInt();

        if (!this.repository.delete(index))
            System.out.println("Gagal menghapus todo!\n");
    }
}