package nl.fontys.vidify.aggregator;

import nl.fontys.vidify.aggregator.videos.VideoAggregator;
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

	private final VideoAggregator aggregator;

    @Autowired
    public VidifyApplication(VideoAggregator aggregator) {
        this.aggregator = aggregator;
    }

    public static void main(String[] args) {
		SpringApplication.run(VidifyApplication.class, args);
	}
}
