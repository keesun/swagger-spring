package whiteship.module.chat;

import org.springframework.data.mongodb.repository.MongoRepository;
import whiteship.domain.Chat;

/**
 * @author: keesunbaik
 */
public interface ChatRepository extends MongoRepository<Chat, String> {
}
