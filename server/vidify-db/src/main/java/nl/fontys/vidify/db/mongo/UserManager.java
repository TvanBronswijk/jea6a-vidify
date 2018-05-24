package nl.fontys.vidify.db.mongo;

import nl.fontys.vidify.core.models.User;
import nl.fontys.vidify.db.interfaces.UserCommandManager;
import nl.fontys.vidify.db.interfaces.UserQueryManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;

public class UserManager implements UserCommandManager, UserQueryManager {

    @Autowired
    private UserRepository users;

    @Override
    public User create(User entity) {
        return users.save(entity);
    }

    @Override
    public User update(User entity) {
        return users.save(entity);
    }

    @Override
    public void delete(User entity) {
        users.delete(entity);
    }

    @Override
    public User getByUsername(String username) {
        return users.findByUsername(username);
    }

    @Override
    public User getById(String id) {
        Optional<User> entry = users.findById(id);
        return entry.orElse(null);
    }

    @Override
    public Collection<User> getAll() {
        return users.findAll();
    }
}
