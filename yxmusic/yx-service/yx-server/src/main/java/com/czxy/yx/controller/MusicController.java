package com.czxy.yx.controller;

import com.czxy.pojo.Classify;
import com.czxy.pojo.Condition;
import com.czxy.pojo.Musicbase;
import com.czxy.pojo.User;
import com.czxy.yx.service.MusicService;
import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 207798583@qq.com
 * @version 1.0
 * @date 2019/8/16
 * @infos
 */
@RestController
@RequestMapping("/yx-music")
public class MusicController {

    @Resource
    MusicService musicService;

    @PostMapping("/music")
    public ResponseEntity<PageInfo<Musicbase>> selectMusic(@RequestBody Condition condition) {

        PageInfo<Musicbase> musicbasePageInfo = musicService.selectAllMusic(condition);

        return ResponseEntity.ok(musicbasePageInfo);
    }

    @DeleteMapping("/{mid}")
        public ResponseEntity delMusicBaseByMid(@PathVariable("mid") Integer mid,HttpSession session){
        User user = (User) session.getAttribute(UserController.USER);
        musicService.delMusicBaseByMid(mid,user.getUid());
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/recycle")
    public ResponseEntity<List<Musicbase>> selectWithUidByRecycle(HttpSession session){
        User user = (User) session.getAttribute(UserController.USER);
       return ResponseEntity.ok(musicService.selectWithUidByRecycle(user.getUid()));
    }

    @GetMapping("/ify")
    public ResponseEntity<List<Classify>> selectIfy() {

        List<Classify> classifies = musicService.selectIfy();

        return ResponseEntity.ok(classifies);
    }

    @GetMapping("/recently/{mid}")
    public String recently(@PathVariable("mid") Integer mid, HttpServletRequest request, HttpServletResponse response) {

        Cookie cookie = getcookie(request,"yx-music-recently");

        if (cookie == null) {
            cookie = new Cookie("yx-music-recently", mid.toString());
        } else {
            //判断是否播放相同歌曲
            String value = cookie.getValue();
            String[] yxes = value.split("yx");
            //是,不再记录返回
            if (yxes[0].equals(mid.toString())) {
                return null;
            }

            if (value.contains("yx"+mid.toString())){

                value = value.replaceAll("yx"+mid.toString(),"");
                yxes = value.split("yx");

            }


            //判断长度是否超出
            if (yxes.length<=20){
                cookie.setValue(mid+"yx"+value);
            }else {
                value = mid+"yx"+value.substring(value.lastIndexOf("yx"));
                cookie.setValue(value);
            }

        }

        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(cookie);

        return null;
    }


    @GetMapping("/recently")
    public ResponseEntity<List<Musicbase>> recently(HttpServletRequest request){

        List<Musicbase> list = new ArrayList<>();

        Cookie cookie = getcookie(request,"yx-music-recently");

        if (cookie==null){
            return ResponseEntity.ok(new ArrayList<Musicbase>());
        }

        String[] yxes = cookie.getValue().replaceAll("yxyx","yx").split("yx");

        for (String yx : yxes) {
            list.add(musicService.selectByMid(Integer.parseInt(yx)));
        }

        return ResponseEntity.ok(list);
    }


    /**
     * 获取cookie的抽取类
     * @param request request
     * @return cookie
     */
    public static Cookie getcookie(HttpServletRequest request,String value){
        Cookie cookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie1 : cookies) {
                if (cookie1.getName().equals(value)) {
                    cookie = cookie1;
                    break;
                }
            }
        }
        return cookie;
    }

    @GetMapping("/getmyyun")
    public ResponseEntity<List<Musicbase>> getmyyun(HttpSession session){

        User attribute = (User) session.getAttribute(UserController.USER);

        List<Musicbase> list = musicService.selectMyMusic(attribute);

        return ResponseEntity.ok(list);
    }

    @GetMapping("/getMyCollect/{num}")
    public ResponseEntity<PageInfo<Musicbase>> selectMusicByUid(@PathVariable("num") Integer pageNum, HttpSession session){

        User user = (User) session.getAttribute(UserController.USER);

        PageInfo<Musicbase> pageInfo =  musicService.selectMusicByUid(pageNum,user.getUid());

        return ResponseEntity.ok(pageInfo);

    }

    @PutMapping("/collectMusic/{mid}")
    public ResponseEntity addCollect(@PathVariable("mid") Integer mid, HttpSession session){

        User user = (User) session.getAttribute(UserController.USER);

        try {
            musicService.addCollect(mid,user);
            return new ResponseEntity("success",HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity("error",HttpStatus.CREATED);
        }

    }

    @DeleteMapping("/collectMusic/{mid}")
    public ResponseEntity deleteCollect(@PathVariable("mid") Integer mid, HttpSession session){

        User user = (User) session.getAttribute(UserController.USER);

            musicService.deleteCollect(mid,user);

            return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
    @GetMapping("/playnum/{mid}")
    public String playnum(@PathVariable Integer mid){

        musicService.addplay(mid);

        return null;
    }
    @GetMapping("/lookmusic/{mid}")
    public ResponseEntity<Musicbase> lookmusic(@PathVariable Integer mid){

        Musicbase musicbase = musicService.selectMusicByMid(mid);

        return ResponseEntity.ok(musicbase);
    }

    @GetMapping("/getOtheryun/{uid}")
    public ResponseEntity<List<Musicbase>> getOtheryun(@PathVariable("uid") Integer uid){

        User user = new User();

        user.setUid(uid);

        List<Musicbase> list = musicService.selectMyMusic(user);

        return ResponseEntity.ok(list);
    }

    @GetMapping("/getOtherMusic/{uid}")
    public ResponseEntity<List<Musicbase>> getOtherMusic(@PathVariable("uid") Integer uid){

        List<Musicbase> list = musicService.selectMusicByUid(uid,1).getList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/initMusicOfHot")
    public ResponseEntity<List<Musicbase>> initMusicOfHot(){
        return ResponseEntity.ok(musicService.selectByUploadNum(10));
    }

    @GetMapping("/music_recover/{mid}")
    public ResponseEntity recover(@PathVariable("mid") Integer mid,HttpSession session){
        User user = (User) session.getAttribute(UserController.USER);
        musicService.recover(mid,user.getUid());
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/initTape")
    public ResponseEntity<Byte[]> initTape(){

       // new File();

        return null;
    }
}
