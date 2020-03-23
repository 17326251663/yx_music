package com.czxy.yx.controller;

import com.czxy.pojo.*;
import com.czxy.yx.service.MusicService;
import com.czxy.yx.service.YxFriendRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/yx-friend")
@RestController
public class YxFriendRequestController {

    @Resource
    YxFriendRequestService yxFriendRequestService;

    @Resource
    MusicService musicService;

    @PostMapping("/addFriend")
    public ResponseEntity addFriend(@RequestBody YxFriendRequest yxFriendRequest, HttpSession session){

        User user = (User) session.getAttribute(UserController.USER);
        //验证是否为好友
        boolean result = yxFriendRequestService.isFriend(user.getUid(),yxFriendRequest.getAcceptId());
        if (result){
        return new ResponseEntity("已经是好友了",HttpStatus.CREATED);
        }
        //验证是否已经发送过申请
        boolean result2 = yxFriendRequestService.isSend(user.getUid(),yxFriendRequest.getAcceptId());
        if (result2){
            return new ResponseEntity("已经发送过好友申请",HttpStatus.CREATED);
        }

        yxFriendRequestService.sendRequest(new YxFriendRequest(user.getUid(),yxFriendRequest.getAcceptId(),yxFriendRequest.getFriendRequest(),0));

        return new ResponseEntity("好友请求发送成功",HttpStatus.CREATED);
    }

    @GetMapping("/getRequest")
    public ResponseEntity<List<YxFriendRequest>> getRequest(HttpSession session){

        User user = (User) session.getAttribute(UserController.USER);

       List<YxFriendRequest> list = yxFriendRequestService.getRequest(user.getUid());

       return ResponseEntity.ok(list);
    }

    @GetMapping("/lookRequest")
    public ResponseEntity<Integer> lookRequest(HttpSession session){

        User user = (User) session.getAttribute(UserController.USER);

        Integer num = yxFriendRequestService.lookRequest(user.getUid());

        return ResponseEntity.ok(num);
    }

    @GetMapping("/setRequest/{num}/{requestId}")
    public ResponseEntity<String> setRequest(@PathVariable("num") Integer num,@PathVariable("requestId") Integer requestId,HttpSession session){

        if (num!=1&&num!=2){
            return ResponseEntity.ok("defeated");
        }

        User user = (User) session.getAttribute(UserController.USER);

        yxFriendRequestService.setRequest(num,requestId,user.getUid());

        return ResponseEntity.ok("success");
    }

    @GetMapping("/getFriends")
    public ResponseEntity<List<YxFriend>> getFriends(HttpSession session){

        User user
                 = (User) session.getAttribute(UserController.USER);

       List<YxFriend> list = yxFriendRequestService.getFriends(user.getUid());

       return  ResponseEntity.ok(list);
    }

    @GetMapping("/FriendMessageNum")
    public ResponseEntity<Integer> friendMessageNum(HttpSession session){

        User user =
                (User) session.getAttribute(UserController.USER);

        Integer num = yxFriendRequestService.friendMessageNum(user.getUid());

        return ResponseEntity.ok(num);
    }

    @PutMapping("/setMessageStatus/{uid}")
    public ResponseEntity setMessageStatus(@PathVariable("uid") Integer requestId, HttpSession session){

        User use =
                (User) session.getAttribute(UserController.USER);

        yxFriendRequestService.setMessageStatus(requestId,use.getUid());

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getFriendMessage/{uid}")
    public ResponseEntity<List<YxFriendMessage>> getFriendMessage(@PathVariable("uid") Integer requestId,HttpSession session){

        User user =
                (User) session.getAttribute(UserController.USER);

        List<YxFriendMessage> list = yxFriendRequestService.getFriendMessage(requestId,user.getUid());

        for (YxFriendMessage message : list) {
            Integer messageType = message.getMessageType();
            if (messageType==1){
                message.setMusicbase(musicService.selectMusicByMid(Integer.parseInt(message.getMessageContent())));
            }
        }

        return ResponseEntity.ok(list);
    }

    @GetMapping("/sendFriendResource/{mid}/{acceptId}")
    public ResponseEntity<Musicbase> sendFriendResource(@PathVariable("mid") Integer mid,@PathVariable("acceptId") Integer acceptId,HttpSession session){

        Musicbase musicbase = musicService.selectMusicByMid(mid);

        User user =
                (User) session.getAttribute(UserController.USER);

        yxFriendRequestService.sendFriendResource(new YxFriendMessage(user.getUid(),acceptId,mid+"",0,1,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));

        return ResponseEntity.ok(musicbase);
    }

    @PostMapping("/sendFriendText")
    public ResponseEntity sendFriendText(@RequestParam("text") String text,@RequestParam("uid") Integer uid,HttpSession session){

        String[] arr = {"<",">","/","\\"};

        for (String s : arr) {
            if (text.contains(s)){
                return ResponseEntity.ok("error");
            }
        }

        User user =
                (User) session.getAttribute(UserController.USER);

        yxFriendRequestService.sendFriendResource(new YxFriendMessage(user.getUid(),uid,text,0,0,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));

        return ResponseEntity.ok("success");
    }
}
