package com.ssmv.common.service;

import com.ssmv.common.entity.User;
import com.ssmv.common.model.NameMessage;
import com.ssmv.common.model.SignMessage;

public interface UserService {

    int add(User user);

    NameMessage registerExistName(String name);

    NameMessage loginExistName(String name);

    SignMessage register(User user);

    SignMessage login(User user);
}
