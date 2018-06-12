package nl.fontys.vidify.api.query.services;

import nl.fontys.vidify.core.models.Video;
import nl.fontys.vidify.db.interfaces.UserQueryManager;
import nl.fontys.vidify.db.interfaces.VideoQueryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoQueries extends BaseQueries<Video> {
    @Autowired
    public VideoQueries(VideoQueryManager manager) {
    }
}
