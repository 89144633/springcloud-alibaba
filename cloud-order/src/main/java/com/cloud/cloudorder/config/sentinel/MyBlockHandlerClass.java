package com.cloud.cloudorder.config.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;


/**
 * @description:
 * @author: zxp
 * @date: Created in 2021/7/18 0:18
 */
public class MyBlockHandlerClass {
    /**
     * 该方法一定要是static方法,且要带 BlockException 参数
     */
    public static String blockMethod(BlockException e) {

        return "Block Handler.";
    }


}
