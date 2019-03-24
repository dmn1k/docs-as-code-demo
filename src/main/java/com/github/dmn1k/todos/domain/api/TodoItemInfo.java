package com.github.dmn1k.todos.domain.api;

import java.time.LocalDate;

public interface TodoItemInfo {
    long getId();

    String getDescription();

    LocalDate getDueDate();
}
