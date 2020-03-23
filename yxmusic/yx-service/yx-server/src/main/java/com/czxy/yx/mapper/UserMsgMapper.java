package com.czxy.yx.mapper;

import com.czxy.pojo.UserMsg;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface UserMsgMapper extends Mapper<UserMsg> {

    @Update("update usermsg set concernNum = concernNum+1 where uid = #{fuid}")
    void addConcernNum(Integer fuid);

    @Update("update usermsg set fansNum = fansNum+1 where uid = #{guid}")
    void addFansNum(Integer guid);

    @Update("update usermsg set concernNum = concernNum-1 where uid = #{fuid}")
    void delConcernNum(Integer fuid);

    @Update("update usermsg set fansNum = fansNum-1 where uid = #{guid}")
    void delFansNum(Integer guid);
}
