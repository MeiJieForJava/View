package com.view.designPatterns.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by meijie on 2019/1/17.
 */
public class CgLibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("start");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("end");
        return object;
    }
}
