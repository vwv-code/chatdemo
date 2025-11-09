package fitstproject.chatdemo.service.impl;

import fitstproject.chatdemo.mapper.userMapper;
import fitstproject.chatdemo.pojo.LogUser;
import fitstproject.chatdemo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceimpl implements userService {
    @Autowired
    userMapper usermapper;
    @Override
    public LogUser login(LogUser loguser) {

        return usermapper.log(loguser);
    }

    @Override
    public void register(LogUser loguser) {
         usermapper.register(loguser);
    }

}
