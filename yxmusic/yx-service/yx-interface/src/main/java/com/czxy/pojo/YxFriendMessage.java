package com.czxy.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "yxFriendMessAge")
public class YxFriendMessage {

    @Id
    private Integer mid;
    @Column(name = "requestId")
    private Integer requestId;
    @Column(name = "acceptId")
    private Integer acceptId;
    @Column(name = "messageContent")
    private String messageContent;
    @Column(name = "messageStatus")
    private Integer messageStatus;
    @Column(name = "messageType")
    private Integer messageType;
    @Column(name = "sendTime")
    private String sendTime;

    private Musicbase musicbase = new Musicbase();

    public YxFriendMessage(Integer requestId, Integer acceptId, String messageContent, Integer messageStatus, Integer messageType, String sendTime) {
        this.requestId = requestId;
        this.acceptId = acceptId;
        this.messageContent = messageContent;
        this.messageStatus = messageStatus;
        this.messageType = messageType;
        this.sendTime = sendTime;
    }

    public YxFriendMessage() {
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getAcceptId() {
        return acceptId;
    }

    public void setAcceptId(Integer acceptId) {
        this.acceptId = acceptId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Integer getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(Integer messageStatus) {
        this.messageStatus = messageStatus;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public Musicbase getMusicbase() {
        return musicbase;
    }

    public void setMusicbase(Musicbase musicbase) {
        this.musicbase = musicbase;
    }

    @Override
    public String toString() {
        return "YxFriendMessage{" +
                "mid=" + mid +
                ", requestId=" + requestId +
                ", acceptId=" + acceptId +
                ", messageContent='" + messageContent + '\'' +
                ", messageStatus=" + messageStatus +
                ", messageType=" + messageType +
                ", sendTime='" + sendTime + '\'' +
                '}';
    }
}
