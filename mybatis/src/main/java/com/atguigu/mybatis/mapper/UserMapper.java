package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

public interface UserMapper {
    int insertUser(User user);


    int insertUserV1();

    int updateUser();
    int deleteUser();

    User getUserById();
}
