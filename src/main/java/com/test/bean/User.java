package com.test.bean;

import com.test.dao.TestMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

public class User {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        DIV userTest = (DIV) applicationContext.getBean("userTest");
        userTest.div(1,1);
        Parent p = new Parent();
//        Child c = (Child) p;
//        c.sayhello2();
//        IIopImpl iIopImpl2 = new IIopImpl();
//        IIop2 iIop =  iIopImpl2;
//        IIop iIop1 = iIopImpl2;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        TestMapper mapper = session.getMapper(TestMapper.class);
        SysTask sysTask = mapper.selectBlog(29883);
        System.out.println(sysTask);

    }

}
