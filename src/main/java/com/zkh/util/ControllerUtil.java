package com.zkh.util;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制器工具类
 */
public class ControllerUtil {
    /**
     * 转换错误信息为Map
     * @param errors 错误信息List
     * @return
     */
    public static Map<String,String> ObjectErrorsToMap(List<ObjectError> errors){
        Map<String,String> map = new HashMap<String, String>();
        for(ObjectError error : errors){
            map.put(((FieldError)error).getField(),error.getDefaultMessage());
        }
        return map;
    }
}
