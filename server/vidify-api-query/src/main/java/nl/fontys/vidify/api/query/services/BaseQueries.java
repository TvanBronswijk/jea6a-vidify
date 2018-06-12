package nl.fontys.vidify.api.query.services;

import nl.fontys.vidify.core.models.logging.Log;
import nl.fontys.vidify.db.interfaces.BaseQueryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collection;

public abstract class BaseQueries<T> {

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private BaseQueryManager<T> manager;

    public T get(String id) {
        log(id + " retrieved.");
        return manager.getById(id);
    }

    public Collection<T> getAll() {
        return manager.getAll();
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
