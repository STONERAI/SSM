package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    @Test
    public void testInsert() throws IOException {
        //获取核心配置文件流
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = build.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
//        user.setId(1);
        user.setUserName("bob");
        user.setPassword("123");
        user.setAge(12);
        user.setGender("0");
        user.setEmail("123456@qq.com");
        int i = mapper.insertUser(user);
//        int i = mapper.insertUserV1();
        System.out.println(i);
        //sqlSession需要手动提交
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        int i = mapper.updateUser();
//        System.out.println(i);
//        User userById = mapper.getUserById();
        User userByUsername = mapper.getUserByUsername("root");
        List<User> users = mapper.getUsers();
        for(User user: users){
            System.out.println(user);
        }
        System.out.println(userByUsername);
        System.out.println("==============");
        Map<String, Object> userMap = mapper.getUserMap();
//        System.out.println(userMap);
//        User o = (User)userMap.get(1);
//        Integer age = o.getAge();
//        System.out.println(age);
        Map<String, Object> userMapById = mapper.getUserMapById(1);
        List<Map<String, Object>> userMaps = mapper.getUserMaps();
//        List<User> t_user = mapper.getUserByTableName("t");
        User user = new User(null, "tony", "789", 12, "1", "345@33.outlook");
        int i = mapper.insertUserV11(user);
        System.out.println(user);

        sqlSession.close();
    }
}
