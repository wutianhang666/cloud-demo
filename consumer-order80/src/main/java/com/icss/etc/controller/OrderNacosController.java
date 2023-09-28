package com.icss.etc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;

    //获取提供者路径
    @Value("${service-url.nacos-user-service}")
    private String serverURL;


    /**
     * 测试服务注册和负载均衡
     * 浏览器访问 http://localhost/consumer/payment/nacos/1
     * 调用 9001  9002
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        System.out.println(serverURL + "/payment/nacos/");
        return restTemplate.getForObject(serverURL + "/payment/nacos/" + id, String.class);
    }
}
