package com.czxy.yx.service;

import com.czxy.pojo.Yxcomment;
import com.github.pagehelper.PageInfo;

public interface YxMusicCommentService {
    PageInfo<Yxcomment> select(Integer uid, Integer num);

    String setZan(Integer tid, Integer uid,String ip);

    void addComment(Yxcomment yxcomment);

    PageInfo<Yxcomment> getChildcomment(Integer cid, Integer pageNum);

    void insertComment(Yxcomment yxcomment);
}
