package com.zkh.controller;

import com.zkh.exception.CustomException;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpSession;

/**
 * Created by ms-zk on 2017-03-16.
 */
public class BaseController {

    /**
     * 验证表单令牌
     * @param session
     * @param token
     * @throws CustomException
     */
    protected void validateAntiForgeryToken(HttpSession session,String token) throws CustomException {
        Object realToken = session.getAttribute("token");
        session.setAttribute("token",null);
        if(realToken == null || !realToken.toString().equals(token)) throw new CustomException("操作异常！");
    }
}
