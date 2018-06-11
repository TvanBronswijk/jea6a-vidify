package nl.fontys.vidify.db.interfaces;

public interface BaseCommandManager<T> {
    T create(T entity);
    T update(T entity);
    void delete(String id);
}
