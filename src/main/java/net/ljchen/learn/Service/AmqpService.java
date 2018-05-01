package net.ljchen.learn.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 -e RABBITMQ_DEFAULT_USER=root -e RABBITMQ_DEFAULT_PASS=password rabbitmq:3-management
*/

@Service
public class AmqpService {

    private static Logger LOGGER = LoggerFactory.getLogger(AmqpService.class);

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    public void sendMsg(String msg) {
        LOGGER.info("amqp send msg: " + msg);
        rabbitmqTemplate.convertAndSend("test.queue", msg);
    }
}
