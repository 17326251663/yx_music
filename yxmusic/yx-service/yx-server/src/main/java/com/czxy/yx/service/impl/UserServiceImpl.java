package com.czxy.yx.service.impl;

import com.czxy.pojo.User;
import com.czxy.pojo.UserMsg;
import com.czxy.pojo.UserVo;
import com.czxy.yx.mapper.UserMapper;
import com.czxy.yx.mapper.UserMsgMapper;
import com.czxy.yx.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;
    @Resource
    UserMsgMapper userMsgMapper;

    @Override
    @Transactional(readOnly = true)
    public User login(User user) {

        User user1 = userMapper.selectUserByLoginIdAndPassword(user);

        System.out.println("登录结果为:"+user1);

        return user1;
    }

    @Override
    @Transactional(readOnly = true)
    public synchronized User registry(User user) {

        User user1 = userMapper.selectByLoginId(user);

        System.out.println("注册:找到相同的用户名为:"+user1);

        return user1;
    }

    @Override
    public synchronized void insert(User registry) {
        userMapper.insertSelective(registry);
        userMsgMapper.insert(new UserMsg(null,0L,0L));
    }

    @Override
    public User selectByTel(String tel) {

       return userMapper.selectBytelephone(tel);

    }

    @Override
    public void updateTimg(String serverUrl,Integer uid) {
        User user = new User();
        user.setTimg(serverUrl);
        user.setUid(uid);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void upUserMsg(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void bindTel(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void unbindTel(Integer uid) {
        userMapper.unbindTelByUid(uid);
    }

    @Override
    public UserVo selectUserVoByUid(Integer uid) {

        User user = userMapper.selectByPrimaryKey(uid);

        UserMsg userMsg = userMsgMapper.selectByPrimaryKey(uid);
        //隐藏重要的信息
        User user1 = new User();
        user1.setUid(uid);
        user1.setLoginid(user.getLoginid());
        user1.setVip(user.getVip());
        user1.setLoginname(user.getLoginname());
        user1.setTimg(user.getTimg());

        UserVo userVo = new UserVo(userMsg,user1);
        //返回
        return userVo;

    }

    @Override
    public void upPassword(String password, Integer uid) {
        userMapper.upPassword(password,uid);
    }


}
