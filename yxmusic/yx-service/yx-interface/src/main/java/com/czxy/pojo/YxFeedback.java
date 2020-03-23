package com.czxy.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "yxfeedback")
public class YxFeedback {
    @Id
    private Integer fid;
    private Integer uid;
    private String uname;
    private String messagename;
    private Date datetime;
    private String textarea;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getMessagename() {
        return messagename;
    }

    public void setMessagename(String messagename) {
        this.messagename = messagename;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getTextarea() {
        return textarea;
    }

    public void setTextarea(String textarea) {
        this.textarea = textarea;
    }

    @Override
    public String toString() {
        return "YxFeedback{" +
                "fid=" + fid +
                ", uid=" + uid +
                ", uname='" + uname + '\'' +
                ", messagename='" + messagename + '\'' +
                ", datetime=" + datetime +
                ", textarea='" + textarea + '\'' +
                '}';
    }
}
