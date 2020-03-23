package com.czxy.yx.service;

import com.czxy.pojo.Classify;
import com.czxy.pojo.Yxmv;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface YxMvService {
    PageInfo<Yxmv> selectMvByPage(Integer pageNum, String condition);

    List<Classify> selectMvByIfy();

}
