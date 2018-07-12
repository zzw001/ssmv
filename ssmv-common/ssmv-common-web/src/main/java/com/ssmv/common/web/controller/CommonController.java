package com.ssmv.common.web.controller;

import com.ssmv.common.entity.User;
import com.ssmv.common.model.SignMessage;
import com.ssmv.common.service.UserService;
import com.ssmv.common.model.NameMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.UUID;

@Controller
public class CommonController {

    @Resource
    private UserService userService;

    @RequestMapping("/register/nameExist")
    @ResponseBody
    public NameMessage registerNameExist(@RequestParam("username")String username){
        return userService.registerExistName(username);
    }

    @RequestMapping("/login/nameExist")
    @ResponseBody
    public NameMessage loginNameExist(@RequestParam("username")String username){
        return userService.loginExistName(username);
    }

    @RequestMapping(value = "/register",method = { RequestMethod.POST })
    @ResponseBody
    public SignMessage register(@RequestParam(value = "username",required = false)String username,@RequestParam(value = "password",required = false)String password){
        User user = new User();
        user.setUuid(UUID.randomUUID().toString());
        user.setName(username);
        user.setPassword(password);
        return userService.register(user);
    }

    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    @ResponseBody
    public SignMessage login(@RequestParam(value = "username",required = false)String username,@RequestParam(value = "password",required = false)String password){
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        return userService.login(user);
    }
}
