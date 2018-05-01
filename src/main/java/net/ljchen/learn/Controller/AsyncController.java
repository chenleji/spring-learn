package net.ljchen.learn.Controller;

import net.ljchen.learn.Service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncService service;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity addAsyncService(){
        service.asyncJob();
        return ResponseEntity.ok("Done");
    }
}
