package sandbox;

import com.mongodb.Mongo;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import whiteship.domain.Chat;

import java.net.UnknownHostException;
import java.util.Date;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @author: keesunbaik
 */
public class MongoDBTest {

    public static void main(String[] args) throws UnknownHostException {
        MongoOperations mongoOps = new MongoTemplate(new Mongo(), "database");
        String collectionName = "sample";
        mongoOps.createCollection(collectionName);
        Chat chat = new Chat("keesun", "Hi");
        mongoOps.insert(chat, collectionName);
        System.out.println((mongoOps.findOne(new Query(where("from").is(chat.getFrom())), Chat.class)));
        mongoOps.dropCollection(collectionName);
    }
}
