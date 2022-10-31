package springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springcloud.service.PaymentFeignHystrixService;

import javax.annotation.Resource;

/**
 * @Description
 * @Author zdk
 * @Date 2022/10/26 17:46
 */
@Slf4j
@RestController
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderFeignHystrixController {

    @Resource
    private PaymentFeignHystrixService paymentFeignService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String findPaymentById(@PathVariable("id") Integer id) {
        return paymentFeignService.paymentInfoOk(id);
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id) {
        return paymentFeignService.paymentInfoTimeout(id);
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout1/{id}")
//    @HystrixCommand(fallbackMethod = "timeoutHandler", commandProperties =
//            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")})
    @HystrixCommand
    public String timeout1(@PathVariable("id") Integer id) {
        //模拟报错
        int a = 10/0;
        return paymentFeignService.paymentInfoTimeout(id);
    }

    public String timeoutHandler(@PathVariable("id") Integer id){
        return "消费者80发现被调用方系统繁忙~~~~";
    }

    //下面是全局fallback方法
    public String paymentGlobalFallbackMethod(){
        return "Global异常处理信息,请稍后再试~~~~~";
    }


}
