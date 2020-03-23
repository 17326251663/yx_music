package com.czxy.yx.service;

import com.czxy.pojo.User;
import com.czxy.pojo.UserVo;

public interface UserService {

    User login(User user);

    User registry(User user);

    void insert(User registry);

    User selectByTel(String tel);

    void updateTimg(String serverUrl,Integer uid);

    void upUserMsg(User user);

    void bindTel(User user);

    void unbindTel(Integer uid);

    UserVo selectUserVoByUid(Integer uid);

    void upPassword(String password,Integer uid);
}
