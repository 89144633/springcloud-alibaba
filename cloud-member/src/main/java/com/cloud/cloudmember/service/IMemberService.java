package com.cloud.cloudmember.service;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 会员端接口
 * @author: zxp
 * @date: Created in 2021/7/10 12:58
 */
public interface IMemberService {



     @ApiOperation(value = "获取会员测试接口", notes = "获取会员测试接口")
     @RequestMapping("/getMember")
     String getMember();
}
