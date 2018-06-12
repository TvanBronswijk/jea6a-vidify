package nl.fontys.vidify.api.query.services;

import nl.fontys.vidify.core.models.Playlist;
import nl.fontys.vidify.core.models.User;
import nl.fontys.vidify.db.interfaces.PlaylistQueryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PlaylistQueries extends BaseQueries<Playlist> {

    private final PlaylistQueryManager manager;

    @Autowired
    public PlaylistQueries(PlaylistQueryManager manager) {
        this.manager = manager;
    }

    public Collection<Playlist> getByUserId(String userId) {
        return manager.getByUserId(userId);
    }
}
