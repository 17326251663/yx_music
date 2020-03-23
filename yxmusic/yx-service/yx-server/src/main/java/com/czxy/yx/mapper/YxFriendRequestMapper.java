package com.czxy.yx.mapper;

import com.czxy.pojo.YxFriendRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface YxFriendRequestMapper extends Mapper<YxFriendRequest> {

    @Select("select * from YxFriendRequest where requestId =#{requestId} and acceptId = #{acceptId} and requestStatus = #{statusCode}")
    List<YxFriendRequest> selectRequest(Integer requestId, Integer acceptId, int statusCode);

    @Select("select t1.*,t2.uid as  `user.uid`,t2.loginId as `user.loginid`,t2.loginName as `user.loginname` from yxFriendRequest t1 , user t2 where t2.uid = t1.requestId and t1.acceptId = #{acceptId}")
    List<YxFriendRequest> getRequest(Integer acceptId);

    @Select("select count(rid) from yxFriendRequest where acceptId = #{acceptId} and requestStatus = 0")
    Integer lookRequest(Integer acceptId);

    @Update("update yxFriendRequest set requestStatus = #{num} where requestId = #{requestId} and acceptId = #{acceptId}")
    void setRequest(Integer num,Integer requestId,Integer acceptId);

    @Insert("insert into yxFriend values(null,#{requestId},#{acceptId},default)")
    void addFriend(Integer requestId,Integer acceptId);


    @Select("select count(mid) from yxFriendMessAge where acceptId = #{uid} and messageStatus = #{status}")
    Integer friendMessageNum(Integer uid,Integer status);
}
