package com.cloud.cloudorder.config.swagger;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @date: 2021/7/20 13:32
 * @author: zxp
 **/
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {
    //是否开启swagger，正式环境一般是需要关闭的，可根据springboot的yml多环境配置进行设置
   // @Value(value = "${swagger.enabled}")
    private Boolean swaggerEnabled=true;
    String local= InetAddress.getLocalHost().getHostAddress();

    @Value("${server.port}")
    String port;

    // 定义分隔符,配置Swagger多包
    private static final String splitor = ";";

    public SwaggerConfig() throws UnknownHostException {
    }

    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(swaggerEnabled)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cloud.cloudorder"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private ApiInfo apiInfo(){

        return new ApiInfoBuilder()
                .title("springCloudAlibaba微服务案例")
                .description("订单模块")
                .version("1.0.0").contact(new Contact("赵辛平","http://localhost:8083/api/order/**","173951228@qq.com"))
                .termsOfServiceUrl("gateway网关地址：http://localhost:8083/api/order/**")
                .build();
    }

    private List<ApiKey> securitySchemes() {
        List<ApiKey> apiKeys = new ArrayList<>();
        apiKeys.add(new ApiKey("Authorization", "Authorization", "header"));
        return apiKeys;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("^(?!auth).*$")).build());
        return securityContexts;
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }


}
