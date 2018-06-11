package nl.fontys.vidify.logging;

import nl.fontys.vidify.core.models.logging.Log;
import nl.fontys.vidify.logging.models.LogWrapper;
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

    public Log log(String message, String userId) {
        Log log = new Log(Log.ContentType.action, message, userId);
        return log(log);
    }

    public Log log(String message) {
        Log log = new Log(Log.ContentType.action, message);
        return log(log);
    }

    public Log log(Log log) {
        LogWrapper redisLog = new LogWrapper(redis.generateId(), log);
        redis.add(redisLog);
        System.out.println(log.toString());
        return log;
    }
}
