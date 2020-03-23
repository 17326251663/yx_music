package com.czxy.yx.service.impl;

import com.czxy.pojo.*;
import com.czxy.yx.mapper.ClassifyMapper;
import com.czxy.yx.mapper.MusicbaseMapper;
import com.czxy.yx.mapper.YxMusicCollectMapper;
import com.czxy.yx.service.MusicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@CacheConfig(cacheNames="music")
public class MusicServiceImpl implements MusicService {

    @Resource
    MusicbaseMapper musicbaseMapper;
    @Resource
    ClassifyMapper classifyMapper;
    @Resource
    YxMusicCollectMapper collectMapper;

    @Override
    public PageInfo<Musicbase> selectAllMusic(Condition condition) {

        PageHelper.startPage(condition.getNum(),10);

        List<Musicbase> musicbases = musicbaseMapper.selectAllmusic("%"+condition.getMusicname()+"%", condition.getIfyid());

        PageInfo<Musicbase> musicbasePageInfo = new PageInfo<>(musicbases);

        return musicbasePageInfo;
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable
    public List<Classify> selectIfy() {
        return classifyMapper.selectAll();
    }

    @Override
    public void insert(Musicbase musicbase) {
        musicbase.setStatus(0);
        musicbaseMapper.insert(musicbase);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(key = "#mid")
    public Musicbase selectByMid(int mid) {
        return musicbaseMapper.selectByPrimaryKey(mid);
    }

    @Override
    public void addNum(Integer mid) {
        musicbaseMapper.addNum(mid);
    }

    @Override
    public List<Musicbase> selectMyMusic(User attribute) {

        Musicbase musicbase = new Musicbase();
        musicbase.setUid(attribute.getUid());
        musicbase.setStatus(0);

        return musicbaseMapper.select(musicbase);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(key = "#uid" ,cacheNames = "collect")
    public PageInfo<Musicbase> selectMusicByUid(Integer pageNum, Integer uid) {

        PageHelper.startPage(pageNum,10);

       List<Musicbase> list = musicbaseMapper.selectMusicByUid(uid);

        PageInfo<Musicbase> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    @CacheEvict(cacheNames = "collect" ,beforeInvocation = true,allEntries = true)
    public void addCollect(Integer mid, User user) {
           collectMapper.insert(new YxMusicCollect(mid,user.getUid(),new Date()));
    }

    @Override
    @CacheEvict(cacheNames = "collect" , beforeInvocation = true,allEntries = true)
    public void deleteCollect(Integer mid, User user) {
        collectMapper.delete(new YxMusicCollect(mid,user.getUid()));
    }

    @Override
    public void addplay(Integer mid) {
        musicbaseMapper.addPlayNum(mid);
    }

    @Override
    public Musicbase selectMusicByMid(Integer mid) {

      return   musicbaseMapper.selectMusicByMid(mid);
    }

    @Override
    public List<Musicbase> selectByUploadNum(int pageSize) {
        return musicbaseMapper.selectByUploadNum(pageSize);
    }

    @Override
    public void delMusicBaseByMid(Integer mid,Integer uid) {
        musicbaseMapper.delMusicBaseByMid(mid,uid);
    }

    @Override
    public List<Musicbase> selectWithUidByRecycle(Integer uid) {
        return musicbaseMapper.selectWithUidByRecycle(uid);
    }

    @Override
    public void recover(Integer mid, Integer uid) {
        musicbaseMapper.updateStatusByMid(mid,uid);
    }


}
