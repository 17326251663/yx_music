package com.czxy.yx.service.impl;

import com.czxy.pojo.YxFeedback;
import com.czxy.yx.mapper.YxFeedBackMapper;
import com.czxy.yx.service.YxFeedBackService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class YxFeedBackServiceImpl implements YxFeedBackService {

    @Resource
    YxFeedBackMapper feedBackMapper;

    @Override
    public void insert(YxFeedback yxFeedback) {

        feedBackMapper.insert(yxFeedback);

    }

    @Transactional(readOnly = true)
    @Override
    public PageInfo<YxFeedback> selectAll(Integer num, Integer order) {

        PageHelper.startPage(num,10);

        Example example = new Example(YxFeedback.class);


        if (order==1){
            example.orderBy("datetime").desc();
        }else {
            example.orderBy("datetime");
        }

        List<YxFeedback> yxFeedbacks = feedBackMapper.selectByExample(example);

        PageInfo<YxFeedback> pageInfo = new PageInfo<>(yxFeedbacks);

        return pageInfo;
    }
}
