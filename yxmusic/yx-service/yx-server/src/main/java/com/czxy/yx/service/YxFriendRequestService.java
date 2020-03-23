package com.czxy.yx.service;

import com.czxy.pojo.YxFriend;
import com.czxy.pojo.YxFriendMessage;
import com.czxy.pojo.YxFriendRequest;

import java.util.List;

public interface YxFriendRequestService {
    void sendRequest(YxFriendRequest yxFriendRequest);

    boolean isFriend(Integer uid, Integer acceptId);

    boolean isSend(Integer uid, Integer acceptId);

    List<YxFriendRequest> getRequest(Integer acceptId);

    Integer lookRequest(Integer uid);

    void setRequest(Integer num,Integer requestId,Integer acceptId);

    List<YxFriend> getFriends(Integer uid);

    Integer friendMessageNum(Integer uid);

    void setMessageStatus(Integer requestId, Integer uid);

    List<YxFriendMessage> getFriendMessage(Integer requestId, Integer acceptId);

    void sendFriendResource(YxFriendMessage yxFriendMessage);
}
