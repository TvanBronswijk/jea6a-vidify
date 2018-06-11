package nl.fontys.vidify.analyzer;

import nl.fontys.vidify.analyzer.videos.VideoAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"nl.fontys.vidify"})
@EnableMongoRepositories(basePackages = {"nl.fontys.vidify"})
public class VidifyApplication {

	private final VideoAnalyzer analyzer;

	@Autowired
	public VidifyApplication(VideoAnalyzer analyzer) {
		this.analyzer = analyzer;
	}

	public static void main(String[] args) {
		SpringApplication.run(VidifyApplication.class, args);
	}
}
