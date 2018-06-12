package nl.fontys.vidify.api.controllers;

import nl.fontys.vidify.core.models.Playlist;
import nl.fontys.vidify.core.models.Video;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

    @RestController
    @RequestMapping("videos")
    public class VideoController extends BaseController<Video> {

        public VideoController(DiscoveryClient client) {
            super(client);
        }

        @Override
        protected String getQueryUri() {
            return client.getInstances("vidify-api-query").get(0).getUri() + "/videos/";
        }

        @Override
        protected String getCommandUri() {
            return client.getInstances("vidify-api-command").get(0).getUri() + "/videos/";
        }

        @Override
        protected Class<Video> getClassToken() {
            return Video.class;
        }
    }
