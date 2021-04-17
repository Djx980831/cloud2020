package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2021-04-17 14:55
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "------- PaymentFallbackService fall back-paymentInfo_OK";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "------- PaymentFallbackService fall back-paymentInfo_Timeout";
    }
}
