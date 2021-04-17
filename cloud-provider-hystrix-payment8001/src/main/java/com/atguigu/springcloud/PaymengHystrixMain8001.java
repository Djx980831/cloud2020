package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2021-04-12 23:11
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymengHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymengHystrixMain8001.class, args);
    }
}
