package com.changhoward.cia10108springboot.howard.rentalorder.dao;

import com.changhoward.cia10108springboot.Entity.RentalOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RentalOrderRepository extends JpaRepository<RentalOrder, Integer> {



}

