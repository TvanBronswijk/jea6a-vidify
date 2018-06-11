package nl.fontys.vidify.api.query.services;

import nl.fontys.vidify.core.models.User;
import nl.fontys.vidify.db.interfaces.UserQueryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserQueries extends BaseQueries<User> {

    private final UserQueryManager manager;

    @Autowired
    public UserQueries(UserQueryManager manager) {
        this.manager = manager;
    }

    public User getByUsername(String username) {
        return manager.getByUsername(username);
    }

}
