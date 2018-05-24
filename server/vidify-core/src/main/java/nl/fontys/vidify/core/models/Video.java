package nl.fontys.vidify.core.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Video {
    @Id
    private String id;
    private String url;
    private String name;
}
