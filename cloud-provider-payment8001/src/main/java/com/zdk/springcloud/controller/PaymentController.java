package com.zdk.springcloud.controller;

import com.zdk.springcloud.entities.CommonResult;
import com.zdk.springcloud.entities.Payment;
import com.zdk.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author zdk
 * @date 2022/5/25 20:04
 */
@Slf4j
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult<Object> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("========== 插入结果：{}",result);
        if (result > 0){
            return new CommonResult<>(200, "插入数据库成功,serverPort : "+serverPort,result);
        }else {
            return new CommonResult<>(444, "插入数据库失败");
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> findPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);
        log.info("========== 查询结果：{}", payment);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功,serverPort : "+serverPort, payment);
        } else {
            return new CommonResult<>(444, "查询失败， i + " + id, null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service->{}",service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()
            +"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return discoveryClient;
    }
}
