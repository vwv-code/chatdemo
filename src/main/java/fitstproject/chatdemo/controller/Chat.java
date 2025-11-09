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
    public result singleSend(@RequestBody message message) {

        result result = new result();
        chatservice.send(message);
        result.setMessage("message:发送成功");
        return result;
    }
    @GetMapping("/single/list/{pageNum}/{pageSize}/{receiveId}/{sendId}")
    public result singleList(@PathVariable int pageNum, @PathVariable int pageSize,@PathVariable int receiveId,@PathVariable int sendId) {

        result result = new result();
        result.setData(chatservice.getlist(pageNum, pageSize, receiveId, sendId));
        result.setMessage("message:获取成功");
        return result;
    }
    @PostMapping("/group/create")
    public result groupCreate(@RequestBody group  group) {

        result result = new result();
        chatservice.groupCreate(group);
        result.setMessage("message:创建成功");
        return result;
    }
    @PostMapping({"/group/send"})
    public result groupSend(@RequestBody groupmessage gmessage) {

        result result = new result();
        chatservice.send(gmessage);
        result.setMessage("message:发送成功");
        return result;
    }
    @GetMapping("/group/list/{pageNum}/{pageSize}")
    public result groupList(@PathVariable int pageNum, @PathVariable int pageSize) {

        result result = new result();
        result.setData(chatservice.getlist(pageNum, pageSize));
        result.setMessage("message:获取成功");
        return result;
    }

}
