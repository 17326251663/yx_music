package com.czxy.yx.service;

import com.czxy.pojo.Classify;
import com.czxy.pojo.Condition;
import com.czxy.pojo.Musicbase;
import com.czxy.pojo.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MusicService {

    PageInfo<Musicbase> selectAllMusic(Condition condition);

    List<Classify> selectIfy();

    void insert(Musicbase musicbase);

    Musicbase selectByMid(int mid);

    void addNum(Integer mid);

    List<Musicbase> selectMyMusic(User attribute);

    PageInfo<Musicbase> selectMusicByUid(Integer pageNum, Integer uid);

    void addCollect(Integer mid, User user);

    void deleteCollect(Integer mid, User user);

    void addplay(Integer mid);

    Musicbase selectMusicByMid(Integer mid);

    List<Musicbase> selectByUploadNum(int pageSize);

    void delMusicBaseByMid(Integer mid,Integer uid);

    List<Musicbase> selectWithUidByRecycle(Integer uid);

    void recover(Integer mid, Integer uid);
}
