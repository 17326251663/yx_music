package com.czxy.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "yxmv")
public class Yxmv {
    @Id
    private Integer mid;
    private String mname;
    private String mtitle;
    private String murl;
    private Float msize;
    private Integer mnum;
    private Integer mbnum;
    private Integer ifyid;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getMurl() {
        return murl;
    }

    public void setMurl(String murl) {
        this.murl = murl;
    }

    public Float getMsize() {
        return msize;
    }

    public void setMsize(Float msize) {
        this.msize = msize;
    }

    public Integer getMnum() {
        return mnum;
    }

    public void setMnum(Integer mnum) {
        this.mnum = mnum;
    }

    public Integer getMbnum() {
        return mbnum;
    }

    public void setMbnum(Integer mbnum) {
        this.mbnum = mbnum;
    }

    public Integer getIfyid() {
        return ifyid;
    }

    public void setIfyid(Integer ifyid) {
        this.ifyid = ifyid;
    }

    @Override
    public String toString() {
        return "Yxmv{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                ", mtitle='" + mtitle + '\'' +
                ", murl='" + murl + '\'' +
                ", msize=" + msize +
                ", mnum=" + mnum +
                ", mbnum=" + mbnum +
                ", ifyid=" + ifyid +
                '}';
    }
}
