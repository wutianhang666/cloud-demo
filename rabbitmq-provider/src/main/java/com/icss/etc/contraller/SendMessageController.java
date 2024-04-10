package com.icss.etc.contraller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class SendMessageController {

    //使用RabbitTemplate,这提供了接收/发送等等方法
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 测试 直连交换机
     * <p>
     * 访问：  http://localhost:8021/sendDirectMessage
     *
     * @return
     */
    @GetMapping("/sendDirectMessage/{message}")
    public String sendDirectMessage(@PathVariable(value = "message") String message) {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = message;
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
        return "请求成功";
    }

    /**
     * 测试 扇形交换机
     * <p>
     * 访问：  http://localhost:8021/sendDirectMessage
     *
     * @return
     */
    @GetMapping("/sendFanoutMessage/{message}")
    public String sendFanoutMessage(@PathVariable(value = "message") String message) {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = message;
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
        rabbitTemplate.convertAndSend("fanoutExchange", null, map);
        return "ok";
    }

}
