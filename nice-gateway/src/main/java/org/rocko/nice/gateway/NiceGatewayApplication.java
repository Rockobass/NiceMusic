package org.rocko.nice.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "org.rocko.nice.gateway.mybatis")
public class NiceGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(NiceGatewayApplication.class, args);
    }
}
