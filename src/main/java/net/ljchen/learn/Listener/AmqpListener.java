package net.ljchen.learn.Listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "test.queue")
public class AmqpListener {

    private static Logger LOGGER = LoggerFactory.getLogger(AmqpListener.class);

    @RabbitHandler
    public void processMsg(String msg){
        LOGGER.info("AMQP listener receive msg:" + msg);
    }
}
