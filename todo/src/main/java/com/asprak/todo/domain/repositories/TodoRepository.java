package com.asprak.todo.domain.repositories;

import com.asprak.todo.data.entities.Todo;

public interface TodoRepository {
  boolean create(int index, Todo todo) throws Exception;

  Todo[] getAll();

  boolean updateCompleted(int index);

  boolean delete(int index);
}
