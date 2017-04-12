package com.zkh.controller;

import com.zkh.exception.CustomException;
import com.zkh.pojo.ViewModel.LoginViewModel;
import com.zkh.service.UserService;
import com.zkh.util.ControllerUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by ms-zk on 2017-03-15.
 */
@Controller
public class AccountController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return View("login");
    }

    @PostMapping("/login")
    public String loginSubmit(Model model, @Valid LoginViewModel loginViewModel, BindingResult bindingResult) throws CustomException {
        if(!bindingResult.hasErrors()){
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordTokentoken = new UsernamePasswordToken(loginViewModel.getEmail().trim().toLowerCase(),loginViewModel.getPassword());
            usernamePasswordTokentoken.setRememberMe(loginViewModel.getRemember());
            if(subject.isAuthenticated()){
                subject.logout();
            }
            try {
                subject.login(usernamePasswordTokentoken);

                //登录成功，保存用户信息
                Integer id = userService.findByEmail(loginViewModel.getEmail()).getId();
                subject.getSession().setAttribute("LOGIN_USER_ID",id);
                return RedirectTo("/movie/list");
            }catch (Exception e){
                model.addAttribute("errormsg","用户名或密码错误。");
            }
        }else{
            model.addAttribute("errors", ControllerUtil.ObjectErrorsToMap(bindingResult.getAllErrors()));
        }

        loginViewModel.setPassword("");
        return View("login",model,loginViewModel);
    }

    @GetMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            subject.logout();
        }
        return RedirectTo("/login");
    }
}
