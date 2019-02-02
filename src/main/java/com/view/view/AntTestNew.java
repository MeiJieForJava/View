package com.view.view;

/**
 * Created by meijie on 2019/2/1.
 */
public class AntTestNew {

    public static void main(String[] args) {
        AntTestThread thread = new AntTestThread();
        Thread printer1 = new Thread(thread);
        Thread printer2 = new Thread(thread);

        printer1.setName("printer1");
        printer2.setName("printer2");

        printer1.start();
        printer2.start();
    }

}


class AntTestThread implements Runnable {

    private int num = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (num > 100) {
                    System.out.println(Thread.currentThread().getName() + "---end");
                    break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                if (num <= 100) {
                    System.out.println(Thread.currentThread().getName() + "---" + num);
                    num++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                }
            }
        }
    }
}