package com.view.designPatterns.proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by meijie on 2019/1/17.
 */
public class CgLibProxyTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new CgLibProxy());
        UserServiceImpl userService = (UserServiceImpl) enhancer.create();
        userService.sayHello();
    }


}
