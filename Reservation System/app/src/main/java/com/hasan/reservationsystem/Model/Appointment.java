package com.hasan.reservationsystem.Model;

import java.sql.Date;
import java.sql.Time;

public class Appointment {
    private int empID;
    private int clinicID;
    private int patientID;
    private String slottime;
    private String adate;
    private int rempID;
    private String appID ;

    public Appointment(int empID, int clinicID, int patientID, String slottime, String adate, int rempID,String appID) {
        this.empID = empID;
        this.clinicID = clinicID;
        this.patientID = patientID;
        this.slottime = slottime;
        this.adate = adate;
        this.appID =appID;
        this.rempID = rempID;
    }

    public Appointment() {
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public int getClinicID() {
        return clinicID;
    }

    public void setClinicID(int clinicID) {
        this.clinicID = clinicID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getSlottime() {
        return slottime;
    }

    public void setSlottime(String slottime) {
        this.slottime = slottime;
    }

    public String getAdate() {
        return adate;
    }

    public void setAdate(String adate) {
        this.adate = adate;
    }

    public int getRempID() {
        return rempID;
    }

    public void setRempID(int rempID) {
        this.rempID = rempID;
    }
    public void setAppID(String appID){this.appID=appID;}
    public String getAppID(){return appID;}
}
