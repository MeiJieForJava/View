package com.view.sort;

import java.util.Arrays;

public class MaxHeap {
    private int[] array;  
    private int size;  
    public MaxHeap(int[] array){  
        this.array = Arrays.copyOf(array, array.length);
        this.size = this.array.length;  
    }  
    //求第K大的数值  
    public int kmax(int k){  
        if(k<1 || k>size){  
            throw new IllegalArgumentException("k must be between 1 and " + size);  
        }  
        this.buildMaxHeap();  
        for(int count=1,i=size-1;i>=1;i--,count++){  
            if(k == count){  
                break;  
            }  
            swap(0,i);  
            maxHeapify(0,i);  
        }  
        return array[0];  
    }  
      
    //建立最大堆  
    public void buildMaxHeap(){  
        for(int i=parent(size-1);i>=0;i--){  
            maxHeapify(i,size);  
        }  
    }  
      
    //排序  
    public void sort(){  
        this.buildMaxHeap();  
        for(int i=size-1;i>=1;i--){  
            swap(i,0);  
            maxHeapify(0,i);  
        }  
    }  
    //使i节点比左节点和右节点都要大。  
    //@param i 节点下标  
    //@param size 堆的元素个数  
    private void maxHeapify(int i, int size){  
        int maxIndex = i;  
        int left = left(i);  
        int right = right(i);  
        if(left<size && array[left]>array[maxIndex]){  
            maxIndex = left;  
        }  
        if(right<size && array[right]>array[maxIndex]){  
            maxIndex = right;  
        }  
        if(maxIndex != i){  
            swap(i,maxIndex);  
            //子节点发生了变化，需要重新计算最大值  
            maxHeapify(maxIndex,size);  
        }  
    }  
      
    private void swap(int i,int j){  
        int tmp  = array[i];  
        array[i] = array[j];  
        array[j] = tmp;  
    }  
      
    private int left(int i){  
        return (i<<1) + 1;  
    }  
      
    private int right(int i){  
        return (i<<1) + 2;  
    }  
    private int parent(int i){  
        return (i-1)>>1;  
    }  
      
    public void print(){  
        int i=0;  
        for(int width=1;;width*=2){  
            for(int count=0;count<width;count++){  
                System.out.print(array[i]+ " ");  
                i++;  
                if(i==size){  
                    System.out.println();  
                    return;  
                }  
            }  
            System.out.println();  
        }  
    }  
      
    public static void main(String[] args){  
        int[] a = new int[]{1,1,1,1,2,2,2,2,3,3,4,5};
        MaxHeap heap = new MaxHeap(a);  
        //第二大的数  
        System.out.println(heap.kmax(5));
    }  
}  