package fitstproject.chatdemo.Aop;

import fitstproject.chatdemo.pojo.result;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

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
        byte[] keyBytes = Base64.getDecoder().decode("aXRjYXN0");
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256,keyBytes)
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
