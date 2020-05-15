package com.example;

import com.example.log.EnableLog;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 繁星
 */
@EnableLog
@SpringBootApplication(scanBasePackages = {"com.example"})
@MapperScan("com.example.**.dao")
public class DemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        logger.info(" DemoApplication 启动成功 ");
    }

}
