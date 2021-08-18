package com.example.filter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
// @Component // SpringApplication.java 에서 @serverCompoenentScan 사용시에 는 아래 webFilter를 사용한다.
@WebFilter(urlPatterns = "/api/user/*")
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 전처리
        // 여기서 request를 읽어버리면 Spring에서는 이미 packet을 다 읽어버린, empty 한 response만 받기때문에 chain.doFilter를 거치고나서(Cache로 받는다)
        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);

        //
        chain.doFilter(httpServletRequest, httpServletResponse);

        log.info("request url : {}, request body");

        // 후처리

        String url = httpServletRequest.getRequestURI();
        String reqContent = new String(httpServletRequest.getContentAsByteArray());
        log.info("request url : {}, request body : {}", url, reqContent);
        httpServletResponse.copyBodyToResponse(); // 이 부분이 없다면 실패한다.

        int httpStatus = httpServletResponse.getStatus();
        String resContent = new String(httpServletResponse.getContentAsByteArray());
        log.info("response status : {}, responseBody : {}", httpStatus, resContent);
    }
}
