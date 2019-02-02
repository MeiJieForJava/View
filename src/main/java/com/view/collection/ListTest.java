package com.view.collection;

import org.junit.Test;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by meijie on 2019/1/21.
 */
public class ListTest {


    @Test
    public void test1() {
        List<WeakReference<ObjectTest>> list = new ArrayList<>();
        ObjectTest test = new ObjectTest();
        test.setAa("a");
//        list.add(test);
//        test = null;
        WeakReference<ObjectTest> testWeakReference = new WeakReference<>(test);
        list.add(testWeakReference);
        test = null;
        while (true) {
            if (list.get(0).get() != null) {
                System.out.println(list.get(0).get().getAa());
            } else {
                System.out.println("b");
                break;
            }
        }
    }

}
