package com.czxy.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "usermsg")
public class UserMsg {
    @Id
    private Integer uid;
    private Long concernnum;
    private Long fansnum;

    public UserMsg(Integer uid, Long concernnum, Long fansnum) {
        this.uid = uid;
        this.concernnum = concernnum;
        this.fansnum = fansnum;
    }

    public UserMsg() {
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Long getConcernnum() {
        return concernnum;
    }

    public void setConcernnum(Long concernnum) {
        this.concernnum = concernnum;
    }

    public Long getFansnum() {
        return fansnum;
    }

    public void setFansnum(Long fansnum) {
        this.fansnum = fansnum;
    }

    @Override
    public String toString() {
        return "UserMsg{" +
                "uid=" + uid +
                ", concernnum=" + concernnum +
                ", fansnum=" + fansnum +
                '}';
    }
}
