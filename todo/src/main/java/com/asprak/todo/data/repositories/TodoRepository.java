package com.asprak.todo.data.repositories;

import com.asprak.todo.data.entities.PriorityTodo;
import com.asprak.todo.data.entities.Todo;

public class TodoRepository {
  // untuk sementara hanya dapat menampung maksimal 10 todos
  private final int length = 10;
  private Todo[] todos = new Todo[length];

  public TodoRepository() {
    Todo todo = new Todo();
    todo.setTitle("random title");
    todo.setDescription("desc todo biasa");
    todo.setCompleted(false);

    this.todos[0] = todo;
    this.todos[9] = todo;

    PriorityTodo priorityTodo = new PriorityTodo();
    priorityTodo.setTitle("random title");
    priorityTodo.setDescription("desc todo dengan prioritas");
    priorityTodo.setCompleted(false);
    priorityTodo.setPriority(2);

    this.todos[3] = priorityTodo;
  }

  public boolean create(int index, Todo todo) {
    if (index >= 0 && index < this.length) {
      this.todos[index] = todo;
      return true;
    } else
      return false;
  }

  public Todo[] getAll() {
    return this.todos;
  }

  public boolean updateCompleted(int index) {
    if (index >= 0 && index < this.length) {
      Todo current = this.todos[index];
      if (current == null)
        return false;

      this.todos[index].setCompleted(!current.isCompleted());
      return true;
    } else
      return false;
  }

  public boolean delete(int index) {
    if (index >= 0 && index < this.length) {
      this.todos[index] = null;
      return true;
    } else
      return false;
  }
}
