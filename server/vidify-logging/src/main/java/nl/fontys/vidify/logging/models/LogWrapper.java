package nl.fontys.vidify.logging.models;

import nl.fontys.vidify.core.models.logging.Log;
import nl.fontys.vidify.redis.wrapper.ObjectWrapper;

public class LogWrapper extends ObjectWrapper<Log> {

    public LogWrapper(Long id, Log object) {
        super(id, object);
    }
}
