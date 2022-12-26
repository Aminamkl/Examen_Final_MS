package com.example.eurikadiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurikaDiscoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurikaDiscoveryServiceApplication.class, args);
    }

}
