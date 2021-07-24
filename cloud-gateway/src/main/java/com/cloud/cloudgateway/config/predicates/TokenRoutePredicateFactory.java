package com.cloud.cloudgateway.config.predicates;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * @description: 自定义谓词工厂实现类，，需要继承AbstractRoutePredicateFactory 类
 *
 *  案例一：要求请求必须携带一个token，并且token值等于指定的值，才能访问
 *  其中类名有讲究 TokenRoutePredicateFactory =Token（Token为配置网关配置谓词时候，需要用的字符）+RoutePredicateFactory（RoutePredicateFactory为固定写法）
 * @author: zxp
 * @date: Created in 2021/7/21 20:59
 */
@Slf4j
//@Component
public class TokenRoutePredicateFactory extends AbstractRoutePredicateFactory<TokenConfig> {
    /**
     * @description  构造方法，固定写法
     * @author zxp
     * @date 2021/7/21 21:04
     */
    public TokenRoutePredicateFactory() {
        super(TokenConfig.class);
    }

    /**
     * @description  覆盖 shortcutFieldOrder 方法，返回list集合
     * @author zxp
     * @date 2021/7/21 21:06
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("token");
    }

    /**
     * @description  重写谓词的主要实心方法
     * @author zxp
     * @date 2021/7/21 21:08
     */
    @Override
    public Predicate<ServerWebExchange> apply(TokenConfig tokenConfig) {
        // (T t) -> true ， exchange 为参数列表，表示ServerWebExchange对象
        return exchange -> {
            // 获取走网关的所有请求接口的参数,以map形式存放 exchange.getRequest().getQueryParams();
            MultiValueMap<String, String> valueMap = exchange.getRequest().getQueryParams();

            boolean flag = false;

            List<String> list = new ArrayList<>();
            // 获取所有请求参数的值
            valueMap.forEach((k, v) -> {
                list.addAll(v);
            });

            for (String s : list) {
                log.info("Token -> {} ", s);
                 //遍历所有的请求参数，如果和在谓词配置里面配置的Token值  "- Token= 123456" 相等，就直接放行接口。
                if (StringUtils.equalsIgnoreCase(s, tokenConfig.getToken())) {
                    flag = true;
                    break;
                }
            }
            return flag;
        };
    }
}
