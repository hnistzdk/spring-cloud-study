package com.zdk.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author zdk
 * @Date 2022/11/10 15:33
 */
@Configuration
public class GatewayConfig {
    /**
     * 配置了一个id为guonei_route的路由规则
     * 当访问地址 http://localhost:9527/guonei时会自动转发到地址 http://news.baidu.com/guonei
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("guonei_route",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"));
        return routes.build();
    }
}
