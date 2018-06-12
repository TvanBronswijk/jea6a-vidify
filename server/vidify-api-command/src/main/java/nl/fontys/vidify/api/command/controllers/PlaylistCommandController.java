package nl.fontys.vidify.api.command.controllers;

import nl.fontys.vidify.api.command.services.PlaylistCommands;
import nl.fontys.vidify.core.models.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("playlists")
public class PlaylistCommandController extends BaseCommandController<Playlist> {
    @Autowired
    public PlaylistCommandController(PlaylistCommands playlistCommands) {
        super(playlistCommands);
    }
}
