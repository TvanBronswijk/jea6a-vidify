package nl.fontys.vidify.core.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class Video implements Serializable {
    @Id
    private String id;
    private String url;
    private String name;
}
