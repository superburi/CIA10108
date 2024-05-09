package com.changhoward.cia10108springboot.howard.rentalorder.service.impl;

import com.changhoward.cia10108springboot.Entity.Member;
import com.changhoward.cia10108springboot.Entity.Rental;
import com.changhoward.cia10108springboot.Entity.RentalOrder;
import com.changhoward.cia10108springboot.Entity.RentalOrderDetails;
import com.changhoward.cia10108springboot.howard.rentalorder.dao.MemberRepository;
import com.changhoward.cia10108springboot.howard.rentalorder.dao.RentalOrderRepository;
import com.changhoward.cia10108springboot.howard.rentalorder.dao.RentalRepository;
import com.changhoward.cia10108springboot.howard.rentalorder.dto.RentalOrderRequest;
import com.changhoward.cia10108springboot.howard.rentalorder.service.RentalOrderService;
import com.changhoward.cia10108springboot.howard.rentalorderdetails.dao.RentalOrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@Component
public class RentalOrderServiceImpl implements RentalOrderService {

    @Autowired
    private RentalOrderRepository repository;

    @Autowired
    private RentalOrderDetailsRepository detailsRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    RentalRepository rentalRepository;

    @Transactional
    public void update(Map<String, Object> map) {

        Integer rentalOrdNo = (Integer) map.get("rentalOrdNo");
        Optional<RentalOrder> rentalOrderOptional = repository.findById(rentalOrdNo);

        RentalOrder rentalOrder = rentalOrderOptional.orElse(null);
        if (map.containsKey("rentalPayStat")) {
            rentalOrder.setrentalPayStat((Byte) map.get("rentalPayStat"));
        }
        if (map.containsKey("rentalOrdStat")) {
            rentalOrder.setrentalOrdStat((Byte) map.get("rentalOrdStat"));
        }
        if (map.containsKey("rtnStat")) {
            rentalOrder.setRtnStat((Byte) map.get("rtnStat"));
        }
        if (map.containsKey("rtnRemark")) {
            rentalOrder.setRtnRemark((String) map.get("rtnRemark"));
        }
        if (map.containsKey("rtnCompensation")) {
            rentalOrder.setRtnCompensation((BigDecimal) map.get("rtnCompensation"));
        }
        repository.save(rentalOrder);

    }

    @Override
    public List<RentalOrder> getAll() {
        return repository.findAll();
    }

