package com.example.filter.interceptor;

import com.example.filter.annotation.Auth;
import com.example.filter.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component // spring에서 관리가 되어야함.
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /* Filter단에서 캐싱을 래핑해주면 아래 처럼 형변환을 해서 사용가능하지만, 그렇지 않으면 불가능함.
        (ContentCachingRequestWrapper) request;
        * */
        String url = request.getRequestURI();
        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI())
                .query(request.getQueryString())
                .build()
                .toUri();

        // 나의 서버는 모두 public으로 동작을 하는데
        // 단! Auth 권한을 가진 요청에 대해서는 세션, 쿠키, 무엇인가를 보겠다.
        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        if (hasAnnotation) {
            String query = uri.getQuery();
            log.info("query : {}", query);
            if (query.equals("name=steve")) {
                return true;
            }
            throw new AuthException();
        }
        return true;
    }

    private boolean checkAnnotation(Object handler, Class clazz) { //class는 예약어라서 zz로 표현
        // resource javascript, html 에 대한 요청은 통과
        if (handler instanceof ResourceHttpRequestHandler) {
            return true; // 무조건 통과
        }
        // annotation check
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz)) {
            // 어노테이션 달려있으면 트루
            // Auth annotation 이 있다면 true
            return true;

        }
        return false;
    }
}
