package com.czxy.yx.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserConcernMapper {

    @Select("select count(*) from userconcern where concernId = #{guid} and fansId = #{fuid}")
    int selectbyGuidAndFuid(Integer guid, Integer fuid);

    @Insert("insert into userConcern values(null,#{guid},#{fuid},null)")
    void addConcern(Integer guid, Integer fuid);

    @Delete("delete from userConcern where concernId = #{guid} and fansId = #{fuid}")
    void delConcern(Integer guid, Integer fuid);
}
