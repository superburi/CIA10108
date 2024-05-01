package com.changhoward.cia10108springboot.howard.rentalorderdetails.service.impl;

import com.changhoward.cia10108springboot.Entity.RentalMyTrack;
import com.changhoward.cia10108springboot.Entity.RentalOrderDetails;
import com.changhoward.cia10108springboot.howard.rentalorderdetails.dao.RentalOrderDetailsRepository;
import com.changhoward.cia10108springboot.howard.rentalorderdetails.dto.RentalOrderDetailsRequest;
import com.changhoward.cia10108springboot.howard.rentalorderdetails.service.RentalOrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class RentalOrderDetailsServiceImpl implements RentalOrderDetailsService {

    @Autowired
    private RentalOrderDetailsRepository repository;

    @Override
    public void insert(RentalOrderDetails rentalOrderDetails) {
        repository.save(rentalOrderDetails);
    }

    @Override
    public void update(RentalOrderDetailsRequest details_request) {

        // 取出 PK 、單價、押金
        Integer rOrdNo = details_request.getrOrdNo();
        Integer rNo = details_request.getrNo();
        BigDecimal rPrice = details_request.getrPrice();
        BigDecimal rDesPrice = details_request.getrDesPrice();
        // 裝進內部類別
        RentalOrderDetails.CompositeDetail compositeDetail = new RentalOrderDetails.CompositeDetail(rOrdNo, rNo);
        // 裝進類別
        RentalOrderDetails rentalOrderDetails = new RentalOrderDetails(compositeDetail, rPrice, rDesPrice);
        // 執行更新
        repository.save(rentalOrderDetails);

    }

    @Override
    public RentalOrderDetails findById(Integer rOrdNo, Integer rNo) {

        // 把 PK 裝進內部類別
        RentalOrderDetails.CompositeDetail compositeDetail = new RentalOrderDetails.CompositeDetail(rOrdNo, rNo);
        Optional<RentalOrderDetails> optional = repository.findById(compositeDetail);
        //  有找到 ? 取出物件 : 回傳 null
        RentalOrderDetails detail = optional.orElse(null);
        return detail;

    }

    @Override
    public List<RentalOrderDetails> getAll() {
        return repository.findAll();
    }

}
