package com.icss.etc.controller;

import com.icss.etc.Service.PaymentFeignService;
import com.icss.etc.pojo.CommonResult;
import com.icss.etc.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    /**
     * 演示openfeign服务调用
     * http://localhost/consumer/payment/get/22
     * 调用cloud-payment-service8001服务中的 getPaymentById 接口
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

}
