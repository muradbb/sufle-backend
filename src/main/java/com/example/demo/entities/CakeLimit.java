package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cake_limits")
public class CakeLimit {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long firstBatchLimit;
    @Column
    private long firstBatchDone;
    @Column
    private long secBatchLimit;
    @Column
    private long secBatchDone;
    @Column
    private long thirdBatchLimit;
    @Column
    private long thirdBatchDone;
    @Column
    private long fourthBatchLimit;
    @Column
    private long fourthBatchDone;
    @Column
    private long fifthBatchLimit;
    @Column
    private long fifthBatchDone;
    @Column
    private long sixthBatchLimit;
    @Column
    private long sixthBatchDone;
    @Column
    private long seventhBatchLimit;
    @Column
    private long seventhBatchDone;
    @Column
    private long eighthBatchLimit;
    @Column
    private long eighthBatchDone;
    @Column
    private long ninthBatchLimit;
    @Column
    private long ninthBatchDone;
    @Column
    private long tenthBatchLimit;
    @Column
    private long tenthBatchDone;
    @Column
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    @Column
    private String type;

    @Transient
    private boolean availability[]=new boolean[10];

    public CakeLimit(){
        firstBatchLimit=0;
        secBatchLimit=0;
        thirdBatchLimit=0;
        fourthBatchLimit=0;
        fifthBatchLimit=0;
        sixthBatchLimit=0;
        seventhBatchLimit=0;
        eighthBatchLimit=0;
        ninthBatchLimit=0;
        tenthBatchLimit=0;
    }

    public long getId() {
        return id;
    }

    public CakeLimit setId(long id) {
        this.id = id;
        return this;
    }

    public long getFirstBatchLimit() {
        return firstBatchLimit;
    }

    public CakeLimit setFirstBatchLimit(long firstBatchLimit) {
        this.firstBatchLimit = firstBatchLimit;
        return this;
    }

    public long getFirstBatchDone() {
        return firstBatchDone;
    }

    public CakeLimit setFirstBatchDone(long firstBatchDone) {
        this.firstBatchDone = firstBatchDone;
        return this;
    }

    public long getSecBatchLimit() {
        return secBatchLimit;
    }

    public CakeLimit setSecBatchLimit(long secBatchLimit) {
        this.secBatchLimit = secBatchLimit;
        return this;
    }

    public long getSecBatchDone() {
        return secBatchDone;
    }

    public CakeLimit setSecBatchDone(long secBatchDone) {
        this.secBatchDone = secBatchDone;
        return this;
    }

    public long getThirdBatchLimit() {
        return thirdBatchLimit;
    }

    public CakeLimit setThirdBatchLimit(long thirdBatchLimit) {
        this.thirdBatchLimit = thirdBatchLimit;
        return this;
    }

    public long getThirdBatchDone() {
        return thirdBatchDone;
    }

    public CakeLimit setThirdBatchDone(long thirdBatchDone) {
        this.thirdBatchDone = thirdBatchDone;
        return this;
    }

    public long getFourthBatchLimit() {
        return fourthBatchLimit;
    }

    public CakeLimit setFourthBatchLimit(long fourthBatchLimit) {
        this.fourthBatchLimit = fourthBatchLimit;
        return this;
    }

    public long getFourthBatchDone() {
        return fourthBatchDone;
    }

    public CakeLimit setFourthBatchDone(long fourthBatchDone) {
        this.fourthBatchDone = fourthBatchDone;
        return this;
    }

    public long getFifthBatchLimit() {
        return fifthBatchLimit;
    }

    public CakeLimit setFifthBatchLimit(long fifthBatchLimit) {
        this.fifthBatchLimit = fifthBatchLimit;
        return this;
    }

    public long getFifthBatchDone() {
        return fifthBatchDone;
    }

    public CakeLimit setFifthBatchDone(long fifthBatchDone) {
        this.fifthBatchDone = fifthBatchDone;
        return this;
    }

