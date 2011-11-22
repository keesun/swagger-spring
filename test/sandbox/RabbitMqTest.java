package sandbox;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

/**
 * Created by IntelliJ IDEA.
 * User: keesunbaik
 * Date: 11. 11. 17.
 * Time: 오후 10:22
 * To change this template use File | Settings | File Templates.
 */
public class RabbitMqTest {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        System.out.println("connect");

        AmqpAdmin admin = new RabbitAdmin(connectionFactory);

        String myQueueName = "myqueue";
        Queue myQueue = new Queue(myQueueName);
        admin.declareQueue(myQueue);
        admin.declareQueue(new Queue("sample"));

        AmqpTemplate template = new RabbitTemplate(connectionFactory);
//        template.convertAndSend(myQueueName, "foo");
//        System.out.println("send");

        // synchronously
//        String foo = (String) template.receiveAndConvert("myqueue");
//        System.out.println("receive");
//        System.out.println(foo);

        // asynchronously
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(myQueueName, "chat");
        container.setMessageListener(new MessageListenerAdapter(new HelloWorldHandler()));
        container.start();
    }

    static class HelloWorldHandler {
        public void handleMessage(String text) {
            System.out.println("Received: " + text);
        }
    }

}
