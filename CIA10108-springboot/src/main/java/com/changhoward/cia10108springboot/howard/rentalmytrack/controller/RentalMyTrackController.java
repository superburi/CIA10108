package com.changhoward.cia10108springboot.howard.rentalmytrack.controller;

import com.changhoward.cia10108springboot.Entity.RentalMyTrack;
import com.changhoward.cia10108springboot.howard.rentalmytrack.dao.RentalMyTrackRepository;
import com.changhoward.cia10108springboot.howard.rentalmytrack.service.impl.RentalMyTrackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
public class RentalMyTrackController {

    @Autowired
    private RentalMyTrackServiceImpl rentalMyTrackService;

    @PostMapping("/rentalmytracks/insert")
    public String insert() {

        rentalMyTrackService.insert(5001, 2);

        return "frontend/test";

    }

    @PostMapping("/rentalmytracks/update")
    public String update() {

        LocalDate localDate = LocalDate.now();
        Date expRentalDate = Date.valueOf(localDate);

        rentalMyTrackService.update(5001, 2, expRentalDate);

        return "frontend/test";

    }
    @GetMapping("/rentalmytracks/findById")
    public String findById() {

        RentalMyTrack rentalMyTrack = rentalMyTrackService.findById(5001, 2);

        System.out.println(rentalMyTrack);

        return "frontend/test";

    }

    @GetMapping("/rentalmytracks/getAll")
    public String getAll() {

        List<RentalMyTrack> rentalMyTrackList = rentalMyTrackService.getAll();
        System.out.println(rentalMyTrackList);

        return "frontend/test";

    }



}
