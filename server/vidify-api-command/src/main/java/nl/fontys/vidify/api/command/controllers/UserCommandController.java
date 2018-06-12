package nl.fontys.vidify.api.command.controllers;

import nl.fontys.vidify.api.command.services.UserCommands;
import nl.fontys.vidify.core.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserCommandController extends BaseCommandController<User> {
    @Autowired
    public UserCommandController(UserCommands userCommands) {
        super(userCommands);
    }
}
