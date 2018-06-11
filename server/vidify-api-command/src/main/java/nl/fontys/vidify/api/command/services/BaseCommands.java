package nl.fontys.vidify.api.command.services;

import com.netflix.discovery.EurekaClient;
import nl.fontys.vidify.db.interfaces.BaseCommandManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;

public abstract class BaseCommands<T> {

    @Autowired
    private EurekaClient client;

    @Autowired
    private BaseCommandManager<T> manager;


    public void create(T entity) {
        manager.create(entity);
    }

    public void update(T entity) {
        manager.update(entity);
    }

    public void delete(String id) {
        manager.delete(id);
    }
}
