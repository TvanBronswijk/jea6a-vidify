package nl.fontys.vidify.api.controllers;

import nl.fontys.vidify.core.models.Playlist;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("playlists")
public class PlaylistController extends BaseController<Playlist> {

    public PlaylistController(DiscoveryClient client) {
        super(client);
    }

    @Override
    protected String getQueryUri() {
        return client.getInstances("vidify-api-query").get(0).getUri() + "/playlists/";
    }

    @Override
    protected String getCommandUri() {
        return client.getInstances("vidify-api-command").get(0).getUri() + "/playlists/";
    }

    @GetMapping("user/{id}")
    public Collection<Playlist> getByUser(@PathVariable String id) {
        return new RestTemplate()
                .exchange(getQueryUri() + "user/" + id, HttpMethod.GET, null,
                        new ParameterizedTypeReference<Collection<Playlist>>(){})
                .getBody();
    }

    @Override
    protected Class<Playlist> getClassToken() {
        return Playlist.class;
    }
}
