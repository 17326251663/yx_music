package com.czxy.yx.service.impl;

import com.czxy.yx.mapper.UserConcernMapper;
import com.czxy.yx.mapper.UserMsgMapper;
import com.czxy.yx.service.UserConcernService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserConcernServiceImpl implements UserConcernService {

    @Resource
    UserConcernMapper userConcernMapper;
    @Resource
    UserMsgMapper userMsgMapper;

    @Override
    public int selectConcern(Integer guid, Integer fuid) {
        return userConcernMapper.selectbyGuidAndFuid(guid,fuid);
    }

    @Override
    public void addConcern(Integer guid, Integer fuid) {
        userConcernMapper.addConcern(guid,fuid);
        userMsgMapper.addConcernNum(fuid);
        userMsgMapper.addFansNum(guid);
    }

    @Override
    public void delConcern(Integer guid, Integer fuid) {
        userConcernMapper.delConcern(guid,fuid);
        userMsgMapper.delConcernNum(fuid);
        userMsgMapper.delFansNum(guid);
    }
}
