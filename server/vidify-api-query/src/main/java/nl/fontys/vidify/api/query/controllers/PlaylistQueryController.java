package nl.fontys.vidify.api.query.controllers;

import nl.fontys.vidify.api.query.services.BaseQueries;
import nl.fontys.vidify.api.query.services.PlaylistQueries;
import nl.fontys.vidify.core.models.Playlist;
import nl.fontys.vidify.core.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("playlists")
public class PlaylistQueryController extends BaseQueryController<Playlist> {

    @Autowired
    PlaylistQueries playlistQueries;

    public PlaylistQueryController(PlaylistQueries playlistQueries) {
        super(playlistQueries);
    }

    @GetMapping("/user/{id}")
    public Collection<Playlist> getByUserId(@PathVariable String id) {
        return playlistQueries.getByUserId(id);
    }
}
