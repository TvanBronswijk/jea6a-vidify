package nl.fontys.vidify.db.mongo;

import nl.fontys.vidify.core.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
