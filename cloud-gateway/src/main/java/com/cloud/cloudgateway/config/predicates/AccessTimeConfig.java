package com.cloud.cloudgateway.config.predicates;
import lombok.Data;
import java.time.LocalTime;

/**
 * @description: 自定义谓词 案例二： 要求某个服务的用户只允许在23:00 - 6:00这个时间段内才可以访问
 * @author: zxp
 * @date: Created in 2021/7/21 21:57
 */
@Data
public class AccessTimeConfig {
     // 开始时间
    private LocalTime start;
    // 结束时间
    private LocalTime end;
}
