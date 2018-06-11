package nl.fontys.vidify.redis.wrapper;

import nl.fontys.vidify.redis.interfaces.RedisObject;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Log")
public class ObjectWrapper<T> implements RedisObject, Serializable {

    private Long id;
    private T object;

    public ObjectWrapper(Long id, T object) {
        this.id = id;
        this.object = object;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
