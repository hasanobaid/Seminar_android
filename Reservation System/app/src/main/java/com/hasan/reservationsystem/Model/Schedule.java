package com.hasan.reservationsystem.Model;

import java.sql.Time;
import java.util.Date;

public class Schedule {
    private int scID;
    private int emopID;
    private int clinicID;
    private Time starttime;
    private Time endtime;
    private Date startdate;
    private Date enddate ;
    private int slottime;
    private int sat;
    private int sun;
    private int mon;
    private int tue;
    private int wen;
    private int thu;
    private int fri ;

    public Schedule(int scID, int emopID, int clinicID, Time starttime, Time endtime, Date startdate, Date enddate,
                    int slottime, int sat, int sun, int mon, int tue, int wen, int thu, int fri) {
        this.scID = scID;
        this.emopID = emopID;
        this.clinicID = clinicID;
        this.starttime = starttime;
        this.endtime = endtime;
        this.startdate = startdate;
        this.enddate = enddate;
        this.slottime = slottime;
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

    public Time getStarttime() {
        return starttime;
    }

    public void setStarttime(Time starttime) {
        this.starttime = starttime;
    }

    public Time getEndtime() {
        return endtime;
    }

    public void setEndtime(Time endtime) {
        this.endtime = endtime;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public int getSlottime() {
        return slottime;
    }

    public void setSlottime(int slottime) {
        this.slottime = slottime;
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
