package com.view;

import java.math.BigDecimal;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] arr = null;

        System.out.println(new App().getIncomeStr("23000"));

    }


    private String getIncomeStr(String kpi) {
        StringBuilder sb = new StringBuilder();
        if (new BigDecimal(kpi).divide(BigDecimal.valueOf(10000), 4, BigDecimal.ROUND_DOWN).compareTo(BigDecimal.ONE) > 0) {
            sb.append(kpi.charAt(0)).append("亿").append(kpi.substring(1, kpi.length())).append("万元");
        } else {
            sb.append(kpi).append("万元");
        }
        return sb.toString();
    }

}
