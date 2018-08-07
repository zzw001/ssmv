package com.ssmv.common.service.impl;

import com.ssmv.common.entity.User;
import com.ssmv.common.mapper.UserMapper;
import com.ssmv.common.model.NameMessage;
import com.ssmv.common.model.SignMessage;
import com.ssmv.common.service.UserService;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    @Transactional
    @Override
    public SignMessage register(User user) {
        if(user.getName() != null && user.getPassword() != null){
            if(user.getName().length() != 0 && user.getName().length() <= 10 && user.getPassword().length() != 0 && user.getPassword().length() >= 6 && userMapper.selectByName(user.getName()) == null){
                try {
                    MessageDigest md5 = MessageDigest.getInstance("MD5");
                    BASE64Encoder base64en = new BASE64Encoder();
                    user.setPassword(base64en.encode(md5.digest(user.getPassword().getBytes("utf-8"))));
                    userMapper.insert(user);
                    SignMessage signMessage = new SignMessage();
                    signMessage.setState(1);
                    signMessage.setMessage("注册成功");
                    return signMessage;
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        SignMessage signMessage = new SignMessage();
        signMessage.setState(0);
        signMessage.setMessage("注册失败");
        return signMessage;
    }

    @Override
    public SignMessage login(User user) {
        if(user.getName() != null && user.getPassword() != null){
            if(user.getName().length() != 0 && user.getName().length() <= 10 && user.getPassword().length() != 0 && user.getPassword().length() >= 6){
                try {
                    User loginUser =  userMapper.selectByName(user.getName());
                    if(loginUser != null){
                        MessageDigest md5 = MessageDigest.getInstance("MD5");
                        BASE64Encoder base64en = new BASE64Encoder();
                        if(loginUser.getPassword().equals(base64en.encode(md5.digest(user.getPassword().getBytes("utf-8"))))){
                            SignMessage signMessage = new SignMessage();
                            signMessage.setState(1);
                            signMessage.setMessage("登录成功");
                            return signMessage;
                        }
                    }
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        SignMessage signMessage = new SignMessage();
        signMessage.setState(0);
        signMessage.setMessage("用户名或密码错误");
        return signMessage;
    }
}
