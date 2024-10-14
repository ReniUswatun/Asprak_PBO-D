package com.asprak.todo.data.entities;

public class PriorityTodo extends Todo {
  private int priority;

  // setter
  public void setPriority(int priority) {
    this.priority = priority;
  }

  // getter
  public int getPriority() {
    return priority;
  }
}
