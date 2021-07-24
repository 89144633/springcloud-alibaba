package com.cloud.cloudorder.model.order.controller;

import com.cloud.cloudorder.model.order.service.OrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: zxp
 * @date: Created in 2021/7/20 21:41
 */
@RestController
@RequestMapping("/orderInfo")
@Api(tags = "订单详情")
public class OrderInfoController {
    @Resource
    private OrderInfoService orderInfoService;

    @PostMapping("/selectOrderInfo")
    @ApiOperation(value = "查询订单详情")
    public Object selectOrderInfo(){
        return orderInfoService.list();

    }
}
