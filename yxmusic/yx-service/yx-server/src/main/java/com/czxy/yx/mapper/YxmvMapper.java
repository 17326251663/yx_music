package com.czxy.yx.mapper;

import com.czxy.pojo.Yxmv;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface YxmvMapper extends Mapper<Yxmv> {

    @Select("select * from yxmv where mname like #{condition} or mtitle like #{condition}")
    List<Yxmv> selectByCondition(String condition);

    @Select("select * from yxmv where ifyid = #{ifyid} limit 4")
    List<Yxmv> selectByIfyId(Integer ifyid);
}
