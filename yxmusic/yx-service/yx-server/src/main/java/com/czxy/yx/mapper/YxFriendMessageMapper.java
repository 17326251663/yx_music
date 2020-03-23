package com.czxy.yx.mapper;

import com.czxy.pojo.YxFriendMessage;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface YxFriendMessageMapper extends Mapper<YxFriendMessage> {
    @Update("update yxFriendMessage set messageStatus = #{messageStatus} where requestId = #{requestId} and acceptId = #{acceptId}")
    void setMessageStatus(Integer requestId, Integer acceptId, int messageStatus);

    @Select("select messageContent,messageType,sendTime from yxFriendMessage where requestId = #{requestId} and acceptId = #{acceptId} and messageStatus = #{statusCode} order by sendTime")
    List<YxFriendMessage> getFriendMessage(Integer requestId,Integer acceptId,Integer statusCode);
}
