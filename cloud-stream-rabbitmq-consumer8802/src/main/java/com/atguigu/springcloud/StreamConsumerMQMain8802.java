package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2021-04-28 23:39
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamConsumerMQMain8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerMQMain8802.class, args);
    }
}
