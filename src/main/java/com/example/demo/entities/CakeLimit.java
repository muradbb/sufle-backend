package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;

@Entity
@Table(name = "cake_limits")
public class CakeLimit {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private double firstBatchLimit;
    @Column
    private double firstBatchDone;
    @Column
    private double secBatchLimit;
    @Column
    private double secBatchDone;
    @Column
    private double thirdBatchLimit;
    @Column
    private double thirdBatchDone;
    @Column
    private double fourthBatchLimit;
    @Column
    private double fourthBatchDone;
    @Column
    private double fifthBatchLimit;
    @Column
    private double fifthBatchDone;
    @Column
    private double sixthBatchLimit;
    @Column
    private double sixthBatchDone;
    @Column
    private double seventhBatchLimit;
    @Column
    private double seventhBatchDone;
    @Column
    private double eighthBatchLimit;
    @Column
    private double eighthBatchDone;
    @Column
    private double ninthBatchLimit;
    @Column
    private double ninthBatchDone;
    @Column
    private double tenthBatchLimit;
    @Column
    private double tenthBatchDone;
    @Column
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    @Column
    private String type;

    @Transient
    private boolean[] availability =new boolean[10];

    public CakeLimit(){
//        firstBatchLimit=0;
//        secBatchLimit=0;
//        thirdBatchLimit=0;
//        fourthBatchLimit=0;
//        fifthBatchLimit=0;
//        sixthBatchLimit=0;
//        seventhBatchLimit=0;
//        eighthBatchLimit=0;
//        ninthBatchLimit=0;
//        tenthBatchLimit=0;
    }

    public long getId() {
        return id;
    }

    public CakeLimit setId(long id) {
        this.id = id;
        return this;
    }

    public double getFirstBatchLimit() {
        return firstBatchLimit;
    }

    public CakeLimit setFirstBatchLimit(double firstBatchLimit) {
        this.firstBatchLimit = firstBatchLimit;
        return this;
    }

    public double getFirstBatchDone() {
        return firstBatchDone;
    }

    public CakeLimit setFirstBatchDone(double firstBatchDone) {
        this.firstBatchDone = firstBatchDone;
        return this;
    }

    public double getSecBatchLimit() {
        return secBatchLimit;
    }

    public CakeLimit setSecBatchLimit(double secBatchLimit) {
        this.secBatchLimit = secBatchLimit;
        return this;
    }

    public double getSecBatchDone() {
        return secBatchDone;
    }

    public CakeLimit setSecBatchDone(double secBatchDone) {
        this.secBatchDone = secBatchDone;
        return this;
    }

    public double getThirdBatchLimit() {
        return thirdBatchLimit;
    }

    public CakeLimit setThirdBatchLimit(double thirdBatchLimit) {
        this.thirdBatchLimit = thirdBatchLimit;
        return this;
    }

    public double getThirdBatchDone() {
        return thirdBatchDone;
    }

    public CakeLimit setThirdBatchDone(double thirdBatchDone) {
        this.thirdBatchDone = thirdBatchDone;
        return this;
    }

    public double getFourthBatchLimit() {
        return fourthBatchLimit;
    }

    public CakeLimit setFourthBatchLimit(double fourthBatchLimit) {
        this.fourthBatchLimit = fourthBatchLimit;
        return this;
    }

    public double getFourthBatchDone() {
        return fourthBatchDone;
    }

    public CakeLimit setFourthBatchDone(double fourthBatchDone) {
        this.fourthBatchDone = fourthBatchDone;
        return this;
    }

    public double getFifthBatchLimit() {
        return fifthBatchLimit;
    }

    public CakeLimit setFifthBatchLimit(double fifthBatchLimit) {
        this.fifthBatchLimit = fifthBatchLimit;
        return this;
    }

    public double getFifthBatchDone() {
        return fifthBatchDone;
    }

    public CakeLimit setFifthBatchDone(double fifthBatchDone) {
        this.fifthBatchDone = fifthBatchDone;
        return this;
    }

    public double getSixthBatchLimit() {
        return sixthBatchLimit;
    }

    public CakeLimit setSixthBatchLimit(double sixthBatchLimit) {
        this.sixthBatchLimit = sixthBatchLimit;
        return this;
    }

    public double getSixthBatchDone() {
        return sixthBatchDone;
    }

    public CakeLimit setSixthBatchDone(double sixthBatchDone) {
        this.sixthBatchDone = sixthBatchDone;
        return this;
    }

    public double getSeventhBatchLimit() {
        return seventhBatchLimit;
    }

    public CakeLimit setSeventhBatchLimit(double seventhBatchLimit) {
        this.seventhBatchLimit = seventhBatchLimit;
        return this;
    }

    public double getSeventhBatchDone() {
        return seventhBatchDone;
    }

    public CakeLimit setSeventhBatchDone(double seventhBatchDone) {
        this.seventhBatchDone = seventhBatchDone;
        return this;
    }

    public double getEighthBatchLimit() {
        return eighthBatchLimit;
    }

    public CakeLimit setEighthBatchLimit(double eighthBatchLimit) {
        this.eighthBatchLimit = eighthBatchLimit;
        return this;
    }

    public double getEighthBatchDone() {
        return eighthBatchDone;
    }

    public CakeLimit setEighthBatchDone(double eighthBatchDone) {
        this.eighthBatchDone = eighthBatchDone;
        return this;
    }

    public double getNinthBatchLimit() {
        return ninthBatchLimit;
    }

    public CakeLimit setNinthBatchLimit(double ninthBatchLimit) {
        this.ninthBatchLimit = ninthBatchLimit;
        return this;
    }

    public double getNinthBatchDone() {
        return ninthBatchDone;
    }

    public CakeLimit setNinthBatchDone(double ninthBatchDone) {
        this.ninthBatchDone = ninthBatchDone;
        return this;
    }

    public double getTenthBatchLimit() {
        return tenthBatchLimit;
    }

    public CakeLimit setTenthBatchLimit(double tenthBatchLimit) {
        this.tenthBatchLimit = tenthBatchLimit;
        return this;
    }

    public double getTenthBatchDone() {
        return tenthBatchDone;
    }

    public CakeLimit setTenthBatchDone(double tenthBatchDone) {
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
                ", type='" + type + '\'' +
                ", availability=" + Arrays.toString(availability) +
                '}';
    }
}
