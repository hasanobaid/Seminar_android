package com.hasan.reservationsystem.Model;

import java.util.Date;

public class Patient {
    private String firstname;
    private String secondname;
    private String thirdname;
    private String lastname;
    private int patientID;
    private int cityID;
    private int qID;
    private String phonenumber;
    private String mobilenumber;
    private String email;
    private String password;
    private String gender;
    private String address;
    private Date dateofbirth;
    private int insuranceID;
    private int subinsuranceID;
    private double balance;
    private String relation;
    private int insurancenum;

    public Patient(String firstname, String secondname, String thirdname,
                   String lastname, int patientID, int cityID, int qID, String phonenumber,
                   String mobilenumber, String email, String password, String gender, String address,
                   Date dateofbirth,
                   int insuranceID, int subinsuranceID, double balance, String relation, int insurancenum) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.thirdname = thirdname;
        this.lastname = lastname;
        this.patientID = patientID;
        this.cityID = cityID;
        this.qID = qID;
        this.phonenumber = phonenumber;
        this.mobilenumber = mobilenumber;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.dateofbirth = dateofbirth;
        this.insuranceID = insuranceID;
        this.subinsuranceID = subinsuranceID;
        this.balance = balance;
        this.relation = relation;
        this.insurancenum = insurancenum;
    }

    public Patient() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getThirdname() {
        return thirdname;
    }

    public void setThirdname(String thirdname) {
        this.thirdname = thirdname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public int getqID() {
        return qID;
    }

    public void setqID(int qID) {
        this.qID = qID;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public int getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(int insuranceID) {
        this.insuranceID = insuranceID;
    }

    public int getSubinsuranceID() {
        return subinsuranceID;
    }

    public void setSubinsuranceID(int subinsuranceID) {
        this.subinsuranceID = subinsuranceID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public int getInsurancenum() {
        return insurancenum;
    }

    public void setInsurancenum(int insurancenum) {
        this.insurancenum = insurancenum;
    }
}
