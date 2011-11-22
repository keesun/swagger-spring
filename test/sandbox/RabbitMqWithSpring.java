package sandbox;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by IntelliJ IDEA.
 * User: keesunbaik
 * Date: 11. 11. 18.
 * Time: 오전 9:02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("rabbitConfig.xml")
public class RabbitMqWithSpring {

    @Autowired RabbitTemplate rabbitTemplate;

    @Test
    public void di(){
        rabbitTemplate.convertAndSend("sample", "hello rabbit");
    }

}
