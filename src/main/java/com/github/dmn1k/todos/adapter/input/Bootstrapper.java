package com.github.dmn1k.todos.adapter.input;

import com.github.dmn1k.todos.domain.api.TodoItemAnlegenDto;
import com.github.dmn1k.todos.domain.api.TodoItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.time.LocalDate;

@Singleton
@Startup
public class Bootstrapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(Bootstrapper.class);

    @Inject
    private TodoItemService service;

    @PostConstruct
    public void init() {
        addItem("Do laundry");
        addItem("Workout");
    }

    private void addItem(String desc) {
        TodoItemAnlegenDto item = new TodoItemAnlegenDto(desc, LocalDate.now());
        service.persist(item);

        LOGGER.info("Persisted todo item {}", item);
    }
}
