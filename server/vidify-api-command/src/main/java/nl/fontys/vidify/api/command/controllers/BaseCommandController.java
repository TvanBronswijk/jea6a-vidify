package nl.fontys.vidify.api.command.controllers;

import nl.fontys.vidify.api.command.services.BaseCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public abstract class BaseCommandController<T> {

    private final BaseCommands<T> baseCommands;

    @Autowired
    public BaseCommandController(BaseCommands<T> baseCommands) {
        this.baseCommands = baseCommands;
    }

    @PostMapping
    public void create(@RequestBody T entity) {
        baseCommands.create(entity);
    }

    @PutMapping
    public void update(@RequestBody T entity) {
        baseCommands.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        baseCommands.delete(id);
    }
}
