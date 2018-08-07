package com.ssmv.common.mapper;

import com.ssmv.common.entity.User;

public interface UserMapper {

    int insert(User user);

    int update(User user1);

    User selectByName(String name);
}
