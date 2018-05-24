package nl.fontys.vidify.db.interfaces;

import java.util.Collection;

public interface BaseQueryManager<T> {
    T getById(String id);
    Collection<T> getAll();
}
