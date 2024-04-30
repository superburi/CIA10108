package com.changhoward.cia10108springboot.howard.rentalmytrack.dao;

import com.changhoward.cia10108springboot.Entity.RentalMyTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface RentalMyTrackRepository extends JpaRepository<RentalMyTrack, RentalMyTrack.CompositeTrack> {

    @Query(value = "SELECT rNo, memNo, rTrackTime, expRentalDate FROM rentalmytrack WHERE 1=1", nativeQuery = true)
    List<RentalMyTrack> findByAny(String sql);

}
