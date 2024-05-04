package com.changhoward.cia10108springboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Timestamp;
@SpringBootApplication
public class Cia10108SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cia10108SpringbootApplication.class, args);
    }

}
