package com.view.java8;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {

    private String name;
    private int score;

    public Student() {

    }

    public Student(String name, int score) {
        super();
        this.name = name;
        this.score = score;
    }

    //setter和getter省略

    @Override
    public String toString() {
        return "[姓名=" + name + ", 分数=" + score + "]";
    }

    public static void main(String[] args) {
        Integer[] middleArr = new Integer[12];
        System.out.println(middleArr.length);
    }
}
