package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int insertUser(User user);


    int insertUserV1();

    int updateUser();
    int deleteUser();

    User getUserById();

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    List<User> getUsers();

    @MapKey("id") //表示以id作为key值
    Map<String, Object> getUserMap();

    Map<String, Object> getUserMapById(@Param("id")Integer id);

    List<Map<String, Object>> getUserMaps();

    List<User> getUserByTableName(@Param("tableName")String tableName);

    int insertUserV11(User user);
}
