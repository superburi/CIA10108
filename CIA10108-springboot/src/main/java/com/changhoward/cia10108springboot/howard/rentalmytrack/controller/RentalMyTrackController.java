package com.changhoward.cia10108springboot.howard.rentalmytrack.controller;

import com.changhoward.cia10108springboot.Entity.RentalMyTrack;
import com.changhoward.cia10108springboot.howard.rentalmytrack.dto.RentalMyTrackRequest;
import com.changhoward.cia10108springboot.howard.rentalmytrack.dto.RentalMyTrackRequest_PUT;
import com.changhoward.cia10108springboot.howard.rentalmytrack.service.impl.RentalMyTrackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Validated
@Controller
public class RentalMyTrackController {

    @Autowired
    private RentalMyTrackServiceImpl rentalMyTrackService;

    @PostMapping("/rentalmytracks/insert")
    public String insert(@RequestBody @Valid RentalMyTrackRequest rentalMyTrackRequest,
                         ModelMap model) {

        // 先把 PK 取出
        Integer rNo = rentalMyTrackRequest.getrNo();
        Integer memNo = rentalMyTrackRequest.getMemNo();
        // 資料是否已存在 ? 新增過了 : 繼續執行新增
        if (rentalMyTrackService.findById(rNo, memNo) != null) {
            model.addAttribute("already", "已經新增過了");
            return "/index";
        }
        // 沒有，就裝進內部類別
        RentalMyTrack.CompositeTrack compositeTrack = new RentalMyTrack.CompositeTrack(rNo, memNo);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        // 裝進類別
        RentalMyTrack rentalMyTrack = new RentalMyTrack(compositeTrack, timestamp);
        rentalMyTrackService.insert(rentalMyTrack);
        // 新增完查查看有沒有新增成功
        RentalMyTrack rentalMyTrack1 = rentalMyTrackService.findById(rNo, memNo);
        model.addAttribute("rentalMyTrack", rentalMyTrack1);
        return "frontend/rmtOKTest";

    }

    @PutMapping("/rentalmytracks/update")
    public String update(@RequestBody @Valid RentalMyTrackRequest_PUT rentalMyTrackRequest_PUT,
                         ModelMap model) {

        // 先查查看該商品是否存在
        Integer rNo = rentalMyTrackRequest_PUT.getrNo();
        Integer memNo = rentalMyTrackRequest_PUT.getMemNo();
        if (rentalMyTrackService.findById(rNo, memNo) == null) {
            model.addAttribute("noData", "查無資料，無法更新");
            return "/index";
        }
        // 檢查期望租借日期是否早於或等於今天
        Date expRentalDate = rentalMyTrackRequest_PUT.getExpRentalDate();
        Date toDay = new Date(System.currentTimeMillis());
        if (expRentalDate.compareTo(toDay) <= 0) {
            model.addAttribute("wrongDate", "日期不能早於或等於今天");
            return "/index";
        }
        // 有查到且日期正確，開始修改
        rentalMyTrackService.update(rentalMyTrackRequest_PUT);
        // 改完之後查詢出來回傳
        RentalMyTrack rentalMyTrack = rentalMyTrackService.findById(rNo, memNo);
        model.addAttribute("rentalMyTrack", rentalMyTrack);
        return "frontend/rmtOKTest";

    }
    @GetMapping("/rentalmytracks/findById/{rNo}/{memNo}")
    public String findById(@PathVariable  @NotBlank Integer rNo, @PathVariable @NotBlank Integer memNo,
                           ModelMap model) {

        RentalMyTrack rentalMyTrack = rentalMyTrackService.findById(rNo, memNo);
        if (rentalMyTrack == null) {
            model.addAttribute("noData", "查無資料");
            return "/index";
        }
        model.addAttribute("rentalMyTrack", rentalMyTrack);
        return "frontend/rmtOKTest";

    }

    @GetMapping("/rentalmytracks/getAll")
    public String getAll(ModelMap model) {

        List<RentalMyTrack> rentalMyTrackList = rentalMyTrackService.getAll();
        System.out.println(rentalMyTrackList);
        model.addAttribute("rentalMyTrackList", rentalMyTrackList);
        return "frontend/rmtOKTest";

    }

//    @GetMapping("/rentalmytracks/getOnAny")
//    public String getOnAny() {
//
//        Map<String, Object> map = new HashMap<>();
//
//        map.put("rNo", 5001);
//
//        List<RentalMyTrack> rentalMyTrackList = rentalMyTrackService.findByAny(map);
//
//        System.out.println( Arrays.toString( rentalMyTrackList.toArray() ) );
//
//        return "frontend/test";
//
//    }

}
