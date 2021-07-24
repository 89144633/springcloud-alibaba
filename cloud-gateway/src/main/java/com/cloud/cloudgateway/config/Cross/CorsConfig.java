package com.cloud.cloudgateway.config.Cross;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * @description: gateway 支持跨域的请求
 * @author: zxp
 * @date: Created in 2021/7/22 23:33
 */
@Configuration
public class CorsConfig {
    @Bean
    public CorsWebFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedMethod("*"); //是什么请求方法，比如 GET POST PUT DELATE .....
        config.addAllowedOrigin("*"); //来自哪个域名的请求，*号表示所有
        config.addAllowedHeader("*"); //是什么请求头

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}
