package com.cloud.cloudorder.model.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.cloudorder.model.order.dao.OrderInfoDao;
import com.cloud.cloudorder.model.order.entity.OrderInfo;
import com.cloud.cloudorder.model.order.service.OrderInfoService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zxp
 * @date: Created in 2021/7/20 21:25
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoDao, OrderInfo> implements OrderInfoService {
}
