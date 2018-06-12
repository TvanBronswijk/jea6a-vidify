package nl.fontys.vidify.db.mongo;

import nl.fontys.vidify.core.models.Playlist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

public interface PlaylistRepository extends MongoRepository<Playlist, String> {
    Collection<Playlist> findByUserId(String userId);
}
