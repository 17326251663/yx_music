package com.czxy.yx.service.impl;

import com.czxy.pojo.UserChat;
import com.czxy.yx.mapper.UserChatMapper;
import com.czxy.yx.service.UserChatService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserChatServiceImpl implements UserChatService {

    @Resource
    UserChatMapper userChatMapper;

    @Override
    public int getCount() {
        return userChatMapper.selectCount(null);
    }

    @Override
    public List<UserChat> getContent(int start, int end,int uid) {
        return userChatMapper.selectByLimit(start,end,uid);
    }

    @Override
    public void insert(UserChat userChat) {
        userChatMapper.insertSelective(userChat);
    }
}
