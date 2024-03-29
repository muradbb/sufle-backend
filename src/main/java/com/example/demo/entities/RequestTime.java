package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "request_time")
public class RequestTime {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long idCakeLimit;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String orderCode;
    @Column
    private String phoneNumber;
    @Column
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate orderDate;
    @Column
    private LocalTime orderTime;
    @Column
    private String notes;
    @Column(nullable = false,columnDefinition = "TINYINT(1)")
    private boolean itsTime;
    @Column
    private double amount;
    @Column
    private String type;
    @Column(columnDefinition = "TINYINT(1)")
    private boolean archived;


    public RequestTime(){
        itsTime=false;
        archived=false;
    }

    public long getIdCakeLimit() {
        return idCakeLimit;
    }

    public RequestTime setIdCakeLimit(long idCakeLimit) {
        this.idCakeLimit = idCakeLimit;
        return this;
    }

    public long getId() {
        return id;
    }

    public RequestTime setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RequestTime setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RequestTime setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public RequestTime setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public RequestTime setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public RequestTime setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public RequestTime setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public boolean isItsTime() {
        return itsTime;
    }

    public RequestTime setItsTime(boolean itsTime) {
        this.itsTime = itsTime;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public RequestTime setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public String getType() {
        return type;
    }

    public RequestTime setType(String type) {
        this.type = type;
        return this;
    }

    public boolean isArchived() {
        return archived;
    }

    public RequestTime setArchived(boolean archived) {
        this.archived = archived;
        return this;
    }

    @Override
    public String toString() {
        return "RequestTime{" +
                "id=" + id +
                ", idCakeLimit=" + idCakeLimit +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", orderDate=" + orderDate +
                ", orderTime=" + orderTime +
                ", notes='" + notes + '\'' +
                ", itsTime=" + itsTime +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", archived=" + archived +
                '}';
    }

//    Sifarişçi adı
//    Sifarişçi soyadı
//    Sifarişçinin nömrəsi
//    Sifariş tarixi (Sifariş sayı dolubsa pop-up açılsın)
//    Sifariş saatı (Sifariş sayı dolubsa əlavə etmək olmasın)
//    Qeyd (məcburi deyil)
//    Vaxtı çatıb


}
