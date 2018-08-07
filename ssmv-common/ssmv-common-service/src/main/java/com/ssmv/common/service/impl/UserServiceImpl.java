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
    public User registerExistName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public NameMessage loginExistName(String name) {
        NameMessage nameMessage = new NameMessage();
        if(name == null || name.length() == 0){
            nameMessage.setUse(false);
            nameMessage.setMessage("用户名不能为空");
        }else{
            User user = userMapper.selectByName(name);
            if(user == null){
                nameMessage.setUse(false);
                nameMessage.setMessage("用户名不正确");
            }else{
                nameMessage.setUse(false);
                nameMessage.setMessage("用户名正确");
            }
        }
        return nameMessage;
    }

}
