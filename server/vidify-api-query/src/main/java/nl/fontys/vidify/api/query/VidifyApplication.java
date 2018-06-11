package nl.fontys.vidify.api.query;

import nl.fontys.vidify.api.query.controllers.UserQueryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {"nl.fontys.vidify"})
@EnableMongoRepositories(basePackages = {"nl.fontys.vidify"})
@EnableDiscoveryClient
public class VidifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(VidifyApplication.class, args);
	}
}
