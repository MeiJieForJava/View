package com.view.sort;

import java.util.Arrays;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2018/12/13
 * Time : 16:12
 */
public class QuickSort {

//    public static void quickSort(int[] arr, int low, int high) {
//        if (low < high) {
//            int part = partition(arr, low, high);
//            quickSort(arr, low, part - 1);
//            quickSort(arr, part + 1, high);
//        }
//    }
//
//    private static int partition(int[] arr, int low, int high) {
//        int key = arr[low];
//        while (low < high) {
//            while (low < high && key <= arr[high]) {
//                high--;
//            }
//            swap(arr, low, high);
//            arr[low] = arr[high];
//            while (low < high && arr[low] <= key) {
//                low++;
//            }
//            swap(arr, low, high);
//        }
//        return low;
//    }
//
//    private static void swap(int[] arr, int low, int high) {
//        int temp = arr[low];
//        arr[low] = arr[high];
//        arr[high] = temp;
//    }

    public static void main(String[] args) {
        int a[] = {3, 1, 5, 7, 2, 4, 9, 6};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }


    public static void quickSort(int[] L) {
        Qsort(L,0,L.length-1);
    }

    public static void Qsort(int[] L, int low, int high) {
        int pivot;
        if(low<high) {
            //将L[low,high]一分为二,算出枢轴值pivot,该值得位置固定,不用再变化
            pivot=partition0(L,low,high);

            //对两边的数组分别排序
            Qsort(L,low,pivot-1);
            Qsort(L,pivot+1,high);
        }
    }

    //  选择一个枢轴值(关键字) 把它放到某个位置 使其左边的值都比它小 右边的值都比它大
    public static int partition0(int[] L, int low, int high) {
        int pivotkey;
        pivotkey=L[low];
        //顺序很重要，要先从右边找
        while(low<high) {
            while(low<high && L[high]>=pivotkey) {  //从后往前找到比key小的放到前面去
                high--;
            }
            swap(L,low,high);
            while(low<high && L[low]<=pivotkey) {  //从前往后找到比key大的 放到后面去
                low++;
            }
            swap(L,low,high);
        } //遍历所有记录  low的位置即为 key所在位置, 且固定,不用再改变
        return low;
    }
    //交换数组的两个位置
    public static void swap(int[] L, int i, int j) {

        int temp=L[i];
        L[i]=L[j];
        L[j]=temp;

    }

}
