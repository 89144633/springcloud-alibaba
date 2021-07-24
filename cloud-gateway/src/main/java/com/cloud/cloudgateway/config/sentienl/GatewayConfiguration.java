package com.cloud.cloudgateway.config.sentienl;

import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;


/**
 * @description: gateway 整合 sentinel 的配置类
 * @author: zxp
 * @date: Created in 2021/7/22 0:11
 */
@Configuration
public class GatewayConfiguration {



    // 启动Sentinel的filter，让gateway 识别sentinel，进行针对服务的限流降级
    @Bean
    @Order(-1)
    public GlobalFilter sentinelGatewayFilter() {
        return new SentinelGatewayFilter();
    }





}
