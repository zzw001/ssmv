package com.ssmv.common.service;

import com.ssmv.common.entity.User;
import com.ssmv.common.model.NameMessage;

public interface UserService {

    int add(User user);

    NameMessage isExistName(String name);
}
