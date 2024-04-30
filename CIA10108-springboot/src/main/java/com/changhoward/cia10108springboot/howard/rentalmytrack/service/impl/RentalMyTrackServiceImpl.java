package com.changhoward.cia10108springboot.howard.rentalmytrack.service.impl;


import com.changhoward.cia10108springboot.Entity.Member;
import com.changhoward.cia10108springboot.Entity.Rental;
import com.changhoward.cia10108springboot.Entity.RentalCategory;
import com.changhoward.cia10108springboot.Entity.RentalMyTrack;
import com.changhoward.cia10108springboot.howard.rentalmytrack.dao.RentalMyTrackRepository;
import com.changhoward.cia10108springboot.howard.rentalmytrack.service.RentalMyTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class RentalMyTrackServiceImpl implements RentalMyTrackService {

    @Autowired
    RentalMyTrackRepository rentalMyTrackRepository;

    public void insert(Integer rNo, Integer memNo) {

        RentalMyTrack.CompositeTrack compositeTrack = new RentalMyTrack.CompositeTrack(5001, 2);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        // 追蹤
        RentalMyTrack rentalMyTrack = new RentalMyTrack(compositeTrack, timestamp);

        rentalMyTrackRepository.save(rentalMyTrack);

    }

    public void update(Integer rNo, Integer memNo, Date expRentalDate) {

        // 把複合主鍵的值先存進內部類別
        RentalMyTrack.CompositeTrack compositeTrack = new RentalMyTrack.CompositeTrack(rNo, memNo);
        // 為了取得加入追蹤時間(NotNull)，所以先拿裝好的複合主鍵去找該追蹤資料
//        Optional<RentalMyTrack> rentalMyTrack1 = rentalMyTrackRepository.findById(compositeTrack);
        // 找到之後，把資料從集合裡面取出
//        RentalMyTrack rentalMyTrack2 = rentalMyTrack1.orElse(null);

        RentalMyTrack rentalMyTrack2 = findById(rNo, memNo);

        // 用該資料(物件)去取得加入追蹤時間
        Timestamp timestamp = rentalMyTrack2.getrTrackTime();
        // 把得到的資料裝進物件裡
        RentalMyTrack rentalMyTrack = new RentalMyTrack(compositeTrack,timestamp, expRentalDate);
        // 執行更新
        rentalMyTrackRepository.save(rentalMyTrack);

    }

    public RentalMyTrack findById(Integer rNo, Integer memNo) {

        RentalMyTrack.CompositeTrack compositeTrack = new RentalMyTrack.CompositeTrack(rNo, memNo);

        Optional<RentalMyTrack> rentalMyTrack1 = rentalMyTrackRepository.findById(compositeTrack);
        RentalMyTrack rentalMyTrack2 = rentalMyTrack1.orElse(null);

        return rentalMyTrack2;

    }

    public List<RentalMyTrack> getAll() {

        return rentalMyTrackRepository.findAll();

    }


    public List<RentalMyTrack> findByAny(Map<String, Object> map) {

        StringBuilder stringBuilder = new StringBuilder();

        if (map.containsKey("rNo")) {
            stringBuilder.append(" AND rNo LIKE " + "'%" +  map.get("rNo") + "%'");
        }
        if (map.containsKey("memNo")) {
            stringBuilder.append(" AND memNo LIKE " + "'%" + map.get("memNo") + "%'");
        }
        if (map.containsKey("rTrackTime")) {
            stringBuilder.append(" AND rTrackTime LIKE " + "'%" + map.get("rTrackTime") + "%'");
        }
        if (map.containsKey("expRentalDate")) {
            stringBuilder.append(" AND expRentalDate LIKE " + "'%" + map.get("expRentalDate") + "%'");
        }

        String append = stringBuilder.toString();
        // 實際執行的 SQL 語句 = RentalMyTrackRepository 裡方法的 @Query 註解裡的 value + 各種條件集合而成的 append 字串
        return rentalMyTrackRepository.findByAny(append);

    }

}
