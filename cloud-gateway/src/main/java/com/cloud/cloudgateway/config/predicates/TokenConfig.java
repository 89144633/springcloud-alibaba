package com.cloud.cloudgateway.config.predicates;
import lombok.Data;

/**
 * @description: 自定义谓词，配置类，
 *
 * 要求请求必须携带一个token，并且token值等于指定的值
 * @author: zxp
 * @date: Created in 2021/7/21 20:57
 */
@Data
public class TokenConfig {

    private String token;
}
