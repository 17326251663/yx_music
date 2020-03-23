package com.czxy.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 音乐收藏
 */
@Table(name = "yxmusiccollect")
public class YxMusicCollect {
    @Id
    private Integer cid;
    private Integer mid;
    private Integer uid;
    private Date collecttime;

    public YxMusicCollect(Integer mid, Integer uid, Date collecttime) {
        this.mid = mid;
        this.uid = uid;
        this.collecttime = collecttime;
    }

    public YxMusicCollect(Integer mid, Integer uid) {
        this.mid = mid;
        this.uid = uid;
    }

    public YxMusicCollect() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getCollecttime() {
        return collecttime;
    }

    public void setCollecttime(Date collecttime) {
        this.collecttime = collecttime;
    }

    @Override
    public String toString() {
        return "YxMusicCollect{" +
                "cid=" + cid +
                ", mid=" + mid +
                ", uid=" + uid +
                ", collecttime=" + collecttime +
                '}';
    }
}
