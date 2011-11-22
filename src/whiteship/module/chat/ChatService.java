package whiteship.module.chat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whiteship.domain.Chat;

@Service
public class ChatService {

    @Autowired RabbitTemplate rabbitTemplate;
    @Autowired ChatRepository repository;

    public void send(Chat chat){
        repository.save(chat);
        exchange(chat);
    }

    private void exchange(Chat chat) {
        rabbitTemplate.convertAndSend("myq", chat.getId());
    }

}
