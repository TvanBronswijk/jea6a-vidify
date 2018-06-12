package nl.fontys.vidify.api.command.services;

import nl.fontys.vidify.core.models.Playlist;
import nl.fontys.vidify.db.interfaces.BaseCommandManager;
import nl.fontys.vidify.db.interfaces.PlaylistCommandManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlaylistCommands extends BaseCommands<Playlist> {

    @Autowired
    private PlaylistCommandManager manager;

    @Override
    public void create(Playlist entity) {
        log(entity, "Entity created.");
        entity.setVideos(new ArrayList<>());
        manager.create(entity);
    }
}
