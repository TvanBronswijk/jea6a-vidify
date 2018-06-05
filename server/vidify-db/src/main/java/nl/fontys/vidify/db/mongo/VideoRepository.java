package nl.fontys.vidify.db.mongo;

import nl.fontys.vidify.core.models.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<Video, String> {
}
