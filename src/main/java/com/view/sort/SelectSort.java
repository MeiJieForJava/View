package com.view.sort;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2018/12/17
 * Time : 13:59
 */
public class SelectSort {

    /**
     * 简单选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;//每一趟循环比较时，min用于存放较小元素的数组下标，这样当前批次比较完毕最终存放的就是此趟内最小的元素的下标，避免每次遇到较小元素都要进行交换。
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //进行交换，如果min发生变化，则进行交换
            if (min != i) {
                swap(arr,min,i);
            }
        }
    }

    //交换数组的两个位置
    private static void swap(int[] L, int i, int j) {

        int temp=L[i];
        L[i]=L[j];
        L[j]=temp;

    }

}
