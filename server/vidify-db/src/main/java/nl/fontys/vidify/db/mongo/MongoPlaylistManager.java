package nl.fontys.vidify.db.mongo;

import nl.fontys.vidify.core.models.Playlist;
import nl.fontys.vidify.db.interfaces.PlaylistManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MongoPlaylistManager implements PlaylistManager {

    @Autowired
    PlaylistRepository repository;

    @Override
    public Playlist create(Playlist entity) {
        return repository.save(entity);
    }

    @Override
    public Playlist update(Playlist entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(String id) {
        repository.delete(getById(id));
    }

    @Override
    public Playlist getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<Playlist> getAll() {
        return repository.findAll();
    }

    @Override
    public Collection<Playlist> getByUserId(String userId) {
        return repository.findByUserId(userId);
    }
}
