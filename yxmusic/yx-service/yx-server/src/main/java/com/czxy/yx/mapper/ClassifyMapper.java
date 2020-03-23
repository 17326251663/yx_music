package com.czxy.yx.mapper;

import com.czxy.pojo.Classify;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ClassifyMapper extends Mapper<Classify> {

    @Select("select * from classify")
    @Results(
            id = "byId",
            value = {
                    @Result(property = "ifyid",column = "ifyid"),
                    @Result(property = "yxmv",column = "ifyid",many = @Many(select = "com.czxy.yx.mapper.YxmvMapper.selectByIfyId"))
            }
    )
    List<Classify> getAllClassIfyAndMv();


}
