package com.codewalnut.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 异步日志测试程序
 *
 * @author KelvinZ
 */
@SpringBootApplication
public class DemoLogApplication {
    private static Logger log = LoggerFactory.getLogger(DemoLogApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoLogApplication.class, args);

        log.info(log.getClass().getName());
        log.error("ERROR level print");
        log.warn("Warn level print");
        long bgn = System.currentTimeMillis();
        for (int i = 1; i <= 500000; i++) {
            log.info("this is a test {}", i);
        }
        long end = System.currentTimeMillis();

        log.info("Used {} ms", end - bgn);
        System.out.println(end - bgn);
    }
}
