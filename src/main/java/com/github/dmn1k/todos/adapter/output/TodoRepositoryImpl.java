package com.github.dmn1k.todos.adapter.output;

import com.github.dmn1k.todos.domain.api.TodoItemInfo;
import com.github.dmn1k.todos.domain.impl.TodoItem;
import com.github.dmn1k.todos.domain.ports.TodoRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

public class TodoRepositoryImpl implements TodoRepository {
    @PersistenceContext(unitName = "todos")
    private EntityManager em;

    @Override
    public Optional<TodoItemInfo> find(long id){
        return Optional.ofNullable(em.find(TodoItem.class, id));
    }

    @Override
    public void persist(TodoItem item){
        em.persist(item);
    }
}
