package net.ljchen.learn.Timer;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronJob {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(CronJob.class);

    @Scheduled(cron = "*/5 * * * * ?")
    public void watchDog(){
        logger.info("wang wang wang ....");
    }
}
