package com.zkh.controller;

import com.zkh.exception.CustomException;
import com.zkh.pojo.ViewModel.LoginViewModel;
import com.zkh.util.ControllerUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @RequestMapping(value = "/login",method = {RequestMethod.GET})
    public String login(HttpSession session){
        session.setAttribute("token", UUID.randomUUID().toString());
        return "login";
    }

    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public String loginSubmit(Model model,HttpSession session,String token, @Valid LoginViewModel loginViewModel, BindingResult bindingResult) throws CustomException {
        validateAntiForgeryToken(session,token);
        if(bindingResult.hasErrors()){
            loginViewModel.setPassword("");
            model.addAttribute("user",loginViewModel);
            model.addAttribute("errors", ControllerUtil.ObjectErrorsToMap(bindingResult.getAllErrors()));
            return "login";
        }

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordTokentoken = new UsernamePasswordToken(loginViewModel.getEmail().trim().toLowerCase(),loginViewModel.getPassword());
        usernamePasswordTokentoken.setRememberMe(loginViewModel.getRemember());
        try {
            subject.login(usernamePasswordTokentoken);
            return "redirect:/list.action";
        }catch (Exception e){
            model.addAttribute("user",loginViewModel);
            model.addAttribute("errormsg","用户名或密码错误。");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login.action";
    }
}
