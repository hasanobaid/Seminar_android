package com.hasan.reservationsystem.Model;

public class Clinic_doctor {
    private  int clinicID;
    private  int empID ;

    public Clinic_doctor(int clinicID, int empID) {
        this.clinicID = clinicID;
        this.empID = empID;
    }

    public Clinic_doctor() {
    }

    public int getClinicID() {
        return clinicID;
    }

    public void setClinicID(int clinicID) {
        this.clinicID = clinicID;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }
}
