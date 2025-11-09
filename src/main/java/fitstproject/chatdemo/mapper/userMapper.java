package fitstproject.chatdemo.mapper;

import fitstproject.chatdemo.pojo.LogUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
public interface userMapper {
    @Insert("insert into user(username,password) values(#{username},#{password})")
   void register(LogUser loguser);

    @Select("select * from user where username=#{username} and password=#{password}")
    LogUser log(LogUser loguser);
}
