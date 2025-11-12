package fitstproject.chatdemo.interactor;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Base64;
import java.util.Date;

@Component
public class allinteractor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从请求头中获取token
        String token = request.getHeader("Authorization");
        // 验证token逻辑

            return true; // 放行
    }
    private boolean isValidToken(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }
        try {
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            // 不验证签名，只解析JWT并获取claims
            var jwt = Jwts.parserBuilder()
                    .build()
                    .parseClaimsJwt(token);
            var claims = jwt.getBody();
            // 检查token是否过期
            var expiration = claims.getExpiration();
            if (expiration != null) {
                return !expiration.before(new Date());
            }
            return true; // 如果没有设置过期时间，默认认为有效
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}
