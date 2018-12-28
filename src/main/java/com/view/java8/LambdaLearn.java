package com.view.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2018/12/24
 * Time : 10:16
 */
public class LambdaLearn {

    @Test
    public void test1() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);

        players.forEach((player) -> System.out.println(player + " "));

        Arrays.stream(atp).forEach(System.out::println);


    }

    @Test
    public void test2() {
        List<Student> stuList = new ArrayList<>(10);
        stuList.add(new Student("刘一", 85));
        stuList.add(new Student("陈二", 90));
        stuList.add(new Student("张三", 98));
        stuList.add(new Student("李四", 88));
        stuList.add(new Student("王五", 83));
        stuList.add(new Student("赵六", 95));
        stuList.add(new Student("孙七", 87));
        stuList.add(new Student("周八", 84));
        stuList.add(new Student("吴九", 100));
        stuList.add(new Student("郑十", 99));
        stuList.add(new Student("郑十", 95));
        Map<String, Student> map = stuList.stream().collect(Collectors.toMap(Student::getName, Function.identity(), (student1, student2) -> student1));
//        map.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
        map.forEach((k, v) -> System.out.print(k + "" + v.toString()));
    }

}
