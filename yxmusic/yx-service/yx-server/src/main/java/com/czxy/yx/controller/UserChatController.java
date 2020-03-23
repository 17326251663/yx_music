package com.czxy.yx.controller;

import com.czxy.pojo.Musicbase;
import com.czxy.pojo.User;
import com.czxy.pojo.UserChat;
import com.czxy.yx.service.MusicService;
import com.czxy.yx.service.UserChatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/yx-chat")
public class UserChatController {

    @Resource
    UserChatService userChatService;
    @Resource
    MusicService musicService;

    public static final  String USERCHATSESSION = "yx-userChatNum";

    @GetMapping("/setNum")
    public ResponseEntity<String> setInitNum(HttpSession session){

       int num = userChatService.getCount();

       if (num<100){
           num=0;
       }else {
           num -= 100;
       }
       session.setAttribute(USERCHATSESSION,num);

       return ResponseEntity.ok("success");
    }

    @GetMapping("/content")
    public ResponseEntity<List<UserChat>> getContent(HttpSession session){

        int num = (int) session.getAttribute(USERCHATSESSION);
        User user = (User) session.getAttribute(UserController.USER);

        int count = userChatService.getCount();

        if (num==count){
            return null;
        }

        session.setAttribute(USERCHATSESSION,count);

        List<UserChat> content = userChatService.getContent(num, count - num,user.getUid());

        for (UserChat userChat : content) {
            /*如果为资源*/
            if (userChat.getType()==1){
                /*获取到音乐资源*/
                Musicbase musicbase = musicService.selectMusicByMid(Integer.valueOf(userChat.getSendcontent()));
                /*设置*/
                userChat.setMusicbase(musicbase);
            }
        }

        return ResponseEntity.ok(content);
    }

    @PostMapping("/sendcommon")
    public ResponseEntity sendcommon(@RequestParam("content") String content,HttpSession session){

        User user = (User) session.getAttribute(UserController.USER);

        UserChat userChat = new UserChat(user.getUid(),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),content,0);

        userChatService.insert(userChat);

        return new ResponseEntity("success", HttpStatus.CREATED);
    }

    @GetMapping("/sendresource/{mid}")
    public ResponseEntity sendresource(@PathVariable("mid") Integer mid,HttpSession session){

        User user = (User) session.getAttribute(UserController.USER);

        UserChat userChat = new UserChat(user.getUid(),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),mid+"",1);

        userChatService.insert(userChat);

        return ResponseEntity.ok("success");
    }


}
