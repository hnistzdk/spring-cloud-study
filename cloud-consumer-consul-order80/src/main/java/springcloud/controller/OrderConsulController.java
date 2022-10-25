package springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zdk
 * @date 2022/5/25 20:51
 */
@Slf4j
@RestController
public class OrderConsulController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    /**
     * 调用地址改为微服务的名称(yaml中的application.name,这样调用时就会去eureka中获取提供者)
     */
    public static final String PAYMENT_URL = "http://consul-provider-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String create(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul", String.class);
    }
}
