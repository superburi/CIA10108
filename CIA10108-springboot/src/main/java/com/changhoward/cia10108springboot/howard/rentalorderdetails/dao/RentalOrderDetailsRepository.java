package com.changhoward.cia10108springboot.howard.rentalorderdetails.dao;

import com.changhoward.cia10108springboot.Entity.RentalOrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RentalOrderDetailsRepository extends JpaRepository<RentalOrderDetails, RentalOrderDetails.CompositeDetail> {



}
