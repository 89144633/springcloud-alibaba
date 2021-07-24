package com.cloud.cloudgateway.config.predicates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @description: 自定义谓词工厂实现类，，需要继承AbstractRoutePredicateFactory 类
 * 案例二： 要求某个服务的用户只允许在23:00 - 6:00这个时间段内才可以访问
 * @author: zxp
 * @date: Created in 2021/7/21 21:58
 */
@Slf4j
//@Component
public class AccessTimeRoutePredicateFactory extends AbstractRoutePredicateFactory<AccessTimeConfig> {
    public AccessTimeRoutePredicateFactory() {
        super(AccessTimeConfig.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(AccessTimeConfig config) {
        LocalTime start = config.getStart();
        LocalTime end = config.getEnd();

        return (serverWebExchange) -> {
            log.info("AccessTime -> " + LocalTime.now().toString());

            LocalTime now = LocalTime.now();

            return now.isAfter(start) && now.isBefore(end);
            //return true;
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("start", "end");
    }
}
