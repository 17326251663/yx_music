package com.czxy.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "userchat")
public class UserChat {
    @Id
    private Integer chatid;
    private Integer uid;
    private String sendtime;
    private String sendcontent;
    private Integer type;
    private Integer ismycontent;

    private User user = new User();
    private Musicbase musicbase = new Musicbase();

    public UserChat(Integer uid, String sendtime, String sendcontent, Integer type) {
        this.uid = uid;
        this.sendtime = sendtime;
        this.sendcontent = sendcontent;
        this.type = type;
    }



    public UserChat() {
    }

    public Integer getChatid() {
        return chatid;
    }

    public void setChatid(Integer chatid) {
        this.chatid = chatid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public String getSendcontent() {
        return sendcontent;
    }

    public void setSendcontent(String sendcontent) {
        this.sendcontent = sendcontent;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsmycontent() {
        return ismycontent;
    }

    public void setIsmycontent(Integer ismycontent) {
        this.ismycontent = ismycontent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Musicbase getMusicbase() {
        return musicbase;
    }

    public void setMusicbase(Musicbase musicbase) {
        this.musicbase = musicbase;
    }

    @Override
    public String toString() {
        return "UserChat{" +
                "chatid=" + chatid +
                ", uid=" + uid +
                ", sendtime='" + sendtime + '\'' +
                ", sendcontent='" + sendcontent + '\'' +
                ", type=" + type +
                '}';
    }
}
