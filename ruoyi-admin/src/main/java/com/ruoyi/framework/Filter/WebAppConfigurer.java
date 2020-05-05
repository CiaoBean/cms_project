package com.ruoyi.framework.Filter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebAppConfigurer  implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个
        registry.addInterceptor(new MyHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/logout")
                .excludePathPatterns("/favicon.ico**")
                .excludePathPatterns("/ruoyi.png**")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/docs/**")
                .excludePathPatterns("/fonts/**")
                .excludePathPatterns("/img/**")
                .excludePathPatterns("/ajax/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/ruoyi/**")
                .excludePathPatterns("/captcha/captchaImage**")
                .excludePathPatterns("/drawCode")
                .excludePathPatterns("Scripts/**")
        ;
    }

}
