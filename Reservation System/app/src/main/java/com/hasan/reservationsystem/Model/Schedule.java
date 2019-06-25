package com.hasan.reservationsystem.Model;

import java.sql.Time;
import java.util.Date;

public class Schedule {
    private int scID;
    private int emopID;
    private int clinicID;
    private String starttime;
    private String endtime;
    private String startdate;
    private String enddate ;
    private int slot;
    private int sat;
    private int sun;
    private int mon;
    private int tue;
    private int wen;
    private int thu;
    private int fri ;

    public Schedule(int scID, int emopID, int clinicID, String starttime, String endtime, String startdate, String enddate,
                    int slottime, int sat, int sun, int mon, int tue, int wen, int thu, int fri) {
        this.scID = scID;
        this.emopID = emopID;
        this.clinicID = clinicID;
        this.starttime = starttime;
        this.endtime = endtime;
        this.startdate = startdate;
        this.enddate = enddate;
        this.slot = slot;
        this.sat = sat;
        this.sun = sun;
        this.mon = mon;
        this.tue = tue;
        this.wen = wen;
        this.thu = thu;
        this.fri = fri;
    }

    public Schedule() {
    }

    public int getScID() {
        return scID;
    }

    public void setScID(int scID) {
        this.scID = scID;
    }

    public int getEmopID() {
        return emopID;
    }

    public void setEmopID(int emopID) {
        this.emopID = emopID;
    }

    public int getClinicID() {
        return clinicID;
    }

    public void setClinicID(int clinicID) {
        this.clinicID = clinicID;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public int getSlottime() {
        return slot;
    }

    public void setSlottime(int slot) {
        this.slot = slot;
    }

    public int getSat() {
        return sat;
    }

    public void setSat(int sat) {
        this.sat = sat;
    }

    public int getSun() {
        return sun;
    }

    public void setSun(int sun) {
        this.sun = sun;
    }

    public int getMon() {
        return mon;
    }

    public void setMon(int mon) {
        this.mon = mon;
    }

    public int getTue() {
        return tue;
    }

    public void setTue(int tue) {
        this.tue = tue;
    }

    public int getWen() {
        return wen;
    }

    public void setWen(int wen) {
        this.wen = wen;
    }

    public int getThu() {
        return thu;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }

    public int getFri() {
        return fri;
    }

    public void setFri(int fri) {
        this.fri = fri;
    }
}
