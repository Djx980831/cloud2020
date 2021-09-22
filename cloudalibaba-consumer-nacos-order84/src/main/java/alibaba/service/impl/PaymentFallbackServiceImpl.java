package alibaba.service.impl;

import alibaba.service.PaymentFallbackService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackServiceImpl implements PaymentFallbackService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444444, "服务降级返回， ----paymentFallbackService" , new Payment(id, "errorserial"));
    }
}
