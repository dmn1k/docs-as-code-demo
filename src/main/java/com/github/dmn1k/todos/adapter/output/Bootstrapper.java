package com.github.dmn1k.todos.adapter.output;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.github.dmn1k.todos.domain.impl.TodoItem;
import com.github.dmn1k.todos.domain.ports.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

@Singleton
@Startup
public class Bootstrapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(Bootstrapper.class);
    
    private TodoRepository repository;

    @PostConstruct
    public void init() {
        addItem("Do laundry");
        addItem("Workout");
    }

    private void addItem(String desc) {
        TodoItem item = new TodoItem(desc, LocalDate.now());
        repository.persist(item);
        
        LOGGER.info("Persisted todo item {}", item);
    }
}
