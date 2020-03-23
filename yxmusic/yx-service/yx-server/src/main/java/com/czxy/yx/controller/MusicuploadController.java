package com.czxy.yx.controller;

import com.czxy.pojo.Musicbase;
import com.czxy.pojo.User;
import com.czxy.yx.config.Path;
import com.czxy.yx.service.MusicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/yx-up")
public class MusicuploadController {

    @Resource
    MusicService musicService;

    static final String MUSICPATH = "/music/user/music/";
    static final String IMGPATH = "/music/user/img/";
    static final String URL = Path.SERVERURL +"/music";
    static final String REALPATH = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static\\music\\";

    @PostMapping("/myfile")
    public synchronized ResponseEntity<String> file(@RequestParam("musicurls") MultipartFile file, @RequestParam("imgurls") MultipartFile file2, Musicbase musicbase, HttpServletRequest request, HttpServletResponse response){


        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//处理跨域
        response.setHeader("Access-Control-Allow-Credentials", "true");//表示是否允许发送Cookie

        try {
            //获取用户是否登录
            System.out.println(request.getSession().getId());
            System.out.println(new Date(request.getSession().getCreationTime()).toString());
            User attribute = (User) request.getSession().getAttribute(UserController.USER);


            //生成资源名称
            String imgurl = IMGPATH+ attribute.getUid()+"/"+UUID.randomUUID().toString().replaceAll("-","")+".png";
            String musicurl = MUSICPATH+ attribute.getUid()+"/"+UUID.randomUUID().toString().replaceAll("-","")+".mp3";
            //生成目录
            File img = new File(REALPATH+imgurl);
            File music = new File(REALPATH+musicurl);
            if (!img.exists()&&!music.exists()){
                img.mkdirs();
                music.mkdirs();
            }


            //上传音乐到服务器
            long size = file.getSize();
            long sizeimg = file2.getSize();

            if (size/1000000>100||sizeimg/1000000>20){
                System.out.println("给你报错");
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            //存储资源信息到数据库
            musicbase.setMusicname(file.getOriginalFilename());
            musicbase.setImgurl(URL+imgurl);
            musicbase.setMusicurl(URL+musicurl);
            musicbase.setUploadtime(new Date());
            musicbase.setMsize((float) (size/1024/1024.0));
            musicbase.setUploadnum(0);
            musicbase.setPlaynum(0);

            musicbase.setUid(attribute.getUid());
            musicbase.setUname(attribute.getLoginname());
            System.out.println(musicbase);

            musicService.insert(musicbase);

            //上传图片到服务器
            file2.transferTo(img);
            file.transferTo(music);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.ok("error");
        }
            return ResponseEntity.ok("success");
    }


    @GetMapping("/uploadm/{mid}")
    public String uploadNum(@PathVariable("mid") Integer mid){

        musicService.addNum(mid);

        return null;
    }

}
