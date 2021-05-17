package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @param
 * @Description
 * @Author dongjingxiong
 * @return
 * @Date 2021-05-16 23:01
 */
@RestController
@RefreshScope //支持nacos动态刷新
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getCOnfigInfo() {
        return configInfo;
    }
}
