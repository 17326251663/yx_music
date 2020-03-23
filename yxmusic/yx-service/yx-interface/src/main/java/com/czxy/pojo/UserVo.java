package com.czxy.pojo;


public class UserVo {

    private UserMsg usermsg;
    private User user;

    public UserVo(UserMsg usermsg, User user) {
        this.usermsg = usermsg;
        this.user = user;
    }

    public UserVo() {
    }

    public UserMsg getUsermsg() {
        return usermsg;
    }

    public void setUsermsg(UserMsg usermsg) {
        this.usermsg = usermsg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "usermsg=" + usermsg +
                ", user=" + user +
                '}';
    }
}
