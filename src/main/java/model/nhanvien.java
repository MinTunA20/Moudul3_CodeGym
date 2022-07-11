package model;

import java.util.Date;

public class nhanvien {
    private int idNhanvien;
    private String nameNhanvien;
    private Date doB;
    private String address;
    private String phoneNumber;
    private String email;
    private String phongban;

    public String getNameNhanvien() {
        return nameNhanvien;
    }

    public nhanvien() {
    }

    public nhanvien(int idNhanvien, String nameNhanvien, Date doB, String address, String phoneNumber, String email, String phongban) {
        this.idNhanvien = idNhanvien;
        this.nameNhanvien = nameNhanvien;
        this.doB = doB;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.phongban = phongban;
    }

    public int getIdNhanvien() {
        return idNhanvien;
    }

    public void setIdNhanvien(int idNhanvien) {
        this.idNhanvien = idNhanvien;
    }

    public void setNameNhanvien(String nameNhanvien) {
        this.nameNhanvien = nameNhanvien;
    }

    public Date getDoB() {
        return doB;
    }

    public void setDoB(Date doB) {
        this.doB = doB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhongban() {
        return phongban;
    }

    public void setPhongban(String phongban) {
        this.phongban = phongban;
    }
}
