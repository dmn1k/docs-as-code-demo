package com.github.dmn1k.todos.domain.ports;

import com.github.dmn1k.todos.domain.api.TodoItemInfo;
import com.github.dmn1k.todos.domain.impl.TodoItem;

import java.util.Optional;

public interface TodoRepository {
    Optional<TodoItemInfo> find(long id);

    void persist(TodoItemInfo item);
}