    public long getSixthBatchLimit() {
        return sixthBatchLimit;
    }

    public CakeLimit setSixthBatchLimit(long sixthBatchLimit) {
        this.sixthBatchLimit = sixthBatchLimit;
        return this;
    }

    public long getSixthBatchDone() {
        return sixthBatchDone;
    }

    public CakeLimit setSixthBatchDone(long sixthBatchDone) {
        this.sixthBatchDone = sixthBatchDone;
        return this;
    }

    public long getSeventhBatchLimit() {
        return seventhBatchLimit;
    }

    public CakeLimit setSeventhBatchLimit(long seventhBatchLimit) {
        this.seventhBatchLimit = seventhBatchLimit;
        return this;
    }

    public long getSeventhBatchDone() {
        return seventhBatchDone;
    }

    public CakeLimit setSeventhBatchDone(long seventhBatchDone) {
        this.seventhBatchDone = seventhBatchDone;
        return this;
    }

    public long getEighthBatchLimit() {
        return eighthBatchLimit;
    }

    public CakeLimit setEighthBatchLimit(long eighthBatchLimit) {
        this.eighthBatchLimit = eighthBatchLimit;
        return this;
    }

    public long getEighthBatchDone() {
        return eighthBatchDone;
    }

    public CakeLimit setEighthBatchDone(long eighthBatchDone) {
        this.eighthBatchDone = eighthBatchDone;
        return this;
    }

    public long getNinthBatchLimit() {
        return ninthBatchLimit;
    }

    public CakeLimit setNinthBatchLimit(long ninthBatchLimit) {
        this.ninthBatchLimit = ninthBatchLimit;
        return this;
    }

    public long getNinthBatchDone() {
        return ninthBatchDone;
    }

    public CakeLimit setNinthBatchDone(long ninthBatchDone) {
        this.ninthBatchDone = ninthBatchDone;
        return this;
    }

    public long getTenthBatchLimit() {
        return tenthBatchLimit;
    }

    public CakeLimit setTenthBatchLimit(long tenthBatchLimit) {
        this.tenthBatchLimit = tenthBatchLimit;
        return this;
    }

    public long getTenthBatchDone() {
        return tenthBatchDone;
    }

    public CakeLimit setTenthBatchDone(long tenthBatchDone) {
        this.tenthBatchDone = tenthBatchDone;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public CakeLimit setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public boolean[] getAvailability() {
        return availability;
    }

    public CakeLimit setAvailability(boolean[] availability) {
        this.availability = availability;
        return this;
    }

    public String getType() {
        return type;
    }

    public CakeLimit setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "CakeLimit{" +
                "id=" + id +
                ", firstBatchLimit=" + firstBatchLimit +
                ", firstBatchDone=" + firstBatchDone +
                ", secBatchLimit=" + secBatchLimit +
                ", secBatchDone=" + secBatchDone +
                ", thirdBatchLimit=" + thirdBatchLimit +
                ", thirdBatchDone=" + thirdBatchDone +
                ", fourthBatchLimit=" + fourthBatchLimit +
                ", fourthBatchDone=" + fourthBatchDone +
                ", fifthBatchLimit=" + fifthBatchLimit +
                ", fifthBatchDone=" + fifthBatchDone +
                ", sixthBatchLimit=" + sixthBatchLimit +
                ", sixthBatchDone=" + sixthBatchDone +
                ", seventhBatchLimit=" + seventhBatchLimit +
                ", seventhBatchDone=" + seventhBatchDone +
                ", eighthBatchLimit=" + eighthBatchLimit +
                ", eighthBatchDone=" + eighthBatchDone +
                ", ninthBatchLimit=" + ninthBatchLimit +
                ", ninthBatchDone=" + ninthBatchDone +
                ", tenthBatchLimit=" + tenthBatchLimit +
                ", tenthBatchDone=" + tenthBatchDone +
                ", date=" + date +
                '}';
    }

}
