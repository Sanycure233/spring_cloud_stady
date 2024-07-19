package com.sany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ${discription}
 *
 * @author: SanyQAQ
 * @create: ${YEAR}-${MONTH}-${DAY}-${TIME}
 */
//使用服务器的发现
@EnableDiscoveryClient

@SpringBootApplication
public class Main80 {
    public static void main(String[] args) {
        SpringApplication.run(Main80.class,args);
    }
}