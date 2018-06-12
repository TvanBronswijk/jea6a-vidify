package nl.fontys.vidify.api.command.controllers;

import nl.fontys.vidify.api.command.services.VideoCommands;
import nl.fontys.vidify.core.models.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("videos")
public class VideoCommandController extends BaseCommandController<Video> {
    @Autowired
    public VideoCommandController(VideoCommands videoCommands) {
        super(videoCommands);
    }
}
