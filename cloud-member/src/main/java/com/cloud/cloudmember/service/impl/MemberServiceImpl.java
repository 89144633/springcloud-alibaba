package com.cloud.cloudmember.service.impl;

import com.cloud.cloudmember.service.IMemberService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: zxp
 * @date: Created in 2021/7/10 12:59
 */
@Api(tags = "会员服务Controller")
@RestController
public class MemberServiceImpl implements IMemberService {


    public String getMember() {
        return "订单服务->会员服务，接口调用成功";
    }
}
