package com.czxy.yx.service.impl;

import com.czxy.pojo.YxFriend;
import com.czxy.pojo.YxFriendMessage;
import com.czxy.pojo.YxFriendRequest;
import com.czxy.yx.mapper.YxFriendMapper;
import com.czxy.yx.mapper.YxFriendMessageMapper;
import com.czxy.yx.mapper.YxFriendRequestMapper;
import com.czxy.yx.service.YxFriendRequestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class YxFriendRequestServiceImpl implements YxFriendRequestService {

    @Resource
    YxFriendRequestMapper mapper;

    @Resource
    YxFriendMapper friendMapper;

    @Resource
    YxFriendMessageMapper messageMapper;

    @Override
    public void sendRequest(YxFriendRequest yxFriendRequest) {

        mapper.insertSelective(yxFriendRequest);

    }

    @Override
    public boolean isFriend(Integer uid, Integer acceptId) {

        List<YxFriend> yxFriends = friendMapper.selectFriend(uid, acceptId);

        if (yxFriends.size()!=0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isSend(Integer uid, Integer acceptId) {

       List<YxFriendRequest> list =  mapper.selectRequest(uid,acceptId,0);

       if (list.size()!=0){
           return true;
       }
        return false;
    }

    @Override
    public List<YxFriendRequest> getRequest(Integer acceptId) {
        return mapper.getRequest(acceptId);
    }

    @Override
    public Integer lookRequest(Integer uid) {
         return mapper.lookRequest(uid);
    }

    @Override
    public void setRequest(Integer num,Integer requestId,Integer acceptId) {
        mapper.setRequest(num,requestId,acceptId);
        mapper.addFriend(requestId,acceptId);
    }

    @Override
    public List<YxFriend> getFriends(Integer uid) {
      return  friendMapper.getFriends(uid);
    }

    @Override
    public Integer friendMessageNum(Integer uid) {
        return mapper.friendMessageNum(uid,0);
    }

    @Override
    public void setMessageStatus(Integer requestId, Integer acceptId) {
        messageMapper.setMessageStatus(requestId,acceptId,1);
    }

    @Override
    public List<YxFriendMessage> getFriendMessage(Integer requestId, Integer acceptId) {
        return messageMapper.getFriendMessage(requestId,acceptId,0);
    }

    @Override
    public void sendFriendResource(YxFriendMessage yxFriendMessage) {
        messageMapper.insertSelective(yxFriendMessage);
    }
}
