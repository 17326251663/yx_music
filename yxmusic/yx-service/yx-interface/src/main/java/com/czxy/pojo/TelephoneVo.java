package com.czxy.pojo;

import java.util.Date;
import java.util.Objects;

public class TelephoneVo {

    private String telephone;
    private String securityCode;
    private Date createtime;
    private Boolean statusCode;

    public TelephoneVo(String telephone, String securityCode, Date createtime) {
        this.telephone = telephone;
        this.securityCode = securityCode;
        this.createtime = createtime;
    }

    public TelephoneVo(String telephone, String securityCode) {
        this.telephone = telephone;
        this.securityCode = securityCode;
    }

    public TelephoneVo() {
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Boolean getStatusCode() {

        long nowtime = new Date().getTime();
        long createtime = this.createtime.getTime();

        long difference = (nowtime - createtime)/1000L/60;

        if (difference>=5){
         return false;
        }

        return true;
    }

    public void setStatusCode(Boolean statusCode) {
        this.statusCode = statusCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public String toString() {
        return "TelephoneVo{" +
                "telephone='" + telephone + '\'' +
                ", securityCode='" + securityCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelephoneVo that = (TelephoneVo) o;
        return Objects.equals(telephone, that.telephone) &&
                Objects.equals(securityCode, that.securityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telephone, securityCode);
    }
}
