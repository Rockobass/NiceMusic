package org.rocko.nice.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NiceAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(NiceAuthApplication.class, args);
    }
}
