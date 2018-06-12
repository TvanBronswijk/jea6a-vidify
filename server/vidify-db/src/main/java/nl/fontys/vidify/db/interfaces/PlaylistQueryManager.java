package nl.fontys.vidify.db.interfaces;

import nl.fontys.vidify.core.models.Playlist;

import java.util.Collection;

public interface PlaylistQueryManager extends BaseQueryManager<Playlist> {
    Collection<Playlist> getByUserId(String userId);
}
