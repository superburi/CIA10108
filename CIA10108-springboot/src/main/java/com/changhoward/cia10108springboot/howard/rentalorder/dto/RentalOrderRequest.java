package com.changhoward.cia10108springboot.howard.rentalorder.dto;

import com.changhoward.cia10108springboot.Entity.Member;
import com.changhoward.cia10108springboot.Entity.RentalOrderDetails;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class RentalOrderRequest {

    private Integer rOrdNo; // -> 租借訂單編號
    @NotBlank
    private Integer memNo; // -> 會員編號
    @NotBlank
    private String rByrName; // -> 訂購人姓名
    @NotBlank
    private String rByrPhone; // -> 訂購人手機號碼
    @NotBlank
    @Email
    private String rByrEmail; // -> 訂購人Email

    private String rRcvName; // -> 收件人姓名
    private String rRcvPhone; // -> 收件人手機號碼
    @NotBlank
    private byte rTakeMethod; // -> 取貨方式
    private String rAddr; // -> 宅配住址
    @NotBlank
    private byte rPayMethod; // -> 付款方式
    @NotBlank
    private BigDecimal rAllPrice; // -> 訂單總金額
    @NotBlank
    private BigDecimal rAllDepPrice; // -> 押金總金額
    private Timestamp rOrdTime; // -> 下單時間
    @NotBlank
    private Timestamp rDate; // -> 預計租借日期
    @NotBlank
    private Timestamp rBackDate; // -> 預計歸還日期

    private Timestamp rRealBackDate; // -> 實際歸還日期
    @NotBlank
    private byte rPayStat; // -> 付款狀態

    private byte rOrdStat; // -> 訂單狀態

    private byte rtnStat; // -> 歸還狀態
    private String rtnRemark; // -> 歸還註記
    private BigDecimal rtnCompensation; // -> 賠償金額
    @NotEmpty
    private List<RentalOrderDetails> buyItems; // -> 購買明細

    public Integer getrOrdNo() {
        return rOrdNo;
    }

    public void setrOrdNo(Integer rOrdNo) {
        this.rOrdNo = rOrdNo;
    }

    public Integer getMemNo() {
        return memNo;
    }

    public void setMemNo(Integer memNo) {
        this.memNo = memNo;
    }

    public String getrByrName() {
        return rByrName;
    }

    public void setrByrName(String rByrName) {
        this.rByrName = rByrName;
    }

    public String getrByrPhone() {
        return rByrPhone;
    }

    public void setrByrPhone(String rByrPhone) {
        this.rByrPhone = rByrPhone;
    }

    public String getrByrEmail() {
        return rByrEmail;
    }

    public void setrByrEmail(String rByrEmail) {
        this.rByrEmail = rByrEmail;
    }

    public String getrRcvName() {
        return rRcvName;
    }

    public void setrRcvName(String rRcvName) {
        this.rRcvName = rRcvName;
    }

    public String getrRcvPhone() {
        return rRcvPhone;
    }

    public void setrRcvPhone(String rRcvPhone) {
        this.rRcvPhone = rRcvPhone;
    }

    public byte getrTakeMethod() {
        return rTakeMethod;
    }

    public void setrTakeMethod(byte rTakeMethod) {
        this.rTakeMethod = rTakeMethod;
    }

    public String getrAddr() {
        return rAddr;
    }

    public void setrAddr(String rAddr) {
        this.rAddr = rAddr;
    }

    public byte getrPayMethod() {
        return rPayMethod;
    }

    public void setrPayMethod(byte rPayMethod) {
        this.rPayMethod = rPayMethod;
    }

    public BigDecimal getrAllPrice() {
        return rAllPrice;
    }

    public void setrAllPrice(BigDecimal rAllPrice) {
        this.rAllPrice = rAllPrice;
    }

    public BigDecimal getrAllDepPrice() {
        return rAllDepPrice;
    }

    public void setrAllDepPrice(BigDecimal rAllDepPrice) {
        this.rAllDepPrice = rAllDepPrice;
    }

    public Timestamp getrOrdTime() {
        return rOrdTime;
    }

    public void setrOrdTime(Timestamp rOrdTime) {
        this.rOrdTime = rOrdTime;
    }

    public Timestamp getrDate() {
        return rDate;
    }

    public void setrDate(Timestamp rDate) {
        this.rDate = rDate;
    }

    public Timestamp getrBackDate() {
        return rBackDate;
    }

    public void setrBackDate(Timestamp rBackDate) {
        this.rBackDate = rBackDate;
    }

    public Timestamp getrRealBackDate() {
        return rRealBackDate;
    }

    public void setrRealBackDate(Timestamp rRealBackDate) {
        this.rRealBackDate = rRealBackDate;
    }

    public byte getrPayStat() {
        return rPayStat;
    }

    public void setrPayStat(byte rPayStat) {
        this.rPayStat = rPayStat;
    }

    public byte getrOrdStat() {
        return rOrdStat;
    }

    public void setrOrdStat(byte rOrdStat) {
        this.rOrdStat = rOrdStat;
    }

    public byte getRtnStat() {
        return rtnStat;
    }

    public void setRtnStat(byte rtnStat) {
        this.rtnStat = rtnStat;
    }

    public String getRtnRemark() {
        return rtnRemark;
    }

    public void setRtnRemark(String rtnRemark) {
        this.rtnRemark = rtnRemark;
    }

    public BigDecimal getRtnCompensation() {
        return rtnCompensation;
    }

    public void setRtnCompensation(BigDecimal rtnCompensation) {
        this.rtnCompensation = rtnCompensation;
    }

    public List<RentalOrderDetails> getBuyItems() {
        return buyItems;
    }

    public void setBuyItems(List<RentalOrderDetails> buyItems) {
        this.buyItems = buyItems;
    }

}
