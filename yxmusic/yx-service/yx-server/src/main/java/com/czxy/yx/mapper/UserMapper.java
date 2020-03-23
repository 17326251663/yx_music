package com.czxy.yx.mapper;

import com.czxy.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {

    @Select("select * from user where loginid = #{loginid} and loginPassword = #{loginpassword}")
    User selectUserByLoginIdAndPassword(User user);

    @Select("select * from user where telephoneNumber = #{telephone}")
    User selectBytelephone(String telephone);

    @Select("select * from user where loginId = #{loginid}")
    User selectByLoginId(User user);

    @Update("update user set telephoneNumber = '' where uid = #{uid}")
    void unbindTelByUid(Integer uid);

    @Update("update user set loginpassword = #{password} where uid = #{uid}")
    void upPassword(String password, Integer uid);

    @Select("select uid,loginName,timg,loginId from user where uid = #{uid}")
    User otherLookUser(Integer uid);
}
