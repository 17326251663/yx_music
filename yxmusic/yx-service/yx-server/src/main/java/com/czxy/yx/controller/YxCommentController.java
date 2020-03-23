package com.czxy.yx.controller;

import com.czxy.pojo.User;
import com.czxy.pojo.Yxcomment;
import com.czxy.yx.service.YxMusicCommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/yx-comment")
public class YxCommentController {

    @Resource
    YxMusicCommentService commentService;

    @GetMapping("select/{mid}/{num}")
    public ResponseEntity<PageInfo>  select(@PathVariable(value = "num") Integer num,@PathVariable(value = "mid") Integer mid){

       PageInfo<Yxcomment> yxcommentPageInfo = commentService.select(mid,num);

       return ResponseEntity.ok(yxcommentPageInfo);
    }

    @PutMapping("/zan/{tid}")
    public ResponseEntity<String> dianzan(@PathVariable("tid") Integer tid, HttpServletRequest request){

        User user
                = (User) request.getSession().getAttribute(UserController.USER);

        String remoteAddr = request.getRemoteAddr();

        String result =  commentService.setZan(tid,user.getUid(),remoteAddr);


       return ResponseEntity.ok(result);
    }

    @PutMapping("/comment")
    public ResponseEntity comment(@RequestBody Yxcomment yxcomment, HttpSession session){

        User user =
                (User) session.getAttribute(UserController.USER);

        yxcomment.setIsparent(0);
        yxcomment.setRecoverytime(new Date());
        yxcomment.setUid(user.getUid());
        yxcomment.setCnum(0);

        commentService.addComment(yxcomment);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/child/{cid}/{pageNum}")
    public ResponseEntity<PageInfo<Yxcomment>> getChild(@PathVariable("cid") Integer cid,@PathVariable("pageNum") Integer pageNum){

       PageInfo<Yxcomment> list =  commentService.getChildcomment(cid,pageNum);

       return ResponseEntity.ok(list);
    }
    @PostMapping("/huifu")
    public ResponseEntity huifu(Yxcomment yxcomment,HttpSession session){

        User user = (User) session.getAttribute(UserController.USER);

        yxcomment.setUid(user.getUid());
        yxcomment.setCnum(0);

        commentService.insertComment(yxcomment);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
}
