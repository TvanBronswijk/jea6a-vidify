package nl.fontys.vidify.aggregator.videos;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import nl.fontys.vidify.core.models.Video;
import nl.fontys.vidify.db.interfaces.VideoManager;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class VideoAggregator {

    private final String API_URL = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=1&order=date&type=video&key=AIzaSyD7-WPxfMRLERCLmIFjeVrLh9RvlBnuFsE&id=";

    private final VideoManager videoManager;

    @Autowired
    public VideoAggregator(VideoManager videoManager) {
        this.videoManager = videoManager;
    }

    @Scheduled(fixedRate = 5000)
    public void aggregate() throws UnirestException {
        System.out.println("Aggregating...");
        JSONObject result = Unirest.get(API_URL)
                .asJson()
                .getBody()
                .getObject();

        if(result.getJSONArray("items").length() == 0){
            System.out.println("No such video found");
            return;
        }

        Video entity = new Video();
        JSONObject element = result.getJSONArray("items").getJSONObject(0);
        entity.setId(element.getJSONObject("id").getString("videoId"));
        entity.setUrl("http://youtube.com/watch?v=" + element.getJSONObject("id").getString("videoId"));
        entity.setName(element.getJSONObject("snippet").getString("title"));

        videoManager.create(entity);

        System.out.println("added: " + entity.getName() + "||" + entity.getUrl());
    }
}
