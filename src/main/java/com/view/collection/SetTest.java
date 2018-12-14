package com.view.collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2018/12/3
 * Time : 14:43
 */
public class SetTest {

    @Test
    public void testAdd() {
        Set<Integer> set = new HashSet<>();
        set.add(null);
        set.add(null);
        set.add(1);
        System.out.println(set.toString());
    }

}
