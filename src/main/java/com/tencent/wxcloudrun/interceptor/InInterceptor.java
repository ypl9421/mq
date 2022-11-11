package com.tencent.wxcloudrun.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 无语
 * @create 2022-11-11 10:39
 */
@Slf4j
public class InInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("----------进入过滤器------------>");
        request.getParameterMap().forEach((k,v)->{
            System.out.println(k+"*********"+v);
        });
        log.info("<----------结束过滤器------------");
        return true;
    }
}
