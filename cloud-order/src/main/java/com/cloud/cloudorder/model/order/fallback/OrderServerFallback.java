package com.cloud.cloudorder.model.order.fallback;

import com.cloud.cloudorder.model.order.openFeign.OrderServiceFeign;
import org.springframework.stereotype.Component;

/**
 * @description: 注意加入 @Component 注解，以及注意实现的接口是哪个，接口要实现本项目的接口。看清楚
 * @author: zxp
 * @date: Created in 2021/7/18 1:35
 */
@Component
public class OrderServerFallback  implements OrderServiceFeign {

    @Override
    public String getMember() {
        return "服务降级处理：订单调用会员失败";
    }
}
