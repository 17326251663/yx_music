package com.czxy.yx.mapper;

import com.czxy.pojo.UserChat;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserChatMapper extends Mapper<UserChat> {

    @Select("select t1.*,t2.uid as `user.uid`,t2.loginName as `user.loginname`,t2.timg as `user.timg`,if(#{uid}=t2.uid,1,0) as ismycontent from userchat t1, user t2 where t1.uid = t2.uid order by chatId limit ${start},${end}")
    List<UserChat> selectByLimit(int start, int end,int uid);

}
