package nl.fontys.vidify.api.controllers;

import nl.fontys.vidify.core.models.User;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;

import java.net.URI;

@RestController
@RequestMapping("users")
public class UserController extends BaseController<User> {

    public UserController(DiscoveryClient client) {
        super(client);
    }

    @Override
    protected String getQueryUri() {
        return client.getInstances("vidify-api-query").get(0).getUri() + "/users/";
    }

    @Override
    protected String getCommandUri() {
        return client.getInstances("vidify-api-command").get(0).getUri() + "/users/";
    }

    @Override
    protected Class<User> getClassToken() {
        return User.class;
    }

    @GetMapping("/username/{username}")
    public User get(@PathVariable String username) {
        return new RestTemplate()
                .getForEntity(getQueryUri() + "username/" + username, getClassToken())
                .getBody();
    }
}
