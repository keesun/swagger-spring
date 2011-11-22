package whiteship.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "chats")
public class Chat {

    @Id
    private String id;
    String from;
    String message;
    Date created;

    public Chat(){

    }

    public Chat(String from, String message) {
        this.from = from;
        this.message = message;
        this.created = new Date();
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "created=" + created +
                ", message='" + message + '\'' +
                ", from='" + from + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
