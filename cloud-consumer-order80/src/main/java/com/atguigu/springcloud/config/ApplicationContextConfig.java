package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @param
 * @Description
 * @Author dongjingxiong
 * @return
 * @Date 2021-03-31 22:57
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced //此注解赋予了RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