    public List<RentalOrder> getByAttributes(Map<String, Object> map) {

        if (map.isEmpty()) {
            return repository.findAll();
        }

        Integer rentalOrdNo = null;
        Integer memNo = null;
        String rentalByrName = null;
        String rentalByrPhone = null;
        String rentalByrEmail = null;
        String rentalRcvName = null;
        String rentalRcvPhone = null;
        Byte rentalTakeMethod = null;
        String rentalAddr = null;
        Byte rentalPayMethod = null;
        BigDecimal rentalAllPrice = null;
        BigDecimal rentalAllDepPrice = null;
        Timestamp rentalOrdTime = null;
        Timestamp rentalDate = null;
        Timestamp rentalBackDate = null;
        Timestamp rentalRealBackDate = null;
        Byte rentalPayStat = null;
        Byte rentalOrdStat = null;
        Byte rtnStat = null;
        String rtnRemark = null;
        BigDecimal rtnCompensation = null;
        if (map.containsKey("rentalOrdNo")) {
            rentalOrdNo = (Integer) map.get("rentalOrdNo");
        }
        if (map.containsKey("memNo")) {
            memNo = (Integer) map.get("memNo");
        }
        if (map.containsKey("rentalByrName")) {
            rentalByrName = (String) map.get("rentalByrName");
        }
        if (map.containsKey("rentalByrPhone")) {
            rentalByrPhone = (String) map.get("rentalByrPhone");
        }
        if (map.containsKey("rentalByrEmail")) {
            rentalByrEmail = (String) map.get("rentalByrEmail");
        }
        if (map.containsKey("rentalRcvName")) {
            rentalRcvName = (String) map.get("rentalRcvName");
        }
        if (map.containsKey("rentalRcvPhone")) {
            rentalRcvPhone = (String) map.get("rentalRcvPhone");
        }
        if (map.containsKey("rentalTakeMethod")) {
            rentalTakeMethod = (Byte) map.get("rentalTakeMethod");
        }
        if (map.containsKey("rentalAddr")) {
            rentalAddr = (String) map.get("rentalAddr");
        }
        if (map.containsKey("rentalPayMethod")) {
            rentalPayMethod = (Byte) map.get("rentalPayMethod");
        }
        if (map.containsKey("rentalAllPrice")) {
            rentalAllPrice = (BigDecimal) map.get("rentalAllPrice");
        }
        if (map.containsKey("rentalAllDepPrice")) {
            rentalAllDepPrice = (BigDecimal) map.get("rentalAllDepPrice");
        }
        if (map.containsKey("rentalOrdTime")) {
            rentalOrdTime = (Timestamp) map.get("rentalOrdTime");
        }
        if (map.containsKey("rentalDate")) {
            rentalDate = (Timestamp) map.get("rentalDate");
        }
        if (map.containsKey("rentalBackDate")) {
            rentalBackDate = (Timestamp) map.get("rentalBackDate");
        }
        if (map.containsKey("rentalRealBackDate")) {
            rentalRealBackDate = (Timestamp) map.get("rentalRealBackDate");
        }
        if (map.containsKey("rentalPayStat")) {
            rentalPayStat = (Byte) map.get("rentalPayStat");
        }
        if (map.containsKey("rentalOrdStat")) {
            rentalOrdStat = (Byte) map.get("rentalOrdStat");
        }
        if (map.containsKey("rtnStat")) {
            rtnStat = (Byte) map.get("rtnStat");
        }
        if (map.containsKey("rtnRemark")) {
            rtnRemark = (String) map.get("rtnRemark");
        }
        if (map.containsKey("rtnCompensation")) {
            rtnCompensation = (BigDecimal) map.get("rtnCompensation");
        }

        return repository.findByAttributes(rentalOrdNo, memNo, rentalByrName, rentalByrPhone, rentalByrEmail,
                rentalRcvName, rentalRcvPhone, rentalTakeMethod, rentalAddr, rentalPayMethod, rentalAllPrice,
                rentalAllDepPrice, rentalOrdTime, rentalDate, rentalBackDate, rentalRealBackDate, rentalPayStat,
                rentalOrdStat, rtnStat, rtnRemark, rtnCompensation);

    }

    @Transactional
    public void createOrder(RentalOrderRequest req) {
        // 新增訂單
        RentalOrder order = new RentalOrder();
        Optional<Member> members = memberRepository.findById(req.getMemNo());
        Member member = members.orElse(null);
        order.setMember(member);
        order.setrentalByrName(req.getrentalByrName());
        order.setrentalByrPhone(req.getrentalByrPhone());
        order.setrentalByrEmail(req.getrentalByrEmail());
        order.setrentalRcvName(req.getrentalRcvName());
        order.setrentalRcvPhone(req.getrentalRcvPhone());
        order.setrentalTakeMethod(req.getrentalTakeMethod());
        order.setrentalAddr(req.getrentalAddr());
        order.setrentalPayMethod(req.getrentalPayMethod());
        order.setrentalAllPrice(req.getrentalAllPrice());
        order.setrentalAllDepPrice(req.getrentalAllDepPrice());
        order.setrentalOrdTime(req.getrentalOrdTime());
        order.setrentalDate(req.getrentalDate());
        order.setrentalBackDate(req.getrentalBackDate());
        order.setrentalRealBackDate(req.getrentalRealBackDate());
        order.setrentalPayStat(req.getrentalPayStat());
        order.setrentalOrdStat(req.getrentalOrdStat());
        order.setRtnStat(req.getRtnStat());
        order.setRtnRemark(req.getRtnRemark());

        repository.save(order);

        List<String> buyItems = req.getBuyItems();
        Set<RentalOrderDetails> details = new HashSet<>();
        for (String buyItem : buyItems) {

            RentalOrderDetails detail = new RentalOrderDetails();
            Rental rental = rentalRepository.findById(Integer.valueOf(buyItem)).orElse(null);
            detail.setRental(rental);
            detail.setCompositeDetail(new RentalOrderDetails.CompositeDetail(order.getrentalOrdNo(), rental.getrentalNo()));
            detail.setrentalPrice(rental.getrentalPrice());
            detail.setrentalDesPrice(rental.getRentalCategory().getrentalDesPrice());

            // 單一明細加入明細集合
            details.add(detail);

        }
        // 明細放進訂單主體
        order.setRentalOrderDetailses(details);

    }

}
