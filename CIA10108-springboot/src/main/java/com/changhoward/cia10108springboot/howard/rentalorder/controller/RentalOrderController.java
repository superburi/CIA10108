package com.changhoward.cia10108springboot.howard.rentalorder.controller;

import com.changhoward.cia10108springboot.Entity.RentalOrder;
import com.changhoward.cia10108springboot.Entity.RentalOrderDetails;
import com.changhoward.cia10108springboot.howard.rentalorder.dto.RentalOrderRequest;
import com.changhoward.cia10108springboot.howard.rentalorder.service.impl.RentalOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RentalOrderController {

    @Autowired
    private RentalOrderServiceImpl service;

    @PostMapping("/rentalorders/createOrder")
    public String createOrder(@RequestBody RentalOrderRequest order, ModelMap model) {

        // 新增
//        Integer orderNo = service.save(order);
        // 取得創建好的訂單資料
//        RentalOrder rentalOrder = service.findById(orderNo);
//        model.addAttribute("rentalOrder", rentalOrder);
        return "";

    }

    @PutMapping("/rentalorders/updateOrder")
    public String updateOrder(@RequestBody Integer rentalOrdNo,
                              @RequestBody(required = false) Byte rentalPayStat,
                              @RequestBody(required = false) Byte rentalOrdStat,
                              @RequestBody(required = false) Byte rtnStat,
                              @RequestBody(required = false) String rtnRemark,
                              @RequestBody(required = false) BigDecimal rtnCompensation, ModelMap model) {

        // 付款時 => 更改付款狀態 -> 自動

        // 選宅配，商品寄到目的地時 => 變更訂單狀態 -> 自動

        // 歸還時 => 加上歸還註記、加上賠償金額、變更歸還狀態 -> 員工手動

        // 取消訂單時 => 更改訂單狀態 -> 員工手動

        return "";

    }

    @GetMapping("/rentalorders/findOrderById")
    public String findOrderById() {



        return "";

    }

    @GetMapping("/rentalorders/getAllOrders")
    public String getAllOrders() {



        return "";

    }

    @GetMapping("/rentalorders/getOnAny")
    public String getOnAny(@RequestParam(required = false) Integer rentalOrdNo,
                           @RequestParam Integer memNo,
                           @RequestParam(required = false) Timestamp rentalOrdTime,
                           @RequestParam(required = false) Timestamp rentalDate,
                           @RequestParam(required = false) Byte rentalPayStat,
                           @RequestParam(required = false) Byte rentalOrdStat,
                           @RequestParam(required = false)BigDecimal rtnCompensation) {




        return "";

    }






















    @GetMapping("/backend/rentalorder/selectRentalOrder")
    public String toSelect() {
        return "/backend/rentalorder/selectRentalOrder";
    }


    @ModelAttribute("orderList")
    protected List<RentalOrder> getAllData() {
        return service.getAll();
    }


    @GetMapping("/backend/rentalorder/listAllRentalOrder")
    public String getAllProducts() {
        return "/backend/rentalorder/listAllRentalOrder";
    }


    @GetMapping("/backend/rentalorder/getOnAny")
    public String getOnAny(@RequestParam(required = false) Integer rentalOrdNo,
                           @RequestParam(required = false) Integer memNo,
                           @RequestParam(required = false) String rentalByrName,
                           @RequestParam(required = false) String rentalByrPhone,
                           @RequestParam(required = false) String rentalByrEmail,
                           @RequestParam(required = false) String rentalRcvName,
                           @RequestParam(required = false) String rentalRcvPhone,
                           @RequestParam(required = false) Byte rentalTakeMethod,
                           @RequestParam(required = false) String rentalAddr,
                           @RequestParam(required = false) Byte rentalPayMethod,
                           @RequestParam(required = false) BigDecimal rentalAllPrice,
                           @RequestParam(required = false) BigDecimal rentalAllDepPrice,
                           @RequestParam(required = false) Timestamp rentalOrdTime,
                           @RequestParam(required = false) Timestamp rentalDate,
                           @RequestParam(required = false) Timestamp rentalBackDate,
                           @RequestParam(required = false) Timestamp rentalRealBackDate,
                           @RequestParam(required = false) Byte rentalPayStat,
                           @RequestParam(required = false) Byte rentalOrdStat,
                           @RequestParam(required = false) Byte rtnStat,
                           @RequestParam(required = false) String rtnRemark,
                           @RequestParam(required = false) BigDecimal rtnCompensation,
                           ModelMap model) {

        Map<String, Object> map = new HashMap<>();

        if (rentalOrdNo != null) {
            map.put("rentalOrdNo", rentalOrdNo);
        }
        if (memNo != null) {
            map.put("memNo", memNo);
        }
        if (rentalByrName != null) {
            map.put("rentalByrName", rentalByrName);
        }
        if (rentalByrPhone != null) {
            map.put("rentalByrPhone", rentalByrPhone);
        }
        if (rentalByrEmail != null) {
            map.put("rentalByrEmail", rentalByrEmail);
        }
        if (rentalRcvName != null) {
            map.put("rentalRcvName", rentalRcvName);
        }
        if (rentalRcvPhone != null) {
            map.put("rentalRcvPhone", rentalRcvPhone);
        }
        if (rentalTakeMethod != null) {
            map.put("rentalTakeMethod", rentalTakeMethod);
        }
        if (rentalAddr != null) {
            map.put("rentalAddr", rentalAddr);
        }
        if (rentalPayMethod != null) {
            map.put("rentalPayMethod", rentalPayMethod);
        }
        if (rentalAllPrice != null) {
            map.put("rentalAllPrice", rentalAllPrice);
        }
        if (rentalAllDepPrice != null) {
            map.put("rentalAllDepPrice", rentalAllDepPrice);
        }
        if (rentalOrdTime != null) {
            map.put("rentalOrdTime", rentalOrdTime);
        }
        if (rentalDate != null) {
            map.put("rentalDate", rentalDate);
        }
        if (rentalBackDate != null) {
            map.put("rentalBackDate", rentalBackDate);
        }
        if (rentalRealBackDate != null) {
            map.put("rentalRealBackDate", rentalRealBackDate);
        }
        if (rentalPayStat != null) {
            map.put("rentalPayStat", rentalPayStat);
        }
        if (rentalOrdStat != null) {
            map.put("rentalOrdStat", rentalOrdStat);
        }
        if (rtnStat != null) {
            map.put("rtnStat", rtnStat);
        }
        if (rtnRemark != null) {
            map.put("rtnRemark", rtnRemark);
        }
        if (rtnCompensation != null) {
            map.put("rtnCompensation", rtnCompensation);
        }

        List<RentalOrder> rentalOrderList = service.getByAttributes(map);
        model.addAttribute("rentalOrderList", rentalOrderList);
        model.addAttribute("getOnAny", "true");
        return "/backend/rentalorder/selectRentalOrder";

    }





}
