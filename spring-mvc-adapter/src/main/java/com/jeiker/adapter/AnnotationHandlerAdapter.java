package com.jeiker.adapter;

import com.jeiker.controller.AnnotationController;

/**
 * Description: AnnotationController 的适配器
 * User: jeikerxiao
 * Date: 2019/3/7 1:51 PM
 */
public class AnnotationHandlerAdapter implements HandlerAdapter {

    public boolean supports(Object handler) {
        return (handler instanceof AnnotationController);
    }

    public void handle(Object handler) {
        ((AnnotationController) handler).doAnnotationHandler();
    }

}
