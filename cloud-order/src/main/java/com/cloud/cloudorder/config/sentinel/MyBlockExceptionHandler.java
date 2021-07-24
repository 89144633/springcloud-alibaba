package com.cloud.cloudorder.config.sentinel;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 自定义sentinel 限流策略返回提示语
 * @author: zxp
 * @date: Created in 2021/7/13 20:55
 */
@Slf4j
// 加入到spring容器中
@Component
public class MyBlockExceptionHandler implements BlockExceptionHandler {

    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {

        log.info("sentinel 限流自定义方法执行。。。。。。。");
        RestObject restObject = null;

        // 实例化5种异常，代表控制台的5种异常规则
        if (e instanceof FlowException) {  // 流控规则,接口进行限流，每秒超过指定的访问速度，就会进行限流
            restObject = RestObject.builder().statusCode(100).statusMessage("接口限流了").build();

        } else if (e instanceof DegradeException) { //降级规则
            restObject = RestObject.builder().statusCode(101).statusMessage("服务降级了").build();

        } else if (e instanceof ParamFlowException) { // 热点规则
            restObject = RestObject.builder().statusCode(102).statusMessage("热点参数限流了").build();

        } else if (e instanceof SystemBlockException) { //系统规则
            restObject = RestObject.builder().statusCode(103).statusMessage("触发系统保护规则").build();

        } else if (e instanceof AuthorityException) { //授权规则
            restObject = RestObject.builder().statusCode(104).statusMessage("授权规则不通过").build();
        }

        //返回json数据
        httpServletResponse.setStatus(500);
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        //springmvc 的一个json转换类 （jackson）
        new ObjectMapper().writeValue(httpServletResponse.getWriter(), restObject);

        //跳转
        //request.getRequestDispatcher("/index.jsp").forward(request, response);

        //重定向
        //response.sendRedirect("http://www.baidu.com");
    }

}
