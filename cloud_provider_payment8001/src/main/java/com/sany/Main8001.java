package com.sany;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * ${discription}
 *
 * @author: SanyQAQ
 * @create: ${YEAR}-${MONTH}-${DAY}-${TIME}
 */
@SpringBootApplication(scanBasePackages = {"com.sany"})
@MapperScan("com.sany.mapper")
//开启服务的发现
@EnableDiscoveryClient
//开启动态刷新
@RefreshScope
public class Main8001 {
    public static void main(String[] args) {
        SpringApplication.run(Main8001.class,args);
    }
}