package nl.fontys.vidify.core.models.logging;

import nl.fontys.vidify.core.models.User;

import java.io.Serializable;


public class Log implements Serializable {

    private ContentType contentType;
    private String userId;
    private String message;

    public Log(ContentType contentType) {
        this.contentType = contentType;
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
