package com.ssmv.common.service.impl;

import com.ssmv.common.entity.User;
import com.ssmv.common.mapper.UserMapper;
import com.ssmv.common.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int add(User user) {
        return userMapper.insert(user);
    }
}
