package com.czxy.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 音乐资源表
 */

@Table(name = "musicbase")
public class Musicbase {
    @Id
    private Integer mid;
    private String musicname;
    private String musicurl;
    private Float msize;
    private String singer;
    private Integer uid;
    private String uname;
    private String imgurl;
    private Integer lyrics;
    private Date uploadtime;
    private Integer uploadnum;
    private Integer playnum;
    private Integer ifyid;
    private Integer status;
    private User user = new User();
    private Classify classify = new Classify();

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Classify getClassify() {
        return classify;
    }

    public void setClassify(Classify classify) {
        this.classify = classify;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getMid() {
        return mid;
    }

    public Integer getPlaynum() {
        return playnum;
    }

    public void setPlaynum(Integer playnum) {
        this.playnum = playnum;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMusicname() {
        return musicname;
    }

    public void setMusicname(String musicname) {
        this.musicname = musicname;
    }

    public String getMusicurl() {
        return musicurl;
    }

    public void setMusicurl(String musicurl) {
        this.musicurl = musicurl;
    }

    public Float getMsize() {
        return msize;
    }

    public void setMsize(Float msize) {
        this.msize = msize;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
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

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Integer getLyrics() {
        return lyrics;
    }

    public void setLyrics(Integer lyrics) {
        this.lyrics = lyrics;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public Integer getUploadnum() {
        return uploadnum;
    }

    public void setUploadnum(Integer uploadnum) {
        this.uploadnum = uploadnum;
    }

    public Integer getIfyid() {
        return ifyid;
    }

    public void setIfyid(Integer ifyid) {
        this.ifyid = ifyid;
    }

    @Override
    public String toString() {
        return "Musicbase{" +
                "mid=" + mid +
                ", musicname='" + musicname + '\'' +
                ", musicurl='" + musicurl + '\'' +
                ", msize=" + msize +
                ", singer='" + singer + '\'' +
                ", uid=" + uid +
                ", uname='" + uname + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", lyrics=" + lyrics +
                ", uploadtime=" + uploadtime +
                ", uploadnum=" + uploadnum +
                ", playnum=" + playnum +
                ", ifyid=" + ifyid +
                '}';
    }
}
