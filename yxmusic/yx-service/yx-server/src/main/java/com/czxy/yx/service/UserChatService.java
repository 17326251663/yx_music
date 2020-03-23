package com.czxy.yx.service;

import com.czxy.pojo.UserChat;

import java.util.List;

public interface UserChatService {
    int getCount();

    List<UserChat> getContent(int start, int end,int uid);

    void insert(UserChat userChat);
}
