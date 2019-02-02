package com.view.designPatterns.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by meijie on 2019/1/17.
 */
public class JdkProxyTest {

    public static void main(String[] args) {
        UserService userService = (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(), UserServiceImpl.class.getInterfaces(), new JdkProxy(new UserServiceImpl()));
        userService.sayHello();
    }

}
