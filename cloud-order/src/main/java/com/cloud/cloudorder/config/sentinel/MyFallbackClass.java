package com.cloud.cloudorder.config.sentinel;

/**
 * @description:
 * @author: zxp
 * @date: Created in 2021/7/15 23:09
 */
public class MyFallbackClass {

    /**
     * 该方法一定要是static方法
     *
     * @param a
     * @param b
     * @return
     */
    public static String fallback(String a, String b) {
        System.out.println("Fall back--> " + a + "--" + b);
        return "Fall back.";
    }

    public static String fallback2(String a, String b) {
        System.out.println("Fall back 2--> " + a + "--" + b);
        return "Fall back 2.";
    }

    public static String fallbackTestMethod() {

        return "fallbackTest 方法出现异常";
    }
}
