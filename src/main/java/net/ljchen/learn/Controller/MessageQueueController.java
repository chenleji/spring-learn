package net.ljchen.learn.Controller;

import net.ljchen.learn.Service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class MessageQueueController {
    @Autowired
    private AmqpService service;

    @RequestMapping(value = "/msg/{msg}", method = RequestMethod.POST)
    public ResponseEntity sendMsgToMq(@PathVariable String msg){
        service.sendMsg(msg);
        return ResponseEntity.ok("Done");
    }
}
