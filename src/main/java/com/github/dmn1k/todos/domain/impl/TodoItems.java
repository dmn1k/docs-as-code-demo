package com.github.dmn1k.todos.domain.impl;

import com.github.dmn1k.todos.domain.api.TodoItemAnlegenDto;
import com.github.dmn1k.todos.domain.api.TodoItemInfo;
import com.github.dmn1k.todos.domain.api.TodoItemService;
import com.github.dmn1k.todos.domain.ports.TodoRepository;

import javax.inject.Inject;
import java.util.Optional;

public class TodoItems implements TodoItemService {

    @Inject
    private TodoRepository repository;

    @Override
    public Optional<TodoItemInfo> find(long id) {
        return repository.find(id);
    }

    @Override
    public void persist(TodoItemAnlegenDto item) {
        TodoItem todoItem = TodoItem.create(item);
        repository.persist(todoItem);
    }
}
