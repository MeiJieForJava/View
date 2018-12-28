package com.view.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2018/12/25
 * Time : 10:45
 * 遍历二叉树
 */
public class TraversTree {


    public static void main(String[] args) {

        TraversTree traversTree = new TraversTree();

        Node root = traversTree.bulidTree();
        traversTree.recursiveBeforeTravers(root);
        System.out.println();
        traversTree.beforeTravers(root);
        System.out.println();
        traversTree.recursiveMiddleTravers(root);
        System.out.println();
//        traversTree.middleTravers(root);
        traversTree.recursiveAfterTravers(root);
        System.out.println();
//        traversTree.afterTravers(root);
        traversTree.levelTravers(root);
        System.out.println();
    }


    /***
     * 层级遍历
     * @param root rootNode
     */
    private void levelTravers(Node root) {
        if (root == null) {
            return;
        }
        Node currentNode = null;
        LinkedList<Node> list = new LinkedList<Node>();
        list.add(root);
        while (!list.isEmpty()) {
            currentNode = list.poll();
            print(currentNode);
            if (currentNode.getLeft() != null) {
                list.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                list.add(currentNode.getRight());
            }
        }

    }

    /***
     * 非递归 后续遍历
     * @param root rootNode
     */
    private void afterTravers(Node root) {
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.getLeft();
            }
            boolean tag = true;
            Node preNode = null;
            while (!stack.isEmpty() && tag) {
                currentNode = stack.peek();
                if (currentNode.getRight() == preNode) {
                    currentNode = stack.pop();
                    print(currentNode);
                    if (stack.isEmpty()) {
                        return;
                    } else {
                        preNode = currentNode;
                    }
                } else {
                    currentNode = currentNode.getRight();
                    tag = false;
                }
            }
        }
    }


    /***
     * 非递归 中续遍历
     * @param root rootNode
     */
    private void middleTravers(Node root) {
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.getLeft();
            }
            while (!stack.isEmpty()) {
                currentNode = stack.pop();
                print(currentNode);
                currentNode = currentNode.getRight();
            }
        }
    }

    /***
     * 非递归 先续遍历
     * @param root rootNode
     */
    private void beforeTravers(Node root) {
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                print(currentNode);
                stack.push(currentNode);
                currentNode = currentNode.getLeft();
            }
            while (!stack.isEmpty()) {
                currentNode = stack.pop();
                currentNode = currentNode.getRight();
            }
        }
    }

    /***
     * 递归 后续遍历
     * @param root rootNode
     */
    private void recursiveAfterTravers(Node root) {
        if (root != null && root.getLeft() != null) {
            this.recursiveAfterTravers(root.getLeft());
        }
        if (root != null && root.getRight() != null) {
            this.recursiveAfterTravers(root.getRight());
        }
        print(root);
    }

    /***
     * 递归 中续遍历
     * @param root rootNode
     */
    private void recursiveMiddleTravers(Node root) {
        if (root != null && root.getLeft() != null) {
            this.recursiveMiddleTravers(root.getLeft());
        }
        print(root);
        if (root != null && root.getRight() != null) {
            this.recursiveMiddleTravers(root.getRight());
        }
    }

    /***
     * 递归 先续遍历
     * @param root rootNode
     */
    private void recursiveBeforeTravers(Node root) {
        print(root);
        if (root != null && root.getLeft() != null) {
            this.recursiveBeforeTravers(root.getLeft());
        }
        if (root != null && root.getRight() != null) {
            this.recursiveBeforeTravers(root.getRight());
        }
    }

    /***
     * 构建二叉树
     */
    private Node bulidTree() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Node> nodeList = new LinkedList<Node>();
        // 将一个数组的值依次转换为Node节点
//        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
//            nodeList.add(new Node(array[nodeIndex]));
//        }
        Arrays.stream(array).forEach(a -> nodeList.add(new Node(a)));
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).setLeft(nodeList.get(parentIndex * 2 + 1));
            // 右孩子
            nodeList.get(parentIndex).setRight(nodeList.get(parentIndex * 2 + 2));
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).setLeft(nodeList.get(lastParentIndex * 2 + 1));
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).setRight(nodeList.get(lastParentIndex * 2 + 2));
        }
        return nodeList.get(0);
    }

    /***
     * 打印
     */
    private void print(Node node) {
        System.out.print(node.getVal());
    }


}
