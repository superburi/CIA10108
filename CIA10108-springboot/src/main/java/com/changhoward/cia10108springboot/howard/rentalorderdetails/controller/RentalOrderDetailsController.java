package com.changhoward.cia10108springboot.howard.rentalorderdetails.controller;

import com.changhoward.cia10108springboot.Entity.RentalMyTrack;
import com.changhoward.cia10108springboot.Entity.RentalOrderDetails;
import com.changhoward.cia10108springboot.howard.rentalorderdetails.dto.RentalOrderDetailsRequest;
import com.changhoward.cia10108springboot.howard.rentalorderdetails.service.impl.RentalOrderDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RentalOrderDetailsController {

    @Autowired
    private RentalOrderDetailsServiceImpl service;

    @PostMapping("/rentalorderdetails/insert")
    public String insert(@RequestBody @Valid RentalOrderDetailsRequest details_request, ModelMap model) {

        // 先把 PK 、單價、押金 取出
        Integer rentalOrdNo = details_request.getrentalOrdNo();
        Integer rentalNo = details_request.getrentalNo();
        BigDecimal rentalPrice = details_request.getrentalPrice();
        BigDecimal rentalDesPrice = details_request.getrentalDesPrice();
        // 資料是否已存在 ? 新增過了 : 繼續執行新增
        if (service.findById(rentalOrdNo, rentalNo) != null) {
            model.addAttribute("already", "已經新增過了");
            return "/index";
        }
        // 沒有，就裝進內部類別
        RentalOrderDetails.CompositeDetail compositeDetail = new RentalOrderDetails.CompositeDetail(rentalOrdNo, rentalNo);
        // 裝進類別
        RentalOrderDetails details_checked = new RentalOrderDetails(compositeDetail, rentalPrice, rentalDesPrice);
        service.insert(details_checked);
        // 新增完查查看有沒有新增成功
        RentalOrderDetails details_return = service.findById(rentalOrdNo, rentalNo);
        model.addAttribute("details", details_return);
        return "";

    }

    @PostMapping("/rentalorderdetails/update")
    public String update(@RequestParam @NotBlank Integer rentalOrdNo,
                         @RequestParam @NotBlank Integer rentalNo,
                         @RequestParam @NotBlank BigDecimal rentalPrice,
                         @RequestParam @NotBlank BigDecimal rentalDesPrice,
                         ModelMap model) {

        // 先查查看該明細是否存在
        if (service.findById(rentalOrdNo, rentalNo) == null) {
            model.addAttribute("noData", "查無資料，無法更新");
            return "redirect:/backend/rentalorderdetails/updateRentalOrderDetails";
        }
        // 存在，開始修改
        RentalOrderDetails.CompositeDetail compositeDetail = new RentalOrderDetails.CompositeDetail(rentalOrdNo, rentalNo);
        RentalOrderDetails rentalOrderDetails = new RentalOrderDetails(compositeDetail, rentalPrice, rentalDesPrice);
        service.update(rentalOrderDetails);
        // 改完查詢出來回傳
        RentalOrderDetails details_return = service.findById(rentalOrdNo, rentalNo);
        model.addAttribute("details", details_return);
        return "redirect:/backend/rentalorderdetails/listAllRentalOrderDetails";

    }

    @GetMapping("/rentalorderdetails/findById/{rentalOrdNo}/{rentalNo}")
    public String findById(@PathVariable @NotBlank Integer rentalOrdNo, @PathVariable @NotBlank Integer rentalNo,
                           ModelMap model) {

        RentalOrderDetails details = service.findById(rentalOrdNo, rentalNo);
        if (details == null) {
            model.addAttribute("noData", "查無資料");
            return "/index";
        }
        model.addAttribute("details", details);
//        System.out.println(details);
        return "";

    }

    @GetMapping("/rentalorderdetails/getAll")
    public String getAll(ModelMap model) {

        List<RentalOrderDetails> detailsList = service.getAll();
        model.addAttribute("detailsList", detailsList);
        System.out.println(detailsList);
        return "";

    }
















    @GetMapping("/backend/rentalorderdetails/selectRentalOrderDetails")
    public String toSelect() {
        return "/backend/rentalorderdetails/selectRentalOrderDetails";
    }


    @ModelAttribute("detailList")
    protected List<RentalOrderDetails> getAllData() {
        return service.getAll();
    }


    @GetMapping("/backend/rentalorderdetails/listAllRentalOrderDetails")
    public String getAllProducts() {
        return "/backend/rentalorderdetails/listAllRentalOrderDetails";
    }


    @GetMapping("/backend/rentalorderdetails/listAllToUpdateRentalOrderDetails")
    public String listAllToUpdate(@RequestParam Integer rentalOrdNo,
                                  @RequestParam Integer rentalNo,
                                  @RequestParam BigDecimal rentalPrice,
                                  @RequestParam BigDecimal rentalDesPrice,
                                  ModelMap model) {

        model.addAttribute("rentalOrdNo", rentalOrdNo);
        model.addAttribute("rentalNo", rentalNo);
        model.addAttribute("rentalPrice", rentalPrice);
        model.addAttribute("rentalDesPrice", rentalDesPrice);
        return "/backend/rentalorderdetails/updateRentalOrderDetails";

    }


    @GetMapping("/backend/rentalorderdetails/getOnAny")
    public String getOnAny(@RequestParam(required = false) Integer rentalOrdNo,
                           @RequestParam(required = false) Integer rentalNo,
                           @RequestParam(required = false) BigDecimal rentalPrice,
                           @RequestParam(required = false) BigDecimal rentalDesPrice,
                           ModelMap model) {

        Map<String, Object> map = new HashMap<>();

        if (rentalOrdNo != null) {
            map.put("rentalOrdNo", rentalOrdNo);
        }
        if (rentalNo != null) {
            map.put("rentalNo", rentalNo);
        }
        if (rentalPrice != null) {
            map.put("rentalPrice", rentalPrice);
        }
        if (rentalDesPrice != null) {
            map.put("rentalDesPrice", rentalDesPrice);
        }

        List<RentalOrderDetails> rentalOrderDetailsList = service.getByAttributes(map);
        model.addAttribute("rentalOrderDetailsList", rentalOrderDetailsList);
        model.addAttribute("getOnAny", "true");
        return "/backend/rentalorderdetails/selectRentalOrderDetails";

    }



}
