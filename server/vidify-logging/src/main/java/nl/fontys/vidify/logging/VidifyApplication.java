package nl.fontys.vidify.logging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {"nl.fontys.vidify"})
public class VidifyApplication {

	private final Logger logger;

	@Autowired
	public VidifyApplication(Logger logger) {
		this.logger = logger;
        logger.Log("hello world!");
	}

	public static void main(String[] args) {
		SpringApplication.run(VidifyApplication.class, args);
	}
}
