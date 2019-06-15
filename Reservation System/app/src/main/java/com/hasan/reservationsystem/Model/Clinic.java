package com.hasan.reservationsystem.Model;

public class Clinic {
    private  int clinicID;
    private String clinicname;

    public Clinic(int clinicID, String clinicname) {
        this.clinicID = clinicID;
        this.clinicname = clinicname;
    }

    public Clinic() {
    }

    public int getClinicID() {
        return clinicID;
    }

    public void setClinicID(int clinicID) {
        this.clinicID = clinicID;
    }

    public String getClinicname() {
        return clinicname;
    }

    public void setClinicname(String clinicname) {
        this.clinicname = clinicname;
    }
}
