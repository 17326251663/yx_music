package com.czxy.yx.controller;

import com.czxy.pojo.User;
import com.czxy.pojo.YxFeedback;
import com.czxy.yx.service.YxFeedBackService;
import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/yx-feedback")
public class YxFeedBackController {

    @Resource
    YxFeedBackService yxFeedBackService;

    @PutMapping("/up")
    public ResponseEntity upFeedback(@RequestBody YxFeedback yxFeedback, HttpSession session){

        User attribute = (User) session.getAttribute(UserController.USER);

        yxFeedback.setUid(attribute.getUid());
        yxFeedback.setUname(attribute.getLoginname());
        yxFeedback.setDatetime(new Date());

        yxFeedBackService.insert(yxFeedback);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get/{num}/{order}")
    public ResponseEntity<PageInfo<YxFeedback>> getAllFeedback(@PathVariable("num") Integer num,@PathVariable("order") Integer order){

       PageInfo<YxFeedback> pageInfo = yxFeedBackService.selectAll(num,order);

       return ResponseEntity.ok(pageInfo);
    }

}
