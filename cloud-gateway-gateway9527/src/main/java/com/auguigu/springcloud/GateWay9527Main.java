package com.auguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2021-04-22 23:48
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWay9527Main {
    public static void main(String[] args) {
        SpringApplication.run(GateWay9527Main.class, args);
    }
}
