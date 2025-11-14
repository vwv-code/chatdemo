package fitstproject.chatdemo.controller;

import fitstproject.chatdemo.pojo.*;
import fitstproject.chatdemo.service.chatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/chat")
@RestController
public class Chat {

    @Autowired
    chatService chatservice;
    @GetMapping("/single/name_list/{id}")
    public Object singleListName(@PathVariable int id) {
        return chatservice.getslist_name(id);
    }
    @PostMapping("/single/send")
    public Object singleSend(@RequestBody message message) {
        System.out.println(message);
        return  chatservice.send(message);
    }
    @GetMapping("/single/list/{sendId}/{receiveId}")
    public Object singleList(@PathVariable int sendId,@PathVariable int receiveId) {
        return  chatservice.getslist(sendId,receiveId);
    }
    @GetMapping("/group/list_name/{id}")
    public Object groupListName(@PathVariable int id) {
        System.out.println("groupListName");
        return chatservice.getlist_name(id);
    }
    @PostMapping("/group/create")
    public Object groupCreate(@RequestBody group  group) {
        return chatservice.groupCreate(group);
    }
    @PostMapping({"/group/send"})
    public Object groupSend(@RequestBody groupmessage gmessage) {
        return chatservice.send(gmessage);

    }
    @GetMapping("/group/list/{sendId}/{groupName}")
    public Object groupList(@PathVariable int sendId, @PathVariable String groupName) {
        return chatservice.getlist(sendId, groupName);

    }

}
