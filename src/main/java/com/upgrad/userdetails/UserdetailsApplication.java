package com.upgrad.userdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class UserdetailsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserdetailsApplication.class, args);
    }

}
