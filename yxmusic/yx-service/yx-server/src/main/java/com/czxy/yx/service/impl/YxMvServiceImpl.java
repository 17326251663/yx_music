package com.czxy.yx.service.impl;

import com.czxy.pojo.Classify;
import com.czxy.pojo.Yxmv;
import com.czxy.yx.mapper.ClassifyMapper;
import com.czxy.yx.mapper.YxmvMapper;
import com.czxy.yx.service.YxMvService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
@CacheConfig(cacheNames = {"mv"})
public class YxMvServiceImpl implements YxMvService {

    @Resource
    YxmvMapper yxMvMapper;
    @Resource
    ClassifyMapper classifyMapper;

    @Override
    @Cacheable(key = "#condition")
    public PageInfo<Yxmv> selectMvByPage(Integer pageNum, String condition) {

        if (condition==null||condition==""){
            condition = "%%";
        }else {
            condition = "%" +condition +"%";
        }

        PageHelper.startPage(pageNum,4);

       List<Yxmv> yxmvs = yxMvMapper.selectByCondition(condition);

        return new PageInfo<>(yxmvs);

    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable
    public List<Classify> selectMvByIfy() {
        return   classifyMapper.getAllClassIfyAndMv();
    }


}
