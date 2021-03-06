package com.view.view;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2018/12/29
 * Time : 19:37
 * Project : View
 */
public class AntTest2 {

    /**
     *打印int数组中第11大的数，和除前十个大数以外的所有数字的中位数，数组可能有重复的值。个数少于100个。

     可以在命令行执行，数组在命令行输入，或者在代码里都行。


     [1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 11, 11, 11, 12, 12, 12, 13]

     如：1  2  3 3 4 4 5 5 6 6 7 7 8 8 9 9 10 10  11 11 12 12 11 12  7 8 9 13 1

     第一大的数字是13， 第二大的是12，  以此类推。
     除前十个大数以外的所有数字是1 2 3 3 1
     *
     */


    //verify param
    private static AntObject find_k(Integer[] arr, int k) {
        AntObject antObject = new AntObject();
        if (arr == null || arr.length == 0) {
            antObject.setErrMsg("请输入src数组");
            return antObject;
        }
        if (k < 1) {
            antObject.setErrMsg("正确的k");
            return antObject;
        }

        if (k > arr.length) {
            antObject.setErrMsg(String.format("当前数组不重复的数字有[%s]个,不存在第[%s]大的数字", arr.length, k));
            return antObject;
        }
        return get_k(arr.length - k + 1, arr, 0, arr.length - 1);
    }

    //get_k
    private static AntObject get_k(int k, Integer[] arr, int start, int end) {
        int temp = arr[end];
        int left = start;
        int right = end;

        while (true) {
            while (arr[left] < temp && left < right) {
                left++;
            }
            while (arr[right] >= temp && right > left) {
                right--;
            }
            if (left == right) {
                break;
            }
            swap(arr, left, right);
        }

        swap(arr, left, end);

        if (k == left + 1) {
            AntObject antObject = new AntObject();
            antObject.setNum(temp);
            antObject.setIndex(k);
            return antObject;
        } else if (k < left + 1) {
            return get_k(k, arr, start, left - 1);
        } else {
            return get_k(k, arr, left + 1, end);
        }
    }

    private static void swap(Integer[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    //middleNum
    private static BigDecimal middleNum(Integer[] arr) {

        if (arr == null || arr.length == 0) {
            return null;
        }

        int queueSize = arr.length / 2 + 1;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(queueSize);
        priorityQueue.addAll(Arrays.asList(arr).subList(0, queueSize));
        for (int i = queueSize; i < arr.length; i++) {
            if (priorityQueue.peek() < arr[i]) {
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
        }
        if (arr.length % 2 == 1) {
            return BigDecimal.valueOf(priorityQueue.peek());
        } else {
            return BigDecimal.valueOf((priorityQueue.poll() + priorityQueue.peek()) / 2.0);
        }
    }

    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 11, 12, 7, 8, 9, 13, 1};
//        int[] arrays = {23, 26, 1, 2, 3, 3, 4, 4, 5, 7, 85, 36};
//        int[] arrays = {23, 26, 1, 1, 2, 2, 3, 123, 456, 4, 58, 7, 85, 36};
//        int[] arrays = {23, 26, 1, 1, 23, 2, 32, 123, 456, 4, 58, 7, 85, 36};
        if (arrays == null || arrays.length == 0) {
            System.out.println("param error");
            return;
        }

        Map<Integer, AntObject> map = fillArrayMap(arrays);

        Integer[] setArr = map.keySet().toArray(new Integer[]{});
        int k = 10;

        //第一步取值
        AntObject result = find_k(setArr, k);

        if (StringUtils.isNotBlank(result.getErrMsg())) {
            System.out.println(result.getErrMsg());
            return;
        }

        List<Integer> list = fillMiddleList(map, setArr, result);

        System.out.println(String.format("第[%s]大的数是[%s]", k, result.getNum()));

        //第二步取中位数
        Integer[] setMideleArr = list.toArray(new Integer[]{});
        System.out.println(String.format("除前十个大数以外的所有数字是%s", Arrays.toString(setMideleArr)));
        BigDecimal middleNum = middleNum(setMideleArr);

        if (middleNum == null) {
            System.out.println("setMideleArr param error");
            return;
        }
        System.out.println(String.format("中位数为[%s]", middleNum.toString()));

    }

    private static Map<Integer, AntObject> fillArrayMap(int[] arrays) {
        Map<Integer, AntObject> map = new HashMap<>();
        for (int arr : arrays) {
            if (map.containsKey(arr)) {
                AntObject ao = map.get(arr);
                ao.setCount(ao.getCount() + 1);
            } else {
                AntObject ao = new AntObject();
                ao.setCount(1);
                ao.setNum(arr);
                map.put(arr, ao);
            }
        }
        return map;
    }

    private static List<Integer> fillMiddleList(Map<Integer, AntObject> map, Integer[] setArr, AntObject result) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < result.getIndex(); i++) {
            Integer sa = setArr[i];
            AntObject antObject = map.get(sa);
            for (int j = 0; j < antObject.getCount(); j++) {
                list.add(antObject.getNum());
            }
        }
        return list;
    }


    static class AntObject {
        private Integer num;
        private Integer index;
        private Integer count;
        private String errMsg;

        Integer getNum() {
            return num;
        }

        void setNum(Integer num) {
            this.num = num;
        }

        Integer getIndex() {
            return index;
        }

        void setIndex(Integer index) {
            this.index = index;
        }

        Integer getCount() {
            return count;
        }

        void setCount(Integer count) {
            this.count = count;
        }

        String getErrMsg() {
            return errMsg;
        }

        void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("AntObject{");
            sb.append("num=").append(num);
            sb.append(", index=").append(index);
            sb.append(", count=").append(count);
            sb.append('}');
            return sb.toString();
        }
    }

}
