package com.czxy.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "yxFriendRequest")
public class YxFriendRequest {
    @Id
    private Integer rid;
    @Column(name = "requestId")
    private Integer requestId;
    @Column(name = "acceptId")
    private Integer acceptId;
    @Column(name = "friendRequest")
    private String friendRequest;
    @Column(name = "requestStatus")
    private Integer requestStatus;
    @Column(name = "requestTime")
    private String requestTime;

    private User user = new User();

    public YxFriendRequest(Integer requestId, Integer acceptId, String friendRequest, Integer requestStatus) {
        this.requestId = requestId;
        this.acceptId = acceptId;

        if (friendRequest.length()>50){
            this.friendRequest = friendRequest.substring(0,50);
        }else {
            this.friendRequest = friendRequest;
        }

        this.requestStatus = requestStatus;
    }

    public YxFriendRequest() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
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

    public Integer getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(Integer requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getFriendRequest() {
        return friendRequest;
    }

    public void setFriendRequest(String friendRequest) {
        this.friendRequest = friendRequest;
    }

    @Override
    public String toString() {
        return "YxFriendRequest{" +
                "rid=" + rid +
                ", requestId=" + requestId +
                ", acceptId=" + acceptId +
                ", friendRequest='" + friendRequest + '\'' +
                ", requestStatus=" + requestStatus +
                ", requestTime='" + requestTime + '\'' +
                '}';
    }
}
