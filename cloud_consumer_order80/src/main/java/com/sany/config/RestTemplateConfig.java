package com.sany.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 为了获得RestTemplate对象
 * 这个对象的作用，大概就是提高Restful风格请求的效率
 * @author: SanyQAQ
 * @create: 2024-07-18-14:50
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    //使这个类支持负载均衡
    @LoadBalanced
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
