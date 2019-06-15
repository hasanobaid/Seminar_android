package com.hasan.reservationsystem.Model;

import java.util.Date;

public class Payment_Details {
    private int paymnetID;
    private int empID;
    private int patientID;
    private Date senddate;
    private double amount ;
    private String paymnettype;

    public Payment_Details(int paymnetID, int empID, int patientID, Date senddate, double amount, String paymnettype) {
        this.paymnetID = paymnetID;
        this.empID = empID;
        this.patientID = patientID;
        this.senddate = senddate;
        this.amount = amount;
        this.paymnettype = paymnettype;
    }

    public Payment_Details() {
    }

    public int getPaymnetID() {
        return paymnetID;
    }

    public void setPaymnetID(int paymnetID) {
        this.paymnetID = paymnetID;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymnettype() {
        return paymnettype;
    }

    public void setPaymnettype(String paymnettype) {
        this.paymnettype = paymnettype;
    }
}
