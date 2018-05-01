package net.ljchen.learn.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
@FeignClient(value = "orchestration")
public interface OrchestrationHealth {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    String getHealth();
}
