package fitstproject.chatdemo.service.impl;

import fitstproject.chatdemo.mapper.chatMapper;
import fitstproject.chatdemo.pojo.group;
import fitstproject.chatdemo.pojo.groupmessage;
import fitstproject.chatdemo.pojo.message;
import fitstproject.chatdemo.service.chatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class chatServiceimpl  implements chatService {
    @Autowired
    chatMapper chatmapper;
    @Override
    public void send(message message) {
        chatmapper.send(message);

    }

    @Override
    public Object getlist(int pageNum, int pageSize, int receiveId, int sendId) {
        return chatmapper.getlist((pageNum - 1) * pageSize, pageSize, sendId, receiveId);

    }

    @Override
    public void groupCreate(group groups) {
        for(Integer group:groups.getMemberIds())
            chatmapper.creategroup(group, groups.getGroupName());
    }

    @Override
    public void send(groupmessage gmessage) {
chatmapper.sendgm(gmessage);
    }

    @Override
    public Object getlist(int pageNum, int pageSize) {
        return chatmapper.getlistgn((pageNum - 1) * pageSize, pageSize);
    }

}
