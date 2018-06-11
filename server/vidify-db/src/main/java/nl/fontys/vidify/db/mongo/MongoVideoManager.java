package nl.fontys.vidify.db.mongo;

import nl.fontys.vidify.core.models.Video;
import nl.fontys.vidify.db.interfaces.VideoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MongoVideoManager implements VideoManager {
    @Autowired
    private VideoRepository repository;

    @Override
    public Video create(Video entity) {
        return repository.save(entity);
    }

    @Override
    public Video update(Video entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(String id) {
        repository.delete(getById(id));
    }

    @Override
    public Video getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<Video> getAll() {
        return repository.findAll();
    }
}
