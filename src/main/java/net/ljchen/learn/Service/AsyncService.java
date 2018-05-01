package net.ljchen.learn.Service;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AsyncService {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(AsyncService.class);

    @Async
    public void asyncJob(){
        Random random = new Random();
        long millis = random.nextInt(3000);
        try {
            Thread.sleep(millis);
            logger.info("AsyncService complete ...");
        } catch (Exception e) {
            logger.info("AsyncService fail ...");
        }
    }
}
