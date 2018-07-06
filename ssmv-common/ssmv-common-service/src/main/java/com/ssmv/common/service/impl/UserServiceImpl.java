package com.ssmv.common.service.impl;

import com.ssmv.common.entity.User;
import com.ssmv.common.mapper.UserMapper;
import com.ssmv.common.model.NameMessage;
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

    @Override
    public NameMessage isExistName(String name) {
        NameMessage nameMessage = new NameMessage();
        User user = userMapper.selectByName(name);
        if(user == null){
            if(name.length() >10){
                nameMessage.setUse(false);
                nameMessage.setMessage("用户名太长");
            }else{
                nameMessage.setUse(true);
                nameMessage.setMessage("用户名可以使用");
            }
        }else{
            nameMessage.setUse(false);
            nameMessage.setMessage("用户名已存在");
        }
        return nameMessage;
    }
}
