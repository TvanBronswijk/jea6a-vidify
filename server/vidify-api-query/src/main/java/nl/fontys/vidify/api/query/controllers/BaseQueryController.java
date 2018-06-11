package nl.fontys.vidify.api.query.controllers;

import nl.fontys.vidify.api.query.services.BaseQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

public class BaseQueryController<T> {

    private final BaseQueries<T> baseQueries;

    @Autowired
    public BaseQueryController(BaseQueries<T> baseQueries) {
        this.baseQueries = baseQueries;
    }

    @GetMapping("/{id}")
    public T get(@PathVariable String id) {
        return baseQueries.get(id);
    }

    @GetMapping()
    public Collection<T> getAll() {
        return baseQueries.getAll();
    }
}
