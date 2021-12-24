package com.yuce.envanter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableConfigurationProperties
@PropertySource("classpath:env.properties")
@PropertySource("classpath:application.properties")
public class EnvanterTakipApplication {

    @Value("${localPassword}")
    private static String localPassword;

    @Value("${encryptedPasswordMD5}")
    private static String herokuPassword;

    public static void main(String[] args) {
        SpringApplication.run(EnvanterTakipApplication.class, args);
    }

}
