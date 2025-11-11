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
    public Object log(@RequestBody LogUser loguser) {
        return userservice.login(loguser);
    }
    @PostMapping
    public Object register(@RequestBody LogUser loguser) {
        return userservice.register(loguser);
    }

}
