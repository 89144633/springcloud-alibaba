package com.cloud.cloudorder.model.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.cloudorder.model.order.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: zxp
 * @date: Created in 2021/7/20 21:14
 */
@Mapper
public interface OrderInfoDao extends BaseMapper<OrderInfo> {
}
