package com.kuoji.decoratorpattern;

public interface HandlerInterceptor {

    boolean preHandle(String request, String response, Object handler);

}
