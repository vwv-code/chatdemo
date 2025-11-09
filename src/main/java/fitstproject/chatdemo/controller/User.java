package fitstproject.chatdemo.controller;

import fitstproject.chatdemo.pojo.LogUser;
import fitstproject.chatdemo.pojo.result;
import fitstproject.chatdemo.service.userService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequestMapping("/user")
@RestController
public class User {
    @Autowired
    private userService userservice;
    @GetMapping
    public result log(@RequestBody LogUser loguser) {
        result result = new result();
            Map<String, Object> claims = new HashMap<>();
            Object m=userservice.login(loguser);
            if(m==null) {
                result.setMessage("message:用户名或密码错误");
                return result;
            }
            claims.put("username", loguser.getUsername());
            claims.put("password", loguser.getPassword());

            String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "aXRjYXN0")
                    .addClaims(claims)
                    .setExpiration(new Date(System.currentTimeMillis() + 12 * 3600 * 1000))
                    .compact();
        result.setData(jwt);
        return result;
    }
    @PostMapping
    public result register(@RequestBody LogUser loguser) {
        result result = new result();
        userservice.register(loguser);
        result.setMessage("message:注册成功");
        return result;
    }

}
