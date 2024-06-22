package com.suit4j.app.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.unify4j.common.Json4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings({"NullableProblems"})
@Component
public class HttpInterceptorConfig implements HandlerInterceptor {
    protected static final Logger logger = LoggerFactory.getLogger(HttpInterceptorConfig.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("Incoming request, method: {}, URI: {}, params: {}", request.getMethod(), request.getRequestURI(), Json4j.toJson(request.getParameterMap()));
        // BotWrap4j.telegramProvider().sendMessageSilent("worker_logging", request.getServerPort());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
        logger.info("Outgoing response, status: {} ({}), method: {}, URI: {} and params: {}",
                response.getStatus(), HttpStatus.valueOf(response.getStatus()).getReasonPhrase(), request.getMethod(),
                request.getRequestURI(), Json4j.toJson(request.getParameterMap()));
        if (e != null) {
            logger.error("Request raised an exception", e);
        }
    }
}
