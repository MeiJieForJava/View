package com.view.java8;

public class SearchNumData {
    /*
        n为数组长度
        k为要查找的第k大
     */
    public static int findKth(int[] a, int n, int K) {
        return findKth(a, 0, n - 1, K);
    }

    /*
           start为数组最低位下标
           end为数组最高位下标
     */
    public static int findKth(int[] a, int start, int end, int k) {
        //先进行一次快排，取得枢纽
        int pivot = partation(a, start, end);
        //pivot-start+1表示快排的前半段元素的个数（包括中轴）
        //当查了一次后，就划分了两边，大的在左边，小的在右边
        if (k == pivot - start + 1) {
            return a[pivot];
        } else if (k > pivot - start + 1) {//说明第k大的元素在后半段，所以往后面查，start=pivot+1，k-（pivot-start+1）。为什么这样更新，想一下，我们虽然往后查，但查的还是整个数组的第k大，第一次快排枢纽的时候，已经把大的放右边了。
            return findKth(a, pivot + 1, end, k - pivot + start - 1);
        } else {//则第k大的元素在前半段，更新end=pivot-1
            return findKth(a, start, pivot - 1, k);
        }
    }

    //快排，找枢纽，从大到小排序
    public static int partation(int[] a, int low, int high) {
        int key = a[low];
        while (low < high) {
            while (low < high && a[high] <= key)
                high--;
            a[low] = a[high];
            while (low < high && a[low] >= key)
                low++;
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 11, 12, 7, 8, 9, 13, 1};//因为第一个数组被排序过了的，不是原来的了
        int[] array2 = array.clone();//所以我clone一份原来的数组
        int k = findKth(array, array.length, 4);
        System.out.print(k);
        System.out.print("\n");
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < 10; i++) {
            if (k == array2[i]) {
                System.out.print(" 位置" + i + "  ");
            }
        }
    }
}
