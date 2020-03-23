package com.czxy.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "userconcern")
public class UserConcern {
    @Id
    private Integer gid;
    private Integer concernid;
    private Integer fansid;
    private Date concerntime;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getConcernid() {
        return concernid;
    }

    public void setConcernid(Integer concernid) {
        this.concernid = concernid;
    }

    public Integer getFansid() {
        return fansid;
    }

    public void setFansid(Integer fansid) {
        this.fansid = fansid;
    }

    public Date getConcerntime() {
        return concerntime;
    }

    public void setConcerntime(Date concerntime) {
        this.concerntime = concerntime;
    }

    @Override
    public String toString() {
        return "UserConcern{" +
                "gid=" + gid +
                ", concernid=" + concernid +
                ", fansid=" + fansid +
                ", concerntime=" + concerntime +
                '}';
    }
}
