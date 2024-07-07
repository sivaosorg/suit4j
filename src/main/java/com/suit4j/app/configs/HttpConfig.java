package com.suit4j.app.configs;

import org.bot4j.telegram.message.MessageFactory;
import org.botwrap4j.common.BotWrap4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.unify4j.common.Json4j;
import org.unify4j.common.Request4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings({"NullableProblems"})
@Component
public class HttpConfig implements HandlerInterceptor {
    protected static final Logger logger = LoggerFactory.getLogger(HttpConfig.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("Incoming request, {} URI: {}, params: {}", request.getMethod(), request.getRequestURI(), Json4j.toJson(request.getParameterMap()));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
        logger.info("Outgoing response, status: {} ({}), {} URI: {} and params: {}",
                response.getStatus(), HttpStatus.valueOf(response.getStatus()).getReasonPhrase(),
                request.getMethod(), request.getRequestURI(), Json4j.toJson(request.getParameterMap()));
        if (e != null) {
            logger.error("afterCompletion, outgoing response raised an exception: {}", e.getMessage(), e);
        }
        BotWrap4j.telegramProvider().sendMessageSilent("worker_logging",
                MessageFactory.http()
                        .status(response.getStatus())
                        .method(request.getMethod())
                        .baseUrl(Request4j.getBaseUrl(request))
                        .path(request.getRequestURI())
                        .query(request.getParameterMap())
                        .apiDesc(HttpConfig.class.getName())
                        .cause(e)
                        .requestId(Request4j.getSessionId(request))
                        .header(Request4j.getHeaders(request))
                        .startTime()
                        .endTime()
        );
    }
}
