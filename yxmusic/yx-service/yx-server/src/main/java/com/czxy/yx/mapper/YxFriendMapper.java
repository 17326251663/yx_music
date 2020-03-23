package com.czxy.yx.mapper;

import com.czxy.pojo.YxFriend;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface YxFriendMapper extends Mapper<YxFriend> {

    @Select("select * from yxfriend where (uid1 = #{requestId} and uid2 = #{acceptId}) or (uid2 = #{requestId} and uid1=#{acceptId})")
    List<YxFriend> selectFriend(Integer requestId, Integer acceptId);

    /**
     * 查看好友数量及未查看消息数量
     * @param uid
     * @return
     */
    @Select("select t1.fid as `fid`,t1.createTime as `createTime`, if(t1.uid1=#{uid},t1.uid1,t1.uid2) as `uid1`,if(t1.uid2=#{uid},t1.uid1,t1.uid2) as `uid2` , (select count(mid) from yxFriendMessAge where requestId = IF(t1.uid2=#{uid},t1.uid1,t1.uid2 ) AND acceptId = IF(t1.uid1=#{uid},t1.uid1,t1.uid2) and messageStatus = 0) as messageNum  from yxFriend t1 where uid1 = #{uid} or uid2 = #{uid}  order by  `messageNum` desc")
    @Results(
            id = "getFriends",value = {
            @Result(property = "uid2",column = "uid2"),
            @Result(property = "user",column = "uid2",one = @One(select = "com.czxy.yx.mapper.UserMapper.otherLookUser"))
    }
    )
    List<YxFriend> getFriends(Integer uid);
}
