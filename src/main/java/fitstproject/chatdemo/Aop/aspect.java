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

        Map<String, Object> claims = new HashMap<>();
        claims.put("data", r);
        // 在 aspect.java 的 log 方法中替换现有密钥生成逻辑
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String jwt = Jwts.builder()
                .signWith(secretKey)  // 使用安全密钥
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 12 * 3600 * 1000))
                .compact();

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", jwt);

        result.setData(tokenMap);
        result.setMessage("成功");
        result.setCode("200");

        return result;
    }
}
