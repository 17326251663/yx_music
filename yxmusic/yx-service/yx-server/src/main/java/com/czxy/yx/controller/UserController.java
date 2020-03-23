package com.czxy.yx.controller;

import com.aliyuncs.exceptions.ClientException;
import com.czxy.pojo.TelephoneVo;
import com.czxy.pojo.User;
import com.czxy.pojo.UserVo;
import com.czxy.yx.config.Path;
import com.czxy.yx.service.UserService;
import com.czxy.yx.util.NoteUtil;
import com.czxy.yx.util.PasswordUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/yx")
public class UserController {

    @Resource
    UserService userService;

    public static final String USER;

    static final String URL = Path.SERVERURL+"/photo/user/";
    static final String REALPATH = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static\\photo\\user\\";

    static {
        USER = "yx-user";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {


        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//处理跨域
        response.setHeader("Access-Control-Allow-Credentials", "true");//表示是否允许发送Cookie


        User login = userService.login(user);

        if (login==null){
         return ResponseEntity.ok("账号不存在或密码有误,请重新输入");
        }

        System.out.println("登录成功:"+login+":"+session.getId());


        session.setAttribute(USER,login);

        Cookie cookie = new Cookie("yx-user", login.getLoginid() + "______" + PasswordUtil.coding(PasswordUtil.encrypt(login.getLoginpassword())));

        cookie.setPath("/");

        cookie.setMaxAge(60*60*24*14);

        response.addCookie(cookie);

        return ResponseEntity.ok("success");
    }

    @PostMapping("/registry")
    public ResponseEntity<String> registry(@RequestBody User user, HttpSession session, HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException {

        User registry = userService.registry(user);

        System.out.println(registry);

        if (registry!=null){
            return ResponseEntity.ok("账号重复,请重新选择一个吧");
        }

        user.setOverduetime(new Date());

        //把账号信息存入数据库
        userService.insert(user);

        //进行自动登录
        login(user,session,response,request);

        return ResponseEntity.ok("success");

    }

    @GetMapping("/giveCode/{tel}")
    public ResponseEntity<String> giveCode(@PathVariable("tel") String tel,HttpSession session) throws ClientException {

        if (!tel.matches("[0-9]{11}")){
            return ResponseEntity.ok("手机号码格式有误");
        }

        System.out.println(tel);

       User user = userService.selectByTel(tel);

        if (user==null){
            return ResponseEntity.ok("手机号尚未绑定账号");
        }

        //发送验证码对手机号
        String code = NoteUtil.sendSms(tel);
        //获得验证码
        //存入session域
        session.setAttribute("yx-tel",new TelephoneVo(tel,code,new Date()));

        //返回状态
        return ResponseEntity.ok("success");

    }

    @GetMapping("/getCode/{tel}")
    public ResponseEntity<String> getCode(@PathVariable("tel") String tel,HttpSession session) throws ClientException {

        if (!tel.matches("[0-9]{11}")){
            return ResponseEntity.ok("手机号码格式有误");
        }

        User user = userService.selectByTel(tel);

        if (user!=null){
            return ResponseEntity.ok("该手机号已绑定账号");
        }

        String code = NoteUtil.sendSms(tel);

        TelephoneVo telephoneVo = new TelephoneVo(tel, code, new Date());

        session.setAttribute("yx-tel-bind",telephoneVo);

        return ResponseEntity.ok("success");
    }

    @PostMapping("/bindTel")
    public ResponseEntity<String> bindTel(@RequestBody TelephoneVo telephoneVo,HttpSession session){

      TelephoneVo telephoneVo1 = (TelephoneVo) session.getAttribute("yx-tel-bind");

      if (telephoneVo1==null){
          return ResponseEntity.ok("请先获取验证码");
      }

      if (!telephoneVo1.getStatusCode()){
          session.removeAttribute("yx-tel-bind");
          return ResponseEntity.ok("验证码已失效");
      }

      if (!telephoneVo1.getSecurityCode().equals(telephoneVo.getSecurityCode())||!telephoneVo1.getTelephone().equals(telephoneVo.getTelephone())){
          return ResponseEntity.ok("验证码有误");
      }

      //验证成功,绑定验证码
        User user = (User) session.getAttribute(USER);

      user.setTelephonenumber(telephoneVo1.getTelephone());

      userService.bindTel(user);

      return ResponseEntity.ok("success");
    }

    @GetMapping("/unbind")
    public ResponseEntity<String> unbind1(HttpSession session) throws ClientException {

        User user = (User) session.getAttribute(USER);

        String tel = user.getTelephonenumber();

        if (tel==null||tel.equals("")){
            return ResponseEntity.ok("null");
        }

        String code = NoteUtil.sendSms(tel);

        session.setAttribute("yx-tel-unbind",code);

        return ResponseEntity.ok("我们向您的手机:"+tel.substring(0,3)+"*******"+tel.substring(tel.length()-1)+"发送了一条验证码,请注意查收");
    }

    @GetMapping("/unbind/{code}")
    public ResponseEntity<String> unbind2(@PathVariable("code") String code,HttpSession session){

       String serverCode = (String) session.getAttribute("yx-tel-unbind");

       if (serverCode==null){
           return  ResponseEntity.ok("请先获取验证码");
       }

       if (!serverCode.equals(code)){
           return  ResponseEntity.ok("验证码有误");
       }

       //通过验证,同步服务器及数据库
        User user = (User) session.getAttribute(USER);
        user.setTelephonenumber("");

        userService.unbindTel(user.getUid());

        return ResponseEntity.ok("success");
    }


    @PostMapping("/login-t")
    public ResponseEntity<String> loginByTelephone(@RequestBody TelephoneVo telephoneVo,HttpSession session,HttpServletResponse response) throws UnsupportedEncodingException {

        //判断是否存在验证码
        TelephoneVo telVo = (TelephoneVo) session.getAttribute("yx-tel");
        if (telVo==null){
            return ResponseEntity.ok("请先获取验证码");
        }
        if (!telVo.getSecurityCode().equals(telephoneVo.getSecurityCode())||!telVo.getTelephone().equals(telephoneVo.getTelephone())){
            return ResponseEntity.ok("验证码输入有误");
        }
        if (!telVo.getStatusCode()){
            session.removeAttribute("yx-tel");
            return ResponseEntity.ok("验证码已过期");
        }
        //登陆成功,把用户信息存入session域
        User login = userService.selectByTel(telVo.getTelephone());
        session.setAttribute(USER,login);

        Cookie cookie = new Cookie("yx-user", login.getLoginid() + "______" + PasswordUtil.coding(PasswordUtil.encrypt(login.getLoginpassword())));

        cookie.setPath("/");

        cookie.setMaxAge(60*60*24*14);

        response.addCookie(cookie);

        return ResponseEntity.ok("success");
    }

    @GetMapping("/loginout")
    public ResponseEntity<String> loginout(HttpSession session, HttpServletResponse response) {

        session.removeAttribute(UserController.USER);

        Cookie cookie = new Cookie("yx-user", "null");

        cookie.setPath("/");

        cookie.setMaxAge(0);

        response.addCookie(cookie);

        return ResponseEntity.ok("ok");
    }


    @PostMapping("/uptimg")
    public ResponseEntity<String> uptimg(@RequestParam("timg")MultipartFile file,HttpSession session) throws IOException {


        if (!file.getContentType().startsWith("image/")){
            return  ResponseEntity.ok("格式有误,非图片");
        }

        User user
                 = (User) session.getAttribute(USER);

        File file1 = new File(REALPATH, String.valueOf(user.getUid()));

        if (!file1.exists()){
            file1.mkdirs();
        }

        //生成随机名称
        String img = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String timgName = UUID.randomUUID().toString().replaceAll("-","")+img;

        //存放到服务器
        file.transferTo(new File(file1+"/"+timgName));
        //生成服务器路径
        String serverUrl = URL+user.getUid()+"/"+timgName;
        //存放到数据库
        userService.updateTimg(serverUrl,user.getUid());
        //更改session信息
        user.setTimg(serverUrl);


        return ResponseEntity.ok("更换成功");
    }

    @GetMapping("/userMsg")
    public ResponseEntity<User> getUser(HttpSession session){

        User user = (User) session.getAttribute(USER);

        return  ResponseEntity.ok(user);
    }

    @PutMapping("/upUserMsg")
    public ResponseEntity upUserMsg(@RequestBody User user,HttpSession session){

        User suser = (User) session.getAttribute(USER);
        //同步数据
        user.setUid(suser.getUid());
        user.setTelephonenumber(null);
        user.setTimg(null);
        user.setLoginid(null);
        user.setVip(null);
        user.setLoginpassword(null);
        user.setOverduetime(null);
        user.setStatuscode(null);

        userService.upUserMsg(user);

        suser.setEmail(user.getEmail());
        suser.setAge(user.getAge());
        suser.setGender(user.getGender());
        suser.setIntro(user.getIntro());
        suser.setLoginname(user.getLoginname());

        return new ResponseEntity( HttpStatus.NO_CONTENT);
    }

    @GetMapping("/gettimg")
    public ResponseEntity<String> gettimg(HttpSession session){
        User user = (User) session.getAttribute(USER);
        return ResponseEntity.ok(user.getTimg());
    }

    @GetMapping("/isBind")
    public ResponseEntity<String> isBind(HttpSession session){

        User user = (User) session.getAttribute(USER);

        String tel = user.getTelephonenumber();

        if (tel!=null&&!tel.equals("")){
            return ResponseEntity.ok("已绑定手机号:"+tel.substring(0,3)+"*******"+tel.substring(tel.length()-1));
        }
        return ResponseEntity.ok("Yes");

    }

    @GetMapping("/otherUser/{uid}")
    public ResponseEntity<UserVo> getOtherUserMessage(@PathVariable("uid") Integer uid){

        UserVo userVo = userService.selectUserVoByUid(uid);

        return ResponseEntity.ok(userVo);
    }

    @PutMapping("/user")
    public ResponseEntity upPassword(@RequestParam("old") String oldPassword,@RequestParam("new") String newPassword,HttpSession session,HttpServletResponse response){

        User user
                 = (User) session.getAttribute(USER);

        if (!user.getLoginpassword().equals(oldPassword)||oldPassword.length()==0||newPassword.length()==0){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
            userService.upPassword(newPassword,user.getUid());

            loginout(session,response);

            return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    public static void main(String[] args) {
        System.out.println("17326251663".matches("[0-9]{11}"));
    }

}
