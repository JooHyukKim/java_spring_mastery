package com.example.filter.config;

import com.example.filter.interceptor.AuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {

    // @Autowired 로 자기자신을 넣으면 순환참조가 일어날 수 있기 때문에 @RequiredArgsConstructor 사용
    private final AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry
                .addInterceptor(authInterceptor)
                .addPathPatterns("/api/private/*");

        // 여기서 또 추가하면 authInterceptor 다음에 동작하게 되어있음.
        // 인증에 Depth 를 두고 활용가능.
        // interceptorRegistry.addInterceptor()

    }

}
