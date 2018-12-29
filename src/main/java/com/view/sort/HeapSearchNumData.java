package com.view.sort;

import java.util.PriorityQueue;

public class HeapSearchNumData {
    public static int findLeast(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);//一个基于优先级堆的极大优先级队列
        for (int i : nums) {
            q.offer(i);//把数丢进堆里自动调整

            if (q.size() > k) {
                q.poll();//检索并移除此队列的头，也就是把堆顶的那个丢出去。
            }
        }

        return q.peek();//单纯检查，不移除
    }
    public static void main(String[] args) {
        int[] array = {
                1,1,1,1,2,2,2,2,3,3,4,5
        };//这里就没有用clone来复制一份数组了，因为PriorityQueue有暂存空间。
        int k=findLeast(array,4);
        System.out.print(k);
        System.out.print("\n");
        for(int i=0;i<10;i++){
            System.out.print(array[i]+" ");
        }
        System.out.print("\n");
        for(int i=0;i<10;i++){
            if (k==array [i]){
                System.out.print(" 位置"+i+"  ");
            }
        }
    }
}
