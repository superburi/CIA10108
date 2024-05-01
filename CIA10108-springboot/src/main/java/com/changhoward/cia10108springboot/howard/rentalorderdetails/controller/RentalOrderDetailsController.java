package com.changhoward.cia10108springboot.howard.rentalorderdetails.controller;

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
import java.util.List;

@Controller
public class RentalOrderDetailsController {

    @Autowired
    private RentalOrderDetailsServiceImpl service;

    @PostMapping("/rentalorderdetails/insert")
    public String insert(@RequestBody @Valid RentalOrderDetailsRequest details_request, ModelMap model) {

        // 先把 PK 、單價、押金 取出
        Integer rOrdNo = details_request.getrOrdNo();
        Integer rNo = details_request.getrNo();
        BigDecimal rPrice = details_request.getrPrice();
        BigDecimal rDesPrice = details_request.getrDesPrice();
        // 資料是否已存在 ? 新增過了 : 繼續執行新增
        if (service.findById(rOrdNo, rNo) != null) {
            model.addAttribute("already", "已經新增過了");
            return "/index";
        }
        // 沒有，就裝進內部類別
        RentalOrderDetails.CompositeDetail compositeDetail = new RentalOrderDetails.CompositeDetail(rOrdNo, rNo);
        // 裝進類別
        RentalOrderDetails details_checked = new RentalOrderDetails(compositeDetail, rPrice, rDesPrice);
        service.insert(details_checked);
        // 新增完查查看有沒有新增成功
        RentalOrderDetails details_return = service.findById(rOrdNo, rNo);
        model.addAttribute("details", details_return);
        return "frontend/detailsOKTest";

    }

    @PutMapping("/rentalorderdetails/update")
    public String update(@RequestBody @Valid RentalOrderDetailsRequest details_request, ModelMap model) {

        // 先查查看該明細是否存在
        Integer rOrdNo = details_request.getrOrdNo();
        Integer rNo = details_request.getrNo();
        if (service.findById(rOrdNo, rNo) == null) {
            model.addAttribute("noData", "查無資料，無法更新");
            return "/index";
        }
        // 存在，開始修改
        service.update(details_request);
        // 改完查詢出來回傳
        RentalOrderDetails details_return = service.findById(rOrdNo, rNo);
        model.addAttribute("details", details_return);
        return "frontend/detailsOKTest";

    }

    @GetMapping("/rentalorderdetails/findById/{rOrdNo}/{rNo}")
    public String findById(@PathVariable @NotBlank Integer rOrdNo, @PathVariable @NotBlank Integer rNo,
                           ModelMap model) {

        RentalOrderDetails details = service.findById(rOrdNo, rNo);
        if (details == null) {
            model.addAttribute("noData", "查無資料");
            return "/index";
        }
        model.addAttribute("details", details);
//        System.out.println(details);
        return "frontend/detailsOKTest";

    }

    @GetMapping("/rentalorderdetails/getAll")
    public String getAll(ModelMap model) {

        List<RentalOrderDetails> detailsList = service.getAll();
        model.addAttribute("detailsList", detailsList);
        System.out.println(detailsList);
        return "frontend/detailsOKTest";

    }

}
