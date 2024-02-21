package com.ijse.furniturecompanyback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class FurnitureCompanyBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(FurnitureCompanyBackApplication.class, args);
    }

}
