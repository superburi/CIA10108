package com.changhoward.cia10108springboot.howard.rentalorder.controller;

import com.changhoward.cia10108springboot.howard.rentalorder.service.impl.RentalOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class RentalOrderController {

    @Autowired
    private RentalOrderServiceImpl service;

    @PostMapping("/rentalorders/createOrder")
    public String createOrder() {




        return "frontend/orderOKTest";

    }

    @PutMapping("/rentalorders/updateOrder")
    public String updateOrder() {



        return "frontend/orderOKTest";

    }

    @GetMapping("/rentalorders/findOrderById")
    public String findOrderById() {



        return "frontend/orderOKTest";

    }

    @GetMapping("/rentalorders/getAllOrders")
    public String getAllOrders() {



        return "frontend/orderOKTest";

    }

}
