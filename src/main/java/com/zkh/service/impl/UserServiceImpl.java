package com.zkh.service.impl;

import com.zkh.dao.UserMapper;
import com.zkh.pojo.User;
import com.zkh.pojo.UserExample;
import com.zkh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ms-zk on 2017-03-15.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByEmail(String email) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(email);
        User user = userMapper.selectByExample(userExample).get(0);
        return user;
    }
}
