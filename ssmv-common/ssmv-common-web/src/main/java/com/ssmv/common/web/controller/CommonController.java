package com.ssmv.common.web.controller;

import com.ssmv.common.service.UserService;
import com.ssmv.common.model.NameMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class CommonController {

    @Resource
    private UserService userService;

    @RequestMapping("/register/nameExist")
    @ResponseBody
    public NameMessage nameMessage(@RequestParam("username")String username){
        return userService.isExistName(username);
    }
}
