package com.cloud.cloudmember.config.mybatisPlus;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description: mybatisPlus配置文件
 * @author: zxp
 * @date: Created in 2021/7/20 21:15
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.cloud.cloudmember.model.*.dao")
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
