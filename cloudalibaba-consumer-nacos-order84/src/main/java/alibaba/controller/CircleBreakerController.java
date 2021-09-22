package alibaba.controller;

import alibaba.service.PaymentFallbackService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback") // 什么都不配置
    //@SentinelResource(value = "fallback", fallback = "handlerFallback") // fallback只负责业务异常
    //@SentinelResource(value = "fallback", blockHandler = "blockHandler") // blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler", exceptionsToIgnore = {IllegalArgumentException.class}) //优先级 blockHandler sentinel控制台
    public CommonResult<Payment> faaaback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalAccessException, 非法参数异常");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException, 该ID没有对应记录。 空指针异常");
        }
        return result;
    }

    //本例是fallback
    public CommonResult handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(444, "兜底异常handlerFallback, exception内容  " + e.getMessage(), payment);
    }

    //本例是 blockHandler
    public CommonResult blockHandler(@PathVariable Long id, BlockException blockException) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(445, "blockException-sentinel限流,无此流水 blockexception  " + blockException.getMessage(), payment);
    }

    @Resource
    private PaymentFallbackService paymentFallbackService;

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentFallbackService.paymentSQL(id);
    }
}