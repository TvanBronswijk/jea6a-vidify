package nl.fontys.vidify.core.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Collection;

@Data
public class Playlist {
    @Id
    private String id;
    private User user;
    private Collection<Video> videos;
}
