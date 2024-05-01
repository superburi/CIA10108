package com.changhoward.cia10108springboot.howard.rentalorderdetails.dto;



import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RentalOrderDetailsRequest {

    @NotNull
    Integer rOrdNo; // -> 租借訂單編號
    @NotNull
    Integer rNo; // -> 租借品編號
    @NotNull
    BigDecimal rPrice; // -> 單價
    @NotNull
    BigDecimal rDesPrice; // -> 押金

    public Integer getrOrdNo() {
        return rOrdNo;
    }

    public void setrOrdNo(Integer rOrdNo) {
        this.rOrdNo = rOrdNo;
    }

    public Integer getrNo() {
        return rNo;
    }

    public void setrNo(Integer rNo) {
        this.rNo = rNo;
    }

    public BigDecimal getrPrice() {
        return rPrice;
    }

    public void setrPrice(BigDecimal rPrice) {
        this.rPrice = rPrice;
    }

    public BigDecimal getrDesPrice() {
        return rDesPrice;
    }

    public void setrDesPrice(BigDecimal rDesPrice) {
        this.rDesPrice = rDesPrice;
    }

}
