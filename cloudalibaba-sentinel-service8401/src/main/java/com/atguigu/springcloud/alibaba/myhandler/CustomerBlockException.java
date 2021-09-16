package com.atguigu.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @param
 * @Description TODO
 * @Author dongjingxiong
 * @return
 * @Date 9/17/21 12:21 AM
 */
public class CustomerBlockException {
    public static CommonResult handlerException1(BlockException exception) {
        return new CommonResult(444, "客户自定义Exception1111，CustomerBlockException");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444, "客户自定义Exception2222，CustomerBlockException");
    }
}
