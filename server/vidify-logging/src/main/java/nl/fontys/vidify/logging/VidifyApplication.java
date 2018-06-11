package nl.fontys.vidify.logging;

import nl.fontys.vidify.core.models.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {"nl.fontys.vidify"})
@EnableDiscoveryClient
public class VidifyApplication {

	private final Logger logger;

	@Autowired
	public VidifyApplication(Logger logger) {
		this.logger = logger;
        logger.log(new Log(Log.ContentType.info, "Logger online"));
	}

	public static void main(String[] args) {
		SpringApplication.run(VidifyApplication.class, args);
	}
}
