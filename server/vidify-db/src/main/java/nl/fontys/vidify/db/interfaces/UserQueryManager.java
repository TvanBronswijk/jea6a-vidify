package nl.fontys.vidify.db.interfaces;

import nl.fontys.vidify.core.models.User;

public interface UserQueryManager extends BaseQueryManager<User> {
    User getByUsername(String username);
}
