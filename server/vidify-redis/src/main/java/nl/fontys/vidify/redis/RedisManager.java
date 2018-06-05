package nl.fontys.vidify.redis;

import nl.fontys.vidify.redis.interfaces.RedisObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RedisManager {
    public final String KEY = "_vidify_";

    private final RedisTemplate<String, Object> redis;
    private final HashOperations<String, Long, RedisObject> hash;

    @Autowired
    public RedisManager(RedisTemplate<String, Object> redis) {
        this.redis = redis;
        hash = this.redis.opsForHash();
    }

    public void add(RedisObject entity) {
        hash.put(KEY, entity.getId(), entity);
    }

    public void delete(Long id) {
        hash.delete(KEY, id);
    }

    public RedisObject get(Long id) {
        return hash.get(KEY, id);
    }

    public Map<Long, RedisObject> getAll() {
        return hash.entries(KEY);
    }

    public Long generateId() {
        return hash.keys(KEY).stream().max(Long::compare).orElse(0L) + 1L;
    }
}
