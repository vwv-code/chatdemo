package fitstproject.chatdemo.service;

import fitstproject.chatdemo.pojo.LogUser;


public interface userService {
    public LogUser login(LogUser loguser);

    Object register(LogUser loguser);
}
