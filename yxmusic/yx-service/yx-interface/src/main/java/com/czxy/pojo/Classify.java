package com.czxy.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * 音乐分类
 */
@Table(name = "classify")
public class Classify {
    @Id
    private Integer ifyid;
    private String ifyname;

    private List<Yxmv> yxmv = new ArrayList<>();

    public List<Yxmv> getYxmv() {
        return yxmv;
    }

    public void setYxmv(List<Yxmv> yxmv) {
        this.yxmv = yxmv;
    }

    public Integer getIfyid() {
        return ifyid;
    }

    public void setIfyid(Integer ifyid) {
        this.ifyid = ifyid;
    }

    public String getIfyname() {
        return ifyname;
    }

    public void setIfyname(String ifyname) {
        this.ifyname = ifyname;
    }

    @Override
    public String toString() {
        return "Classify{" +
                "ifyid=" + ifyid +
                ", ifyname='" + ifyname + '\'' +
                '}';
    }
}
