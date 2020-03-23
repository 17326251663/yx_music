package com.czxy.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "yxFriend")
public class YxFriend {
    @Id
    private Integer fid;
    private Integer uid1;
    private Integer uid2;
    @Column(name = "createTime")
    private String createTime;
    @Column(name = "messageNum")
    private Integer messageNum;

    private User user = new User();

    public YxFriend(Integer uid1, Integer uid2) {
        this.uid1 = uid1;
        this.uid2 = uid2;
    }

    public YxFriend() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getUid1() {
        return uid1;
    }

    public void setUid1(Integer uid1) {
        this.uid1 = uid1;
    }

    public Integer getUid2() {
        return uid2;
    }

    public void setUid2(Integer uid2) {
        this.uid2 = uid2;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(Integer messageNum) {
        this.messageNum = messageNum;
    }

    @Override
    public String toString() {
        return "YxFriend{" +
                "fid=" + fid +
                ", uid1=" + uid1 +
                ", uid2=" + uid2 +
                ", createTime='" + createTime + '\'' +
                ", messageNum=" + messageNum +
                '}';
    }
}
