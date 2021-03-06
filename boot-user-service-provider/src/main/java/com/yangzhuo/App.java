package com.yangzhuo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * SpringBoot与dubbo整合的三种方式
 * 1）、导入dubbo-starter,在application.properties配置属性，使用@Service【暴露服务】，@Reference【引用服务】
 * 2）、保留dubbo xml配置文件
 *      导入dubbo-starter，使用@ImportResource导入dubbo的配置文件即可
 * 3）、使用注解api,将每一个组件手动创建到容器中
 */
@EnableHystrix
@EnableDubbo
//@EnableDubbo(scanBasePackages = "com.yangzhuo.gmall")
@SpringBootApplication
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
