package nl.fontys.vidify.api.command.controllers;

import nl.fontys.vidify.api.command.services.BaseCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public abstract class BaseCommandController<T> {

    private final BaseCommands<T> baseCommands;

    @Autowired
    public BaseCommandController(BaseCommands<T> baseCommands) {
        this.baseCommands = baseCommands;
    }

    @PostMapping
    public void create(T entity) {
        baseCommands.create(entity);
    }

    @PutMapping
    public void update(T entity) {
        baseCommands.update(entity);
    }

    @DeleteMapping
    public void delete(String id) {
        baseCommands.delete(id);
    }
}
