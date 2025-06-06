package com.example.memberpaymentproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class MemberPaymentProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberPaymentProjectApplication.class, args);
    }

}
