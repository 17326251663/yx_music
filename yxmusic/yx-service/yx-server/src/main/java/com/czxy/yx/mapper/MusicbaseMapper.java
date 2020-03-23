package com.czxy.yx.mapper;

import com.czxy.pojo.Musicbase;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MusicbaseMapper extends Mapper<Musicbase> {

    @Select("<script>    select * from musicbase\n" +
            "    <where> status = 0 \n" +
            "        <if test=\"musicname != '%null%' and musicname !='%%'\">\n" +
            "            and (musicName like #{musicname} or singer like #{musicname} or ifyid = (select ifyid from classify where ifyname like #{musicname}))\n" +
            "        </if>\n" +
            "        <if test=\"order != null and order !=0\">\n" +
            "            and ifyid = #{order}\n" +
            "        </if>\n" +
            "    </where>\n" +
            "    order by uploadTime desc</script>")
   List<Musicbase> selectAllmusic(String musicname,Integer order);

    @Update("update musicbase set uploadNum=uploadNum+1 where mid = #{mid}")
    void addNum(Integer mid);

    @Select("select * from musicbase where status = 0 and mid in (select mid from yxMusicCollect where uid = #{uid})")
    List<Musicbase> selectMusicByUid(Integer uid);

    @Update("update musicbase set playnum = playnum+1 where mid = #{mid}")
    void addPlayNum(Integer mid);

    @Select("select t1.*,t2.uid as `user.uid` , t2.loginname as `user.loginname`,t3.ifyname as `classify.ifyname` from musicbase t1 , user t2 ,classify t3 where t1.uid = t2.uid and t1.ifyid = t3.ifyid and mid = #{mid}")
    Musicbase selectMusicByMid(Integer mid);

    @Select("select * from musicbase where status = 0  order by uploadNum desc , uploadTime limit #{pageSize}")
    List<Musicbase> selectByUploadNum(int pageSize);

    @Update("update musicbase set status = 1 where mid = #{mid} and uid = #{uid}")
    void delMusicBaseByMid(Integer mid,Integer uid);

    @Select("select * from musicbase where uid = #{uid} and status = 1")
    List<Musicbase> selectWithUidByRecycle(Integer uid);

    @Update("update musicbase set status = 0 where uid = #{uid} and mid = #{mid}")
    void updateStatusByMid(Integer mid, Integer uid);
}
