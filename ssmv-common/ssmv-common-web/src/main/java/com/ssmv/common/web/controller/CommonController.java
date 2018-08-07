package com.ssmv.common.web.controller;

import com.ssmv.common.entity.User;
import com.ssmv.common.model.SignMessage;
import com.ssmv.common.service.UserService;
import com.ssmv.common.model.NameMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@Controller
public class CommonController {

    @Resource
    private UserService userService;

    @RequestMapping("/register/nameExist")
    @ResponseBody
    public ResponseEntity<User> registerNameExist(@RequestParam("username")String username){
        User user = userService.registerExistName(username);
        HttpStatus status = user != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(user,status);
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
