package com.example.qualifandroidjm22_1;

public class UserData {
    int id;
    String uname, mail, phone, pass;

    public UserData() {

    }

    public UserData(int id, String uname, String mail, String phone, String pass) {
        this.id = id;
        this.uname = uname;
        this.mail = mail;
        this.phone = phone;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
