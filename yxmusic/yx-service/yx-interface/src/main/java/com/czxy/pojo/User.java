package com.czxy.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户表
 */
@Table(name = "user")
public class User {

    private String loginid;
    private String loginname;
    private String loginpassword;
    private String gender;
    private Integer age;
    private String telephonenumber;
    private String email;
    private String intro;
    private String timg="https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3615831237,1510664097&fm=26&gp=0.jpg";
    private String vip;
    private Date overduetime;
    private Integer statuscode;
    @Id
    private Integer uid;

    UserMsg usermsg = new UserMsg();

    public User(String loginid, String loginpassword) {
        this.loginid = loginid;
        this.loginpassword = loginpassword;
    }

    public User() {
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getLoginpassword() {
        return loginpassword;
    }

    public void setLoginpassword(String loginpassword) {
        this.loginpassword = loginpassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephonenumber() {
        return telephonenumber;
    }

    public void setTelephonenumber(String telephonenumber) {
        this.telephonenumber = telephonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getTimg() {
        return timg;
    }

    public void setTimg(String timg) {
        this.timg = timg;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public Date getOverduetime() {
        return overduetime;
    }

    public void setOverduetime(Date overduetime) {
        this.overduetime = overduetime;
    }

    public Integer getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(Integer statuscode) {
        this.statuscode = statuscode;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public UserMsg getUsermsg() {
        return usermsg;
    }

    public void setUsermsg(UserMsg usermsg) {
        this.usermsg = usermsg;
    }

    @Override
    public String toString() {
        return "User{" +
                "loginid=" + loginid +
                ", loginname='" + loginname + '\'' +
                ", loginpassword='" + loginpassword + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", telephonenumber='" + telephonenumber + '\'' +
                ", email='" + email + '\'' +
                ", intro='" + intro + '\'' +
                ", timg='" + timg + '\'' +
                ", vip='" + vip + '\'' +
                ", overduetime=" + overduetime +
                ", statuscode=" + statuscode +
                ", uid=" + uid +
                '}';
    }
}
