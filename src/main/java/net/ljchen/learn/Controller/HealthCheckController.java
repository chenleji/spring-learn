package net.ljchen.learn.Controller;

import net.ljchen.learn.Form.Health;
import net.ljchen.learn.Service.OrchestrationHealth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("!dev")
@RestController
public class HealthCheckController {

    @Autowired
    private OrchestrationHealth orchestrationHealth;

    @GetMapping("/health")
    public ResponseEntity getHealthStatus(){
        return ResponseEntity.ok(new Health("ok"));
    }

    @GetMapping("/health/orchestration")
    public ResponseEntity getOrchestrationHealthStatus(){
        return ResponseEntity.ok(orchestrationHealth.getHealth());
    }
}
