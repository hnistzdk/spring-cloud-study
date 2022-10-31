package springcloud.service;

import com.zdk.springcloud.entities.CommonResult;
import com.zdk.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description
 * @Author zdk
 * @Date 2022/10/26 17:40
 */
@Component
//指定Feign调用的服务的名称(payment8001的名称)
@FeignClient(value = "cloud-payment-hystrix-service",fallback = PaymentFallbackService.class)
public interface PaymentFeignHystrixService {

    /**
     * 指定接口
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfoOk(@PathVariable("id") Integer id);

    /**
     * 超时测试接口
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfoTimeout(@PathVariable("id") Integer id);
}
