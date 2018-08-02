package com.zch.controller;

import com.zch.entity.User;
import com.zch.repository.UserRepository;
import com.zch.util.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by chensuo on 2018-7-31.
 */
@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    /**
     * 登录首页
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 登录验证
     * @param request
     * @return
     */
    @RequestMapping("/login_va")
    public String loginValidate(HttpServletRequest request) {
        boolean loginSuccess = false;
        try {
            String loginId = request.getParameter("loginid");
            String password = request.getParameter("password");
            String passwordMd5 = Helpers.MD5(password);
            if (userRepository.getUserByLoginIdAndPassword(loginId, passwordMd5) != null) {
                request.getSession(true).setAttribute("loginid", loginId);
                loginSuccess = true;
            }
        } catch (Exception e) {
            System.out.println("异常-登录名或密码不正确");
        } finally {
            return loginSuccess ? "redirect:login_su" : "login";
        }
    }

    /**
     * 登录成功
     * @return
     */
    @RequestMapping("/login_su")
    public String loginSuccess() {
        return "login_success";
    }

}