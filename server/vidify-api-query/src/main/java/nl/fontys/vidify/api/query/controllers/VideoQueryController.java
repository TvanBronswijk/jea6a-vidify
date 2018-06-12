package nl.fontys.vidify.api.query.controllers;

import nl.fontys.vidify.api.query.services.VideoQueries;
import nl.fontys.vidify.core.models.Video;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("videos")
public class VideoQueryController extends BaseQueryController<Video> {
    public VideoQueryController(VideoQueries videoQueries) {
        super(videoQueries);
    }
}
