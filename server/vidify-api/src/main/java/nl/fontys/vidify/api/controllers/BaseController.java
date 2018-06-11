package nl.fontys.vidify.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;

@RestController
public abstract class BaseController<T> {

    protected final DiscoveryClient client;

    public BaseController(DiscoveryClient client) {
        this.client = client;
    }

    protected abstract URI getQueryUri();
    protected abstract URI getCommandUri();
    protected abstract Class<T> getClassToken();

    @GetMapping("/{id}")
    public T get(@PathVariable String id) {
        return new RestTemplate()
                .getForEntity(getQueryUri().resolve(id), getClassToken())
                .getBody();
    }

    @GetMapping
    public Collection<T> getAll() {
        return new RestTemplate()
                .exchange(getQueryUri(), HttpMethod.GET, null,
                new ParameterizedTypeReference<Collection<T>>(){})
                .getBody();
    }

    @PostMapping
    public void create(T entity) {
        new RestTemplate()
                .postForEntity(getCommandUri(), entity, getClassToken());
    }

    @PutMapping
    public void update(T entity) {
        new RestTemplate()
                .put(getCommandUri(), entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        new RestTemplate()
                .delete(getCommandUri().resolve(id));
    }
}
