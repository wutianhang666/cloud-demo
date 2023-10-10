package com.icss.etc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderHygtrixPaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderHygtrixPaymentMain8001.class, args);
        System.out.println("启动成功");
    }
}