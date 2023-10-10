package com.icss.etc.Service;

import com.icss.etc.pojo.CommonResult;
import com.icss.etc.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * value：指定要调用的远程服务的名称。该属性是必须的，用于唯一标识要调用的远程服务。
 *
 * configuration：指定Feign客户端的配置类。该属性是可选的，如果不指定，则使用默认的配置类。可以传递一个或多个@Configuration类型的Bean定义，用于配置Feign客户端的行为。
 *
 * name：指定Feign客户端的名称。等同于value
 *
 * fallback：指定Feign客户端的回退类。该属性是可选的，用于指定在调用远程服务失败时使用的备用实现类。
 *
 * decode404：指定是否对404错误进行解码。该属性是可选的，默认为false，表示不解码。如果设置为true，当调用远程服务返回404错误时，Feign会将其解码为相应的错误信息。
 *
 * encoder：指定Feign请求和响应的编码器。该属性是可选的，用于指定请求和响应的编码方式。可以使用自定义的编码器来处理特定的数据类型。
 *
 * contract：指定Feign客户端的契约类。该属性是可选的，用于指定Feign客户端的契约类，用于定义和约束远程服务的方法签名。
 *
 * path：指定Feign客户端的路径。该属性是可选的，用于指定Feign客户端的请求路径前缀。
 *
 * scopes：指定Feign客户端的作用域。该属性是可选的，用于指定Feign客户端的作用域，可以是RequestScope、SessionScope或GlobalScope。
 */

/**
 * @FeignClient：这是Feign库提供的注解，用于声明一个Feign客户端
 * 解释：调用名为"cloud-payment-service8001"的远程服务
 */
@Component
@FeignClient(value = "provider-payment8001")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);


    /**
     * 调用是根据 @GetMapping(value = "/payment/testFeign666")路径来匹配远程接口的。
     * 当使用@FeignClient注解声明一个Feign客户端时，可以通过value属性指定要调用的远程服务的名称。
     * 在上述代码中，@FeignClient(value = "provider-payment8001")指定了要调用名为"provider-payment8001"的远程服务。
     *
     * 当调用PaymentFeignService接口中的testFeign()方法时，OpenFeign会根据接口上的@GetMapping注解
     * 以及指定的路径/payment/testFeign666来查找远程服务的接口定义。
     * 它会扫描类路径下的所有组件，查找带有@GetMapping注解的类，并解析出对应的URL路径。
     * 然后，OpenFeign会将这些信息与远程服务的名称进行匹配，找到对应的接口定义。
     *
     * 如果找到了匹配的接口定义，OpenFeign就会将请求转发给相应的服务实现类，
     * 并返回结果。在这个例子中，testFeign()方法被调用时，
     * OpenFeign会将请求转发给名为"provider-payment8001"的远程服务的/payment/testFeign666接口定义，并返回结果。
     *
     */
    @GetMapping(value = "/payment/testFeign666")
    public String testFeign();

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
