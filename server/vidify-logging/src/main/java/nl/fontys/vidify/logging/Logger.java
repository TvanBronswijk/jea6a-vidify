package nl.fontys.vidify.logging;

import nl.fontys.vidify.logging.models.Log;
import nl.fontys.vidify.redis.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Logger {

    private final RedisManager redis;

    @Autowired
    public Logger(RedisManager redis) {
        this.redis = redis;
    }

    public Log Log(String message) {
        Log entity = new Log();
        entity.setId(redis.generateId());
        entity.setMessage(message);
        redis.add(entity);
        System.out.println(entity.toString());
        return entity;
    }
}
