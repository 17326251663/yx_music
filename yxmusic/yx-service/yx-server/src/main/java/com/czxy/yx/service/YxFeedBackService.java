package com.czxy.yx.service;

import com.czxy.pojo.YxFeedback;
import com.github.pagehelper.PageInfo;

public interface YxFeedBackService {
    void insert(YxFeedback yxFeedback);

    PageInfo<YxFeedback> selectAll(Integer num, Integer order);
}
