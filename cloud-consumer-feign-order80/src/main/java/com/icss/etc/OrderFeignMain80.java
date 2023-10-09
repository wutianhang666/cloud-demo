package com.icss.etc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @EnableFeignClients注解用于启用Feign客户端功能，它会自动扫描和注册被@FeignClient注解的接口，并提供方便的API来进行远程服务的调用。
 * Feign将自动将服务注册到Nacos中，并从Nacos获取服务列表以进行服务调用
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
        System.out.println("启动完成");
    }
}