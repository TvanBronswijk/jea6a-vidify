package nl.fontys.vidify.api.command.services;

import nl.fontys.vidify.core.models.User;
import nl.fontys.vidify.db.interfaces.UserCommandManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCommands extends BaseCommands<User> {
}
