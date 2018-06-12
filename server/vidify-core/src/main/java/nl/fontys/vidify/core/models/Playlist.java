package nl.fontys.vidify.core.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Collection;

@Data
public class Playlist implements Serializable {
    @Id
    private String id;
    private String name;
    private String userId;
    private Collection<Video> videos;
}
