package whiteship.module.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import whiteship.domain.Chat;

@Controller
public class ChatController {

    @Autowired
    ChatService service;

    @RequestMapping(value = "/send/from/{from}/message/{message}")
    public @ResponseBody String send(Chat chat) {
        service.send(chat);
        return "ok";
    }

}
