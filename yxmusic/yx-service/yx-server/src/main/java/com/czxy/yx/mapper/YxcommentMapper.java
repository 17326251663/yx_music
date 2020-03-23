package com.czxy.yx.mapper;

import com.czxy.pojo.Yxcomment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface YxcommentMapper extends Mapper<Yxcomment> {

    @Select("select t1.* , t2.uid as `user.uid` , t2.loginname as `user.loginname`,t2.timg as  `user.timg` from yxcomment t1 , user t2 where t1.uid = t2.uid and t1.mid = #{mid} and isparent = 0 order by t1.cnum desc ")
    List<Yxcomment> selectByMid(Integer mid);

    @Select("select count(*) from yxmusicTags where cid = #{cid} and uid = #{uid}")
    int selectCountByCidAndUid(Integer cid , Integer uid);

    @Insert("insert into yxmusicTags values(null,#{cid},#{uid},#{ip})")
    void addIp(Integer cid, Integer uid, String ip);

    @Delete("delete from yxmusicTags where cid = #{cid} and uid = #{uid}")
    void deletCountByCidAndUid(Integer cid, Integer uid);

    @Update("update yxcomment set cnum = cnum+1 where cid = #{cid}")
    void addZan(Integer cid);

    @Update("update yxcomment set cnum = cnum-1 where cid = #{cid}")
    void deleteZan(Integer cid);

    @Select("select t1.*,t2.uid as `user.uid` , t2.loginname as `user.loginname` from yxcomment t1,user t2 where t1.uid=t2.uid and isParent = #{cid} order by cnum")
    List<Yxcomment> seletbyIsParent(Integer cid);
}
