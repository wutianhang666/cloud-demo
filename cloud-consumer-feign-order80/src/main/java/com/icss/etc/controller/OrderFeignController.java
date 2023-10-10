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

    /**
     * 演示openfeign服务调用
     * http://localhost/consumer/testFeign
     *
     * @return
     */
    @GetMapping(value = "/consumer/testFeign")
    public String testFeign() {
        return paymentFeignService.testFeign();
    }

    /**
     * 演示OpenFeign超时控制
     * http://localhost/consumer/payment/feign/timeout
     * OpenFeign客户端一般默认等待1秒钟
     * 当前接口调用休眠3秒，所以会报错超时
     * <p>
     * 配置文件添加下面配置可以正常调用
     * #设置feign客户端超时时间(OpenFeign默认支持ribbon)(单位：毫秒)
     * ribbon:
     * ReadTimeout: 5000
     * ConnectTimeout: 5000
     *
     * @return
     */
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // OpenFeign客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
