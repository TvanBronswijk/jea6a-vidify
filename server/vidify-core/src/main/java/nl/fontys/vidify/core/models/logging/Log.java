package nl.fontys.vidify.core.models.logging;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Log implements Serializable {

    private ContentType contentType;
    private String userId;
    private String message;
    private Map<String, Object> metadata;

    public Log(ContentType contentType) {
        this.contentType = contentType;
        metadata = new HashMap<>();
    }

    public Log(ContentType contentType, String message) {
        this(contentType);
        this.message = message;
    }

    public Log(ContentType contentType, String message, String userId) {
        this(contentType, message);
        this.userId = userId;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getMetadata(String name) {
        return metadata.get(name);
    }

    public Set<Map.Entry<String, Object>> getMetadata() {
        return metadata.entrySet();
    }

    public void addMetadata(String name, Object object) {
        metadata.put(name, object);
    }

    @Override
    public String toString() {
        return "<" + message + "> by " + userId;
    }

    public enum ContentType {
        error,
        action,
        info
    }
}
