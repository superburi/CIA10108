package com.changhoward.cia10108springboot.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rentalmytrack")
public class RentalMyTrack implements Serializable {

    @EmbeddedId
    private CompositeTrack compositeTrack;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "rno", referencedColumnName = "rno", insertable = false, updatable = false)
    private Rental rental;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "memno", referencedColumnName = "memno", insertable = false, updatable = false)
    private Member member;
    @Column(name = "rtracktime")
    private Timestamp rTrackTime;
    @Column(name = "exprentaldate")
    private Date expRentalDate;

    @Embeddable
    public static class CompositeTrack implements Serializable {

        @Column(name = "rno")
        private Integer rNo;

        @Column(name = "memno")
        private Integer memNo;

        public Integer getrNo() {
            return rNo;
        }

        public void setrNo(Integer rNo) {
            this.rNo = rNo;
        }

        public Integer getMemNo() {
            return memNo;
        }

        public void setMemNo(Integer memNo) {
            this.memNo = memNo;
        }

        public CompositeTrack() {
        }

        public CompositeTrack(Integer rNo, Integer memNo) {
            this.rNo = rNo;
            this.memNo = memNo;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CompositeTrack that)) return false;
            return Objects.equals(getrNo(), that.getrNo()) && Objects.equals(getMemNo(), that.getMemNo());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getrNo(), getMemNo());
        }

    } // 內部類別結束

    public RentalMyTrack() {
    }

    public RentalMyTrack(CompositeTrack compositeTrack, Timestamp rTrackTime) {
        this.compositeTrack = compositeTrack;
        this.rTrackTime = rTrackTime;
    }

    public RentalMyTrack(CompositeTrack compositeTrack, Date expRentalDate) {
        this.compositeTrack = compositeTrack;
        this.expRentalDate = expRentalDate;
    }

    public RentalMyTrack(CompositeTrack compositeTrack, Timestamp rTrackTime, Date expRentalDate) {
        this.compositeTrack = compositeTrack;
        this.rTrackTime = rTrackTime;
        this.expRentalDate = expRentalDate;
    }

    public CompositeTrack getCompositeTrack() {
        return compositeTrack;
    }

    public void setCompositeTrack(CompositeTrack compositeTrack) {
        this.compositeTrack = compositeTrack;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Timestamp getrTrackTime() {
        return rTrackTime;
    }

    public void setrTrackTime(Timestamp rTrackTime) {
        this.rTrackTime = rTrackTime;
    }

    public Date getExpRentalDate() {
        return expRentalDate;
    }

    public void setExpRentalDate(Date expRentalDate) {
        this.expRentalDate = expRentalDate;
    }


    @Override
    public String toString() {
        return "RentalMyTrack{" +
                "rNo=" + compositeTrack.getrNo() +
                "memNo=" + compositeTrack.getMemNo() +
                ", rTrackTime=" + rTrackTime +
                ", expRentalDate=" + expRentalDate +
                '}' + "\n";
    }

}
