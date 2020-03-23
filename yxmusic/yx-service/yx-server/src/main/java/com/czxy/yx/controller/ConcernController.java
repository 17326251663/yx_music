package com.czxy.yx.controller;

import com.czxy.pojo.User;
import com.czxy.yx.service.UserConcernService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/yx-concern")
public class ConcernController {

    @Resource
    UserConcernService userConcernService;

    @GetMapping("/lookConcern/{uid}")
    public ResponseEntity<String> lookConcern(HttpSession session, @PathVariable("uid")Integer uid){

        User user = (User) session.getAttribute(UserController.USER);

        int result = userConcernService.selectConcern(uid,user.getUid());

        if (result==1){
            return ResponseEntity.ok("ok");
        }else {
            return ResponseEntity.ok("no");
        }
    }

    @PutMapping("/concern/{uid}")
    public ResponseEntity concern(HttpSession session,@PathVariable("uid") Integer uid){

        User user = (User) session.getAttribute(UserController.USER);

        userConcernService.addConcern(uid,user.getUid());

        return new ResponseEntity("success", HttpStatus.CREATED);
    }

    @PutMapping("/unConcern/{uid}")
    public ResponseEntity unConcern(HttpSession session,@PathVariable("uid") Integer uid){

        User user = (User) session.getAttribute(UserController.USER);

        userConcernService.delConcern(uid,user.getUid());

        return new ResponseEntity("success", HttpStatus.CREATED);
    }
}
