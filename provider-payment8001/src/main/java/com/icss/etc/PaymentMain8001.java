package com.icss.etc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentMain8001 {

    public static void main(String[] args) {
        System.out.println("开始启动");
        SpringApplication.run(PaymentMain8001.class, args);
        System.out.println("启动成功");
    }
}
