package com.czxy.yx.service.impl;

import com.czxy.pojo.Yxcomment;
import com.czxy.yx.mapper.YxcommentMapper;
import com.czxy.yx.service.YxMusicCommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class YxMusicCommentServiceImpl implements YxMusicCommentService {

    @Resource
    YxcommentMapper commentMapper;

    @Override
    public PageInfo<Yxcomment> select(Integer mid, Integer num) {

        PageHelper.startPage(num,20);

        List<Yxcomment> list = commentMapper.selectByMid(mid);

        PageInfo<Yxcomment> yxcommentPageInfo = new PageInfo<>(list);

        return yxcommentPageInfo;
    }

    @Override
    public String setZan(Integer cid, Integer uid,String ip) {

        int i = commentMapper.selectCountByCidAndUid(cid, uid);

        if (i==0){
            commentMapper.addZan(cid);
            commentMapper.addIp(cid, uid,ip);
            return "add";
        }
            commentMapper.deleteZan(cid);
            commentMapper.deletCountByCidAndUid(cid,uid);
            return "del";

    }

    @Override
    public void addComment(Yxcomment yxcomment) {
        commentMapper.insert(yxcomment);
    }

    @Override
    public PageInfo<Yxcomment> getChildcomment(Integer cid, Integer pageNum) {

        PageHelper.startPage(pageNum,10);

       List<Yxcomment> list =  commentMapper.seletbyIsParent(cid);

       return  new PageInfo<Yxcomment>(list);

    }

    @Override
    public void insertComment(Yxcomment yxcomment) {
        commentMapper.insertSelective(yxcomment);
    }

}
