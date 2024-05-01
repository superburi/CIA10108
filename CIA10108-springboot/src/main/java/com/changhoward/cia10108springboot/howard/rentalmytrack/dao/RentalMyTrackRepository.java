package com.changhoward.cia10108springboot.howard.rentalmytrack.dao;

import com.changhoward.cia10108springboot.Entity.RentalMyTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Component
public interface RentalMyTrackRepository extends JpaRepository<RentalMyTrack, RentalMyTrack.CompositeTrack> {

//    @Query(value = "SELECT rno, memno, rtracktime, exprentaldate FROM rentalmytrack WHERE 1=1:sql", nativeQuery = true)
//    List<RentalMyTrack> findByrnoAndmemnoAndrtracktimeAndexprentaldate(Integer rNo, Integer memNo,
//                                                                       Timestamp rTrackTime, Date expRentalDate);

//    List<RentalMyTrack> findByCompositeTrackAndrTrackTimeAndexpRentalDate(
//            RentalMyTrack.CompositeTrack compositeTrack, Timestamp rTrackTime, Date expRentalDate);

}
