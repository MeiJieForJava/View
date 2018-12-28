package com.view.thread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2018/12/18
 * Time : 17:43
 */
public class FutureTest {

    private static ExecutorService executors = Executors.newSingleThreadExecutor();


    public static void main(String[] args) {
        System.out.println("main start");
        executors.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("call start");
                Thread.sleep(10000L);
                System.out.println("call end");
                return null;
            }
        });
        System.out.println("main end");
    }

    @Test
    public void test1(){
        Thread thread = new Thread(() -> Runnable);

    }

}
