package com.view.designPatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by meijie on 2019/1/17.
 */
public class JdkProxy implements InvocationHandler {


    private Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.printf("start");
        Object rs = method.invoke(target, args);
        System.out.printf("end");
        return rs;
    }
}
