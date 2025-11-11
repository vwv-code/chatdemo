package fitstproject.chatdemo.controller;

import fitstproject.chatdemo.pojo.*;
import fitstproject.chatdemo.service.chatService;
import fitstproject.chatdemo.service.userService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequestMapping("/chat")
@RestController
public class Chat {

    @Autowired
    chatService chatservice;
    @PostMapping("/single/send")
    public Object singleSend(@RequestBody message message) {
        return  chatservice.send(message);

    }
    @GetMapping("/single/list/{pageNum}/{pageSize}/{receiveId}/{sendId}")
    public Object singleList(@PathVariable int pageNum, @PathVariable int pageSize,@PathVariable int receiveId,@PathVariable int sendId) {
        return  chatservice.getlist(pageNum, pageSize, receiveId, sendId);
    }
    @PostMapping("/group/create")
    public Object groupCreate(@RequestBody group  group) {
        return chatservice.groupCreate(group);
    }
    @PostMapping({"/group/send"})
    public Object groupSend(@RequestBody groupmessage gmessage) {

        return chatservice.send(gmessage);

    }
    @GetMapping("/group/list/{pageNum}/{pageSize}")
    public Object groupList(@PathVariable int pageNum, @PathVariable int pageSize) {
        return chatservice.getlist(pageNum, pageSize);

    }

}
