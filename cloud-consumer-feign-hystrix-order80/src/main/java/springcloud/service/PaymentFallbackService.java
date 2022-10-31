package springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author zdk
 * @Date 2022/10/31 16:24
 */
@Component
public class PaymentFallbackService implements PaymentFeignHystrixService{
    @Override
    public String paymentInfoOk(Integer id) {
        return "调用失败-----PaymentFallbackService fallback-paymentInfoOk";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "调用失败-----PaymentFallbackService fallback-paymentInfoTimeout";
    }
}
