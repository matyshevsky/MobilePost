package com.example.model;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by Karol on 24.12.2016.
 */
@Entity(name = "delivery")
@SequenceGenerator(initialValue = 1, name = "idGen", sequenceName = "deliveryId")
@Table(name = "delivery")
public class mDelivery extends mBaseObject {

    @NotNull
    private String code;
    @NotNull
    private Long type;
    @NotNull
    private double weight;
    private double price;
    private Long fromOffice;


    private String senderName;
    private String senderSurname;
    private String senderZipCode;
    private String senderCity;
    private String senderStreet;
    private String senderApartment;
    private String senderPhone;

    @NotNull
    private String recipientName;
    @NotNull
    private String recipientSurname;
    @NotNull
    private String recipientZipCode;
    @NotNull
    private String recipientCity;
    @NotNull
    private String recipientStreet;
    @NotNull
    private String recipientApartment;
    @NotNull
    private String recipientPhone;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getFromOffice() {
        return fromOffice;
    }

    public void setFromOffice(Long fromOffice) {
        this.fromOffice = fromOffice;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderSurname() {
        return senderSurname;
    }

    public void setSenderSurname(String senderSurname) {
        this.senderSurname = senderSurname;
    }

    public String getSenderZipCode() {
        return senderZipCode;
    }

    public void setSenderZipCode(String senderZipCode) {
        this.senderZipCode = senderZipCode;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    public String getSenderStreet() {
        return senderStreet;
    }

    public void setSenderStreet(String senderStreet) {
        this.senderStreet = senderStreet;
    }

    public String getSenderApartment() {
        return senderApartment;
    }

    public void setSenderApartment(String senderApartment) {
        this.senderApartment = senderApartment;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientSurname() {
        return recipientSurname;
    }

    public void setRecipientSurname(String recipientSurname) {
        this.recipientSurname = recipientSurname;
    }

    public String getRecipientZipCode() {
        return recipientZipCode;
    }

    public void setRecipientZipCode(String recipientZipCode) {
        this.recipientZipCode = recipientZipCode;
    }

    public String getRecipientCity() {
        return recipientCity;
    }

    public void setRecipientCity(String recipientCity) {
        this.recipientCity = recipientCity;
    }

    public String getRecipientStreet() {
        return recipientStreet;
    }

    public void setRecipientStreet(String recipientStreet) {
        this.recipientStreet = recipientStreet;
    }

    public String getRecipientApartment() {
        return recipientApartment;
    }

    public void setRecipientApartment(String recipientApartment) {
        this.recipientApartment = recipientApartment;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }
}
