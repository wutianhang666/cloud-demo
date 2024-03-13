package com.icss.etc.Service;

import com.icss.etc.pojo.FrameProjectDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @FeignClient：这是Feign库提供的注解，用于声明一个Feign客户端 解释：调用名为"cloud-payment-service8001"的远程服务
 */
@Component
@FeignClient(value = "Test9191FeignService", url = "http://localhost:9141")
public interface Test9191FeignService {


    @GetMapping(value = "/v1/frame/frameOnHand/projectDropdown")
    public Object projectDropdown(@SpringQueryMap FrameProjectDto frameProjectDto);
}
