package com.czxy.yx.config;

import com.czxy.pojo.User;
import com.czxy.yx.controller.MusicController;
import com.czxy.yx.controller.UserController;
import com.czxy.yx.service.UserService;
import com.czxy.yx.util.PasswordUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 207798583@qq.com
 * @version 1.0
 * @date 2019/8/17
 * @infos
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Resource
    UserService userService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new HandlerInterceptor() {

            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

                String requestURI = request.getRequestURI();

                System.out.println(requestURI);

                User attribute = (User) request.getSession().getAttribute(UserController.USER);

                if (attribute!=null){
                    return true;
                }

                Cookie getcookie = MusicController.getcookie(request, "yx-user");

                if (getcookie!=null){

                    String[] s = getcookie.getValue().split("______");
                    String username = s[0];
                    String password = PasswordUtil.encrypt(PasswordUtil.decode(s[1]));

                    User user = new User(username, password);
                    System.out.println("自动登录:"+user);

                    User login = userService.login(user);

                    if (login!=null){
                        request.getSession().setAttribute(UserController.USER,login);
                        return true;
                    }
                    //未登录
                    getcookie.setMaxAge(0);
                    getcookie.setPath("/");
                    response.addCookie(getcookie);
                    response.sendRedirect(Path.SERVERURL+"/welcome.html?1");
                    return false;
                }


                    //未登录
                    response.sendRedirect(Path.SERVERURL+"/welcome.html?2");
                    return false;
            }

        })
                .addPathPatterns("/**")
                .excludePathPatterns("/login/login.html","/yx/login","/yx/login-t","/yx/registry","/js/**","/css/**","/welcome.html","/images/**","/fonts/**","/yx/giveCode/**","/photo/user/**","/mv/**");
    }


}


