package com.zkh.controller;

import com.zkh.exception.CustomException;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpSession;

/**
 * Created by ms-zk on 2017-03-16.
 */
public class BaseController {
    protected void validateAntiForgeryToken(HttpSession session,String token) throws CustomException {
        Object realToken = session.getAttribute("token");
        session.setAttribute("token",null);
        if(realToken == null || !realToken.toString().equals(token)) throw new CustomException("操作异常！");
    }
}
