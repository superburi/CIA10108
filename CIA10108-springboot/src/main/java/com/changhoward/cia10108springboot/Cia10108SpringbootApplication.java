package com.changhoward.cia10108springboot;


import com.changhoward.cia10108springboot.howard.rentalorder.service.impl.RentalCartServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Cia10108SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cia10108SpringbootApplication.class, args);

        RentalCartServiceImpl cartService = new RentalCartServiceImpl();
//        String rentalNo = "5001";
//        String rentalCatNo = "1";
//        String rentalName = "格紋成套西裝";
//        String rentalPrice = "15500";
//        String rentalSize = "2";
//        String rentalColor = "黑色";
//        String rentalInfo = "款式 : 劍領 單排釦";
//        String rentalStat = "1";
//        Map<String, String> map = new HashMap<>();
//        map.put("rentalNo", rentalNo);
//        map.put("rentalCatNo", rentalCatNo);
//        map.put("rentalName", rentalName);
//        map.put("rentalPrice", rentalPrice);
//        map.put("rentalSize", rentalSize);
//        map.put("rentalColor", rentalColor);
//        map.put("rentalInfo", rentalInfo);
//        map.put("rentalStat", rentalStat);
//        cartService.setToCart(map);
//        cartService.getFromCart("member : 1");

    }

}
