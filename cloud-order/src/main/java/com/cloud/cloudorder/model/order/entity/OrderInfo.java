package com.cloud.cloudorder.model.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description:
 * @author: zxp
 * @date: Created in 2021/7/20 21:19
 */
@Data
@TableName("order_info")
public class OrderInfo {
    @TableId
    private String id;

    private String orderNumber;

    private String createTime;
}
