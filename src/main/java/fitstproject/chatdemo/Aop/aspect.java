package fitstproject.chatdemo.Aop;

import fitstproject.chatdemo.pojo.result;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@Aspect
public class aspect {
    @Around("execution(* fitstproject.chatdemo.controller.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        result result = new result();
        Object r = joinPoint.proceed();
        result.setData(r);
        result.setMessage("成功");
        result.setCode("200");

        return result;
    }
}
