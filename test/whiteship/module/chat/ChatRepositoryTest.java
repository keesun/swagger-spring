package whiteship.module.chat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import whiteship.domain.Chat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

/**
 * @author: keesunbaik
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ChatRepositoryTest {

    @SuppressWarnings({"SpringJavaAutowiringInspection"})
    @Autowired ChatRepository repository;

    @Test
    public void di(){
        repository.deleteAll();

        Chat chat = new Chat("keesun", "hello uzin");
        repository.save(chat);
        List<Chat> chatList = repository.findAll();
        assertThat(chatList.size(), is(1));
    }
}
