package nl.fontys.vidify.db.mongo;

import nl.fontys.vidify.core.models.User;
import nl.fontys.vidify.db.interfaces.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MongoUserManager implements UserManager {

    @Autowired
    private UserRepository repository;

    @Override
    public User create(User entity) {
        return repository.save(entity);
    }

    @Override
    public User update(User entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(String id) {
        repository.delete(getById(id));
    }

    @Override
    public User getByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public User getById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<User> getAll() {
        return repository.findAll();
    }
}
