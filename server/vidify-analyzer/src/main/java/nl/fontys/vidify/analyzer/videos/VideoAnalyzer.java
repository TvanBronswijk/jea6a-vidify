package nl.fontys.vidify.analyzer.videos;

import nl.fontys.vidify.core.models.logging.Log;
import nl.fontys.vidify.db.interfaces.VideoManager;
import nl.fontys.vidify.redis.RedisManager;
import nl.fontys.vidify.redis.wrapper.ObjectWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoAnalyzer {

    private final RedisManager redis;
    private final VideoManager videoManager;

    @Autowired
    public VideoAnalyzer(RedisManager redisManager, VideoManager videoManager) {
        this.redis = redisManager;
        this.videoManager = videoManager;
    }

    @Scheduled(fixedRate = 500000)
    public void analyze() {
        System.out.println("Start analyzing Action Logs...");
        List<Log> actionLogs = redis.getAll()
                .values()
                .stream()
                .map(redisobject -> ((ObjectWrapper<Log>)redisobject).getObject())
                .filter(log -> log.getContentType().equals(Log.ContentType.action))
                .collect(Collectors.toList());

        for(Log l : actionLogs) {
            System.out.println(l);
        }
    }
}
