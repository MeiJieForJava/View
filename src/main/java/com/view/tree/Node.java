package com.view.tree;

import lombok.Data;
import lombok.ToString;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2018/12/25
 * Time : 10:41
 */
@Data
@ToString
public class Node {

    private int val;

    private Node left;

    private Node right;

    public Node(int val) {
        this.val = val;
    }

}
