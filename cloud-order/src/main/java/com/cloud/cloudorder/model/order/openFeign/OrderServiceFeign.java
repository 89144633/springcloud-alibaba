package com.cloud.cloudorder.model.order.openFeign;

import com.cloud.cloudmember.service.IMemberService;
import com.cloud.cloudorder.model.order.fallback.OrderServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @description: 订单端调用会员端的openFeign接口 ,fallback /fallbackFactory 实现定制化此接口出现异常或者限流降级以后处理的类
 * @author: zxp
 * @date: Created in 2021/7/10 13:05
 */

@FeignClient(value  = "cloud-member",
        /*fallback = OrderServerFallback.class,两种异常处理方式，随便挑一种*/
        fallbackFactory=OrderServiceFallbackFactory.class)
public interface OrderServiceFeign extends IMemberService {
}
