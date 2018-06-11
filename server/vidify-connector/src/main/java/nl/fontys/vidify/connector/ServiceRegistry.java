package nl.fontys.vidify.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collection;

@EnableEurekaServer
@SpringBootApplication
public class ServiceRegistry {

    @Autowired
    ServiceController services;

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistry.class, args);
    }

    @Controller
    public class ServiceController {

        @Autowired
        DiscoveryClient client;

        @GetMapping("/services")
        public Collection<String> getAll() {
            return client.getServices();
        }
    }
}


