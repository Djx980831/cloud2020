package com.atguigu.springcloud.alibaba.service;

import java.math.BigDecimal;

public interface AccountService {
    public void decrease(Long userId, BigDecimal money);
}
