package com.icss.etc.Service;

import com.icss.etc.pojo.CommonResult;
import com.icss.etc.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @FeignClient：这是Feign库提供的注解，用于声明一个Feign客户端
 * 解释：调用名为"cloud-payment-service8001"的远程服务
 */
@Component
@FeignClient(value = "provider-payment8001")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
