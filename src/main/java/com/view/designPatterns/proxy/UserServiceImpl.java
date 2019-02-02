package com.view.designPatterns.proxy;

/**
 * Created by meijie on 2019/1/17.
 */
public class UserServiceImpl implements UserService {
    @Override
    public void sayHello() {
        System.out.printf("hello");
    }
}
