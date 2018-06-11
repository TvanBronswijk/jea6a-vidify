package nl.fontys.vidify.api.query.controllers;

import nl.fontys.vidify.api.query.services.UserQueries;
import nl.fontys.vidify.core.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserQueryController extends BaseQueryController<User> {

    private UserQueries userQueries;

    public UserQueryController(UserQueries userQueries) {
        super(userQueries);
        this.userQueries = userQueries;
    }

    @GetMapping("/username/{username}")
    public User get(@PathVariable String username) {
        return userQueries.getByUsername(username);
    }
}
