package com.recollar.recollar_backend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RecollarBackendApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RecollarBackendApplication.class, args); 
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(RecollarBackendApplication.class);
    }

}
