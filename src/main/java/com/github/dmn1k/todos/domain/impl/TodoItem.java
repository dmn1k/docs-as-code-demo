package com.github.dmn1k.todos.domain.impl;

import com.github.dmn1k.todos.domain.api.TodoItemAnlegenDto;
import com.github.dmn1k.todos.domain.api.TodoItemInfo;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TodoItem implements Serializable, TodoItemInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    private LocalDate dueDate;

    public TodoItem() {
        // for jpa
    }

    public TodoItem(String description, LocalDate dueDate) {
        this.dueDate = dueDate;
        this.description = description;
    }

    public static TodoItem create(TodoItemAnlegenDto dto){
       return new TodoItem(dto.getDescription(), dto.getDueDate());
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}
