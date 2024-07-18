package com.sany;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * ${discription}
 *
 * @author: SanyQAQ
 * @create: ${YEAR}-${MONTH}-${DAY}-${TIME}
 */
@SpringBootApplication(scanBasePackages = {"com.sany"})
@MapperScan("com.sany.mapper")
public class Main8001 {
    public static void main(String[] args) {
        SpringApplication.run(Main8001.class,args);
    }
}