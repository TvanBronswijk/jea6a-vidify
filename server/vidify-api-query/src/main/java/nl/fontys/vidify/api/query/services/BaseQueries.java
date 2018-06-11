package nl.fontys.vidify.api.query.services;

import nl.fontys.vidify.db.interfaces.BaseQueryManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public abstract class BaseQueries<T> {

    @Autowired
    private BaseQueryManager<T> manager;

    public T get(String id) {
        return manager.getById(id);
    }

    public Collection<T> getAll() {
        return manager.getAll();
    }
}
