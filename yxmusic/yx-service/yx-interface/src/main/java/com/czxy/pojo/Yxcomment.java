package com.czxy.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 歌曲评论表
 */

@Table(name = "yxcomment")
public class Yxcomment {
    @Id
    private Integer cid;
    private Integer uid;
    private Integer mid;
    private Integer cnum;
    private Integer isparent;
    private Date recoverytime;
    private String content;

    private User user = new User();

    public Yxcomment(Integer uid, Integer cnum, Integer isparent, Date recoverytime) {
        this.uid = uid;
        this.cnum = cnum;
        this.isparent = isparent;
        this.recoverytime = recoverytime;
    }

    public Yxcomment() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public Integer getCnum() {
        return cnum;
    }

    public void setCnum(Integer cnum) {
        this.cnum = cnum;
    }

    public Date getRecoverytime() {
        return recoverytime;
    }

    public void setRecoverytime(Date recoverytime) {
        this.recoverytime = recoverytime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsparent() {
        return isparent;
    }

    public void setIsparent(Integer isparent) {
        this.isparent = isparent;
    }

    @Override
    public String toString() {
        return "Yxcomment{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", mid=" + mid +
                ", cnum=" + cnum +
                ", isparent=" + isparent +
                ", recoverytime=" + recoverytime +
                ", content='" + content + '\'' +
                '}';
    }
}
