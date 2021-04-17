package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 2021-04-12 23:12
 */
@Service
public class PaymentService {

    //成功
    public String paymentInfo_OK(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_OK,id:  " + id + "\t" + "😄";
    }

    //失败
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_Timeout(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_OK,id:  " + id + "\t" + "耗时（秒）";
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "系统繁忙，请稍后重试！,id:  " + id + "\t" + "降级处理方法。";
    }
}
