package fitstproject.chatdemo.interactor;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Base64;

@Component
public class allinteractor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从请求头中获取token
        String token = request.getHeader("Authorization");

        // 验证token逻辑
        if (isValidToken(token)) {
            return true; // 放行
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false; // 拒绝访问
        }
    }

    private boolean isValidToken(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }

        try {
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
                System.out.println(token);
            }
            // 如果密钥是Base64编码的，可能需要解码
            byte[] keyBytes = Base64.getDecoder().decode("aXRjYXN0");
            Jwts.parser().setSigningKey(keyBytes).parseClaimsJws(token);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
