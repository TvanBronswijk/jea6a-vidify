package nl.fontys.vidify.api.command.services;

import nl.fontys.vidify.core.models.logging.Log;
import nl.fontys.vidify.db.interfaces.BaseCommandManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public abstract class BaseCommands<T> {

    @Autowired
    DiscoveryClient client;

    @Autowired
    private BaseCommandManager<T> manager;


    public void create(T entity) {
        log(entity, "Entity created.");
        manager.create(entity);
    }

    public void update(T entity) {
        log(entity, "Entity updated.");
        manager.update(entity);
    }

    public void delete(String id) {
        log("Entity deleted.");
        manager.delete(id);
    }

    protected void log(String message){
        Log log = new Log(Log.ContentType.action, message);

        log(log);
    }

    protected void log(T entity, String message){
        Log log = new Log(Log.ContentType.action, message);
        log.addMetadata("object", entity);

        log(log);
    }

    private void log(Log log) {
        try {
            URI loggingUri = client.getInstances("vidify-logger").get(0).getUri();
            new RestTemplate().postForEntity(loggingUri, log, Log.class);
            System.out.println(log);
        } catch(Exception e) {
            System.out.println(log.toString() + " || NOT LOGGED");
        }
    }
}
