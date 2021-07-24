package com.cloud.cloudorder.model.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cloud.cloudorder.model.order.openFeign.OrderServiceFeign;
import com.cloud.cloudorder.config.sentinel.MyBlockHandlerClass;
import com.cloud.cloudorder.config.sentinel.MyFallbackClass;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: zxp
 * @date: Created in 2021/7/10 13:14
 */
@RestController
// @RefreshScope 注解用于动态刷新nacos更改的配置。及时读取新的值
@RefreshScope
@Api(tags = "订单服务测试Controller")
public class OrderController {

    // 使用openFeign 调用
    @Resource
    private OrderServiceFeign openFeign;



    /**
     * @description  OpenFeign 远程调用案例，实现订单服务调用会员服务
     * @author zxp
     * @date 2021/7/19 22:17
     */
    @ApiOperation(value = "OpenFeign订单调用会员", notes = "OpenFeign订单调用会员")
    @RequestMapping("/getOrderToMemberByOpenFeign")
    public String getOrderToMemberByOpenFeign() {
        // 让线程休眠250毫秒
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       return  openFeign.getMember();

    }



    /**
     * @description  热点数据限流测试
     * @author zxp
     * @date 2021/7/15 23:03
     *
     *  // @SentinelResource(value="testHotSource",fallback="fallback",fallbackClass=MyFallbackClass.class)
     *  @SentinelResource 代表 通过注解形式，自定义限流降级的方法
     *  fallbackClass 代表异常以后走哪个类进行处理
     *  fallback 代表走异常类里面的哪个方法处理
     */

    @ApiOperation(value = "sentinel热点数据规则测试", notes = "sentinel热点数据规则测试")
    @RequestMapping("/testHotSource")
    @SentinelResource(value="testHotSource",fallback="fallback",fallbackClass=MyFallbackClass.class)
    public String testHotSource(@RequestParam(value="a") String a,@RequestParam(value="b") String b){
        return  a+b;
    }


    /**
     *   测试 @SentinelResource 注解里面的 fallback 属性和fallbackClass属性
     *    fallbackClass -- 属性是指定该方法出现熔断降级的时候，使用的类
     *    fallback  -- 属性是指fallbackClass类里面的哪个方法
     */
    @ApiOperation(value = "fallback属性测试", notes = "fallback属性测试")
    @RequestMapping("/fallbackTest")
    @SentinelResource(value="fallbackTest",fallback="fallbackTestMethod",fallbackClass=MyFallbackClass.class)
    public String fallbackTest(){
        return  "测试fallback属性";
    }


    /**
     *   测试 @SentinelResource 注解里面的 blockHandler 属性和 blockHandlerClass属性
     *    blockHandlerClass -- 属性是指定该方法出现熔断降级的时候，使用的类
     *    blockHandler  -- 属性是指fallbackClass类里面的哪个方法
     */
    @ApiOperation(value = "blockHandler属性测试", notes = "blockHandler属性测试")
    @RequestMapping("/blockHandlerTest")
    @SentinelResource(value="blockHandlerTest",blockHandler="blockMethod",blockHandlerClass=MyBlockHandlerClass.class)
    public String blockHandlerTest(){
        return  "测试blockHandler属性";
    }

}
