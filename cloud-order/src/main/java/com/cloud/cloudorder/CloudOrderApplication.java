package com.cloud.cloudorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
// 开启服务注册与发现的功能
@EnableDiscoveryClient
// 开启openFeign
@EnableFeignClients
public class CloudOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudOrderApplication.class, args);
    }


}
