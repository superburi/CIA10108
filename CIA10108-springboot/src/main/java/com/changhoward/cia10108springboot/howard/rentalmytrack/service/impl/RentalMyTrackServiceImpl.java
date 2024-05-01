package com.changhoward.cia10108springboot.howard.rentalmytrack.service.impl;

import com.changhoward.cia10108springboot.Entity.RentalMyTrack;
import com.changhoward.cia10108springboot.howard.rentalmytrack.dao.RentalMyTrackRepository;
import com.changhoward.cia10108springboot.howard.rentalmytrack.dto.RentalMyTrackRequest_PUT;
import com.changhoward.cia10108springboot.howard.rentalmytrack.service.RentalMyTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Component
public class RentalMyTrackServiceImpl implements RentalMyTrackService {

    @Autowired
    RentalMyTrackRepository rentalMyTrackRepository;

    @Override
    public void insert(RentalMyTrack rentalMyTrack) {
        rentalMyTrackRepository.save(rentalMyTrack);
    }
    @Override
    public void update(RentalMyTrackRequest_PUT rmt) {

        // 取出 PK、期望租借日期
        Integer rNo = rmt.getrNo();
        Integer memNo = rmt.getMemNo();
        Date expRentalDate = rmt.getExpRentalDate();
        // 把 PK 存進內部類別
        RentalMyTrack.CompositeTrack compositeTrack = new RentalMyTrack.CompositeTrack(rNo, memNo);
        // 用 PK 取得該筆資料(物件) (因為 rTrackTime 是 NotNull)
        RentalMyTrack rentalMyTrack2 = findById(rNo, memNo);
        // 用該資料(物件)去取得加入追蹤時間
        Timestamp rTrackTime = rentalMyTrack2.getrTrackTime();
        // 把得到的資料裝進物件裡
        RentalMyTrack rentalMyTrack = new RentalMyTrack(compositeTrack, rTrackTime, expRentalDate);
        // 執行更新
        rentalMyTrackRepository.save(rentalMyTrack);

    }
    @Override
    public RentalMyTrack findById(Integer rNo, Integer memNo) {

        // 先把 PK 裝進內部類別
        RentalMyTrack.CompositeTrack compositeTrack = new RentalMyTrack.CompositeTrack(rNo, memNo);
        Optional<RentalMyTrack> rentalMyTrackOptional = rentalMyTrackRepository.findById(compositeTrack);
        // 有找到 ? 取出物件 : 回傳 null
        RentalMyTrack rmt = rentalMyTrackOptional.orElse(null);
        return rmt;

    }
    @Override
    public List<RentalMyTrack> getAll() {
        return rentalMyTrackRepository.findAll();
    }

//    public List<RentalMyTrack> findByAny(Map<String, Object> map) {
//
//        if (map.isEmpty()) {
//            return rentalMyTrackRepository.findAll();
//        }

//        Integer rNo = null;
//        Integer memNo = null;
//        Timestamp rTrackTime = null;
//        Date expRentalDate = null;
//
//        if (map.containsKey("rNo")) {
//            rNo = (Integer) map.get("rNo");
//        }
//        if (map.containsKey("memNo")) {
//            memNo = (Integer) map.get("memNo");
//        }
//        if (map.containsKey("rTrackTime")) {
//            rTrackTime = (Timestamp) map.get("rTrackTime");
//        }
//        if (map.containsKey("expRentalDate")) {
//            expRentalDate = (Date) map.get("expRentalDate");
//        }

//        RentalMyTrack.CompositeTrack compositeTrack = new RentalMyTrack.CompositeTrack(rNo, memNo);
//        return rentalMyTrackRepository.findByCompositeTrackAndrTrackTimeAndexpRentalDate(
//                compositeTrack, rTrackTime, expRentalDate
//        );

//        return rentalMyTrackRepository.findByRnoAndMemno(rNo, memNo);

//        return rentalMyTrackRepository.findByrnoAndmemnoAndrtracktimeAndexprentaldate(rNo, memNo, rTrackTime, expRentalDate);

//        StringBuilder stringBuilder = new StringBuilder("SELECT rno, memno, rtracktime, exprentaldate " +
//                "FROM rentalmytrack WHERE 1=1");
//
//        if (map.containsKey("rNo")) {
//            stringBuilder.append(" AND rNo LIKE "+ "'%" +  map.get("rNo") + "%'");
//        }
//        if (map.containsKey("memNo")) {
//            stringBuilder.append(" AND memNo LIKE " + "'%" + map.get("memNo") + "%'");
//        }
//        if (map.containsKey("rTrackTime")) {
//            stringBuilder.append(" AND rTrackTime LIKE " + "'%" + map.get("rTrackTime") + "%'");
//        }
//        if (map.containsKey("expRentalDate")) {
//            stringBuilder.append(" AND expRentalDate LIKE " + "'%" + map.get("expRentalDate") + "%'");
//        }

//        String append = stringBuilder.toString();
//        System.out.println(append);
//        // 實際執行的 SQL 語句 = RentalMyTrackRepository 裡方法的 @Query 註解裡的 value + 各種條件集合而成的 append 字串
//        return rentalMyTrackRepository.findBySql(append);

//    }

}
