package com.bcfou.bannerspringboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BannerSpringbootApplication {

    public static void main(String[] args) {

        SpringApplication.run(BannerSpringbootApplication.class, args);
        //app.setBannerMode(Banner.Mode.OFF);
        //app.run(args);
    }
}
