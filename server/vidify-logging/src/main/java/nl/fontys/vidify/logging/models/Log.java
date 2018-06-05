package nl.fontys.vidify.logging.models;

import nl.fontys.vidify.redis.interfaces.RedisObject;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Log")
public class Log implements RedisObject, Serializable {

    private Long Id;
    private String message;

    @Override
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Log{" +
                "Id=" + Id +
                ", message='" + message + '\'' +
                '}';
    }
}
