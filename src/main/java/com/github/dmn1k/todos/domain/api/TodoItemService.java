package com.github.dmn1k.todos.domain.api;

import java.util.Optional;

public interface TodoItemService {
    Optional<TodoItemInfo> find(long id);

    void persist(TodoItemAnlegenDto item);
}
