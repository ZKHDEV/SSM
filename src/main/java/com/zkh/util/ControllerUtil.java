package com.zkh.util;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ms-zk on 2017-03-14.
 */
public class ControllerUtil {
    public static Map<String,String> ObjectErrorsToMap(List<ObjectError> errors){
        Map<String,String> map = new HashMap<String, String>();
        for(ObjectError error : errors){
            map.put(((FieldError)error).getField(),error.getDefaultMessage());
        }
        return map;
    }
}
