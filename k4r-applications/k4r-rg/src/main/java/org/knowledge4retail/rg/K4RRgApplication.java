package org.knowledge4retail.rg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class K4RRgApplication {
    public static void main(String[] args) {
        SpringApplication.run(K4RRgApplication.class, args);
    }
}
