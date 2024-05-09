package com.changhoward.cia10108springboot;


import com.changhoward.cia10108springboot.Entity.RentalOrder;
import com.changhoward.cia10108springboot.howard.rentalorder.dao.RentalOrderRepository;
import com.changhoward.cia10108springboot.howard.rentalorder.service.impl.RentalCartServiceImpl;
import com.changhoward.cia10108springboot.howard.rentalorder.service.impl.RentalOrderServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class Cia10108SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cia10108SpringbootApplication.class, args);
    }

}
