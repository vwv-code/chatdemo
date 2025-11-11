package fitstproject.chatdemo.service;

import fitstproject.chatdemo.pojo.group;
import fitstproject.chatdemo.pojo.groupmessage;
import fitstproject.chatdemo.pojo.message;

public interface chatService {
    Object send(message message);


    Object getlist(int pageNum, int pageSize, int receiveId, int sendId);

    Object groupCreate(group group);

    Object send(groupmessage gmessage);

    Object getlist(int pageNum, int pageSize);
}
