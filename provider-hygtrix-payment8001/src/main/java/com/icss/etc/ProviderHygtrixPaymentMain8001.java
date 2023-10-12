package com.icss.etc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker//用于开启熔断器功能
public class ProviderHygtrixPaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderHygtrixPaymentMain8001.class, args);
        System.out.println("启动成功");
    }
}