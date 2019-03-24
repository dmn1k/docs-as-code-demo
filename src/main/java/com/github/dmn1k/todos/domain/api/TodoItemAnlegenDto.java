package com.github.dmn1k.todos.domain.api;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.time.LocalDate;

public class TodoItemAnlegenDto {
    private String description;
    private LocalDate dueDate;

    @JsonCreator
    public TodoItemAnlegenDto(String description, LocalDate dueDate) {
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
