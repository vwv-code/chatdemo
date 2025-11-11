package fitstproject.chatdemo.Aop;

import fitstproject.chatdemo.pojo.result;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

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
        claims.put("token", r);
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "aXRjYXN0")
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 12 * 3600 * 1000))
                .compact();
        result.setData(jwt);
        result.setMessage("成功");
        result.setCode("200");

        return result;
    }
}
