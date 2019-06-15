package com.hasan.reservationsystem.Model;

import java.util.Date;

public class Payment {
    private int patientID;
    private double balance ;
    private Date lastpaydate;
    private Date lastpaymnetdate;

    public Payment(int patientID, double balance, Date lastpaydate, Date lastpaymnetdate) {
        this.patientID = patientID;
        this.balance = balance;
        this.lastpaydate = lastpaydate;
        this.lastpaymnetdate = lastpaymnetdate;
    }

    public Payment() {
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getLastpaydate() {
        return lastpaydate;
    }

    public void setLastpaydate(Date lastpaydate) {
        this.lastpaydate = lastpaydate;
    }

    public Date getLastpaymnetdate() {
        return lastpaymnetdate;
    }

    public void setLastpaymnetdate(Date lastpaymnetdate) {
        this.lastpaymnetdate = lastpaymnetdate;
    }
}
