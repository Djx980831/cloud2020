package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @param
 * @Description
 * @Author dongjingxiong
 * @return
 * @Date 2021-04-29 23:52
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamConsumerMQMain8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerMQMain8803.class, args);
    }
}
