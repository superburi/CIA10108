package com.changhoward.cia10108springboot.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "rentalorderdetails")
public class RentalOrderDetails implements Serializable{

    @EmbeddedId
    private CompositeDetail compositeDetail;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "rordno", referencedColumnName = "rordno", insertable = false, updatable = false)
    private RentalOrder rentalOrder;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "rno", referencedColumnName = "rno", insertable = false, updatable = false)
    private Rental rental;
    @Column(name = "rprice")
    BigDecimal rPrice;
    @Column(name = "rdesprice")
    BigDecimal rDesPrice;

    @Embeddable
    public static class CompositeDetail implements Serializable {

        @Column(name = "rordno")
        private Integer rOrdNo;
        @Column(name = "rno")
        private Integer rNo;

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

        public CompositeDetail() {
        }

        public CompositeDetail(Integer rOrdNo, Integer rNo) {
            this.rOrdNo = rOrdNo;
            this.rNo = rNo;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CompositeDetail that)) return false;
            return Objects.equals(getrOrdNo(), that.getrOrdNo()) && Objects.equals(getrNo(), that.getrNo());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getrOrdNo(), getrNo());
        }

    } // 內部類別結束

    public RentalOrderDetails() {
    }

    public RentalOrderDetails(CompositeDetail compositeDetail, BigDecimal rPrice, BigDecimal rDesPrice) {
        this.compositeDetail = compositeDetail;
        this.rPrice = rPrice;
        this.rDesPrice = rDesPrice;
    }

    public CompositeDetail getCompositeDetail() {
        return compositeDetail;
    }

    public void setCompositeDetail(CompositeDetail compositeDetail) {
        this.compositeDetail = compositeDetail;
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

    public RentalOrder getRentalOrder() {
        return rentalOrder;
    }

    public void setRentalOrder(RentalOrder rentalOrder) {
        this.rentalOrder = rentalOrder;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    @Override
    public String toString() {
        return "RentalOrderDetails{" +
                ", rentalOrder=" + compositeDetail.getrOrdNo() +
                ", rental=" + compositeDetail.getrNo() +
                ", rPrice=" + rPrice +
                ", rDesPrice=" + rDesPrice +
                '}' + "\n";
    }
}


