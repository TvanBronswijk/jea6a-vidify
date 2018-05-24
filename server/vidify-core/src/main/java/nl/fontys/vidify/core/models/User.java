package nl.fontys.vidify.core.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {
    @Id
    private String id;
    private String username;
    private String password;
}
