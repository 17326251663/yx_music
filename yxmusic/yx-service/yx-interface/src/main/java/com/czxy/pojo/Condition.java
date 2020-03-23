package com.czxy.pojo;

/**
 * 查询条件表
 */
public class Condition {

    private Integer ifyid;
    private String musicname;
    private boolean order;
    private Integer num;

    public Condition(Integer ifyid, String musicname, boolean order, Integer num) {
        this.ifyid = ifyid;
        this.musicname = musicname;
        this.order = order;
        this.num = num;
    }

    public Condition() {
    }

    public Integer getIfyid() {
        return ifyid;
    }

    public void setIfyid(Integer ifyid) {
        this.ifyid = ifyid;
    }

    public String getMusicname() {
        return musicname;
    }

    public void setMusicname(String musicname) {
        this.musicname = musicname;
    }

    public boolean isOrder() {
        return order;
    }

    public void setOrder(boolean order) {
        this.order = order;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "ifyid=" + ifyid +
                ", musicname='" + musicname + '\'' +
                ", order=" + order +
                ", num=" + num +
                '}';
    }
}
