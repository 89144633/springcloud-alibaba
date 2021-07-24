package com.cloud.cloudorder.config.sentinel;

import lombok.Builder;
import lombok.Data;

/**
 * @description: 自定义sentinel限流返回的对象
 * @author: zxp
 * @date: Created in 2021/7/13 21:00
 */
@Data //get set toString hashCode ......
@Builder //生成构建器模式
public class RestObject {
    private int statusCode;

    private String statusMessage;

    private Object data;
}
