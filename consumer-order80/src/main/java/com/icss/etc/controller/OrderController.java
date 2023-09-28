package com.icss.etc.controller;

import com.icss.etc.pojo.CommonResult;
import com.icss.etc.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderController {

    //RestTemplate配置类上不加 @LoadBalanced 负载均衡注解时，当前类中的方法可以调用
    //加上 @LoadBalanced 注解，http:// 后面不能加端口，需要加端口对应的nacos中服务名称
    //支付模块路径
    public static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    /**
     * 通过订单80模块访问支付模块8001的新增方法
     *
     * @param payment
     * @return
     */
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {

        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    /**
     * 通过订单80模块访问支付模块8001的查询方法
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        System.out.println("通过订单模块 80，访问支付模块 8001");
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
