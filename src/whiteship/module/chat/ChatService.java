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
    	System.out.println("=================send chat===============");
        repository.save(chat);
        exchange(chat);
        System.out.println(chat);
        System.out.println("=========================================");
    }

    private void exchange(Chat chat) {
        rabbitTemplate.convertAndSend("my-chat", chat.getId());
    }

}
