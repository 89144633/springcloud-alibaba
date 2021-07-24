package com.cloud.cloudorder.model.order.fallback;

import com.cloud.cloudorder.model.order.openFeign.OrderServiceFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: zxp
 * @date: Created in 2021/7/18 1:18
 */

@Component
public class OrderServiceFallbackFactory implements FallbackFactory<OrderServiceFeign> {


    @Override
    public OrderServiceFeign create(Throwable throwable) {
        return new OrderServiceFeign() {
            @Override
            public String getMember() {
                return "fallbackFactory类，返回限流处理";
            }
        };
    }
}
