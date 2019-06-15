package com.hasan.reservationsystem.Model;

import java.sql.Date;
import java.sql.Time;

public class Appointment {
    private int empID;
    private int clinicID;
    private int patientID;
    private Time slottime;
    private Date adate;
    private int rempID;

    public Appointment(int empID, int clinicID, int patientID, Time slottime, Date adate, int rempID) {
        this.empID = empID;
        this.clinicID = clinicID;
        this.patientID = patientID;
        this.slottime = slottime;
        this.adate = adate;
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

    public Time getSlottime() {
        return slottime;
    }

    public void setSlottime(Time slottime) {
        this.slottime = slottime;
    }

    public Date getAdate() {
        return adate;
    }

    public void setAdate(Date adate) {
        this.adate = adate;
    }

    public int getRempID() {
        return rempID;
    }

    public void setRempID(int rempID) {
        this.rempID = rempID;
    }
}
