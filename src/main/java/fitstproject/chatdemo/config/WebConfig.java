package fitstproject.chatdemo.config;

import fitstproject.chatdemo.interactor.allinteractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
    public class WebConfig implements WebMvcConfigurer {

        //自定义的拦截器对象
        @Autowired
        private allinteractor demoInterceptor;

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            //注册自定义拦截器对象
            registry.addInterceptor(demoInterceptor).addPathPatterns("/**");//设置拦截器拦截的请求路径（ /** 表示拦截所有请求）
        }
    }

