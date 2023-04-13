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
       /* user.setUserName("bob");
        user.setPassword("123");
        user.setAge(12);
        user.setGender("男");
        user.setEmail("123456@qq.com");
        int i = mapper.insertUser(user);*/
        int i = mapper.insertUserV1();
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
        User userById = mapper.getUserById();
        System.out.println(userById);
        sqlSession.close();
    }
}
