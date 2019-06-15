package com.hasan.reservationsystem.Model;

import java.util.Date;

public class Employee {
    private String firstname;
    private String secondname;
    private String thirdname;
    private String lastname;
    private int empID;
    private int cityID;
    private int qID;
    private String phonenumber;
    private String mobilenumber;
    private String emergencynumber;
    private String email;
    private String password;
    private String username;
    private int jobID;
    private int spID;
    private String gender;
    private String address;
    private Date dateofbirth;

    public Employee(String firstname, String secondname, String thirdname,
                    String lastname, int empID, int cityID, int qID, String phonenumber,
                    String mobilenumber, String emergencynumber, String email, String password,
                    String username, int jobID, int spID, String gender, String address, Date dateofbirth) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.thirdname = thirdname;
        this.lastname = lastname;
        this.empID = empID;
        this.cityID = cityID;
        this.qID = qID;
        this.phonenumber = phonenumber;
        this.mobilenumber = mobilenumber;
        this.emergencynumber = emergencynumber;
        this.email = email;
        this.password = password;
        this.username = username;
        this.jobID = jobID;
        this.spID = spID;
        this.gender = gender;
        this.address = address;
        this.dateofbirth = dateofbirth;
    }

    public Employee() {
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

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
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

    public String getEmergencynumber() {
        return emergencynumber;
    }

    public void setEmergencynumber(String emergencynumber) {
        this.emergencynumber = emergencynumber;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public int getSpID() {
        return spID;
    }

    public void setSpID(int spID) {
        this.spID = spID;
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
}
