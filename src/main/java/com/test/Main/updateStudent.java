package com.test.Main;

import com.test.mapper.StudentMapper;
import com.test.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class updateStudent {
    public static void main(String[] args) throws IOException {



        Student student = new Student();
        student.setsName("新朋友");
//        student.setsAge(80);
//        student.setsSex("女");
        student.setsId(17);


//        1.加载mybatis核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        2.SqlSession获取对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        studentMapper.updateStudent(student);

        Integer id=student.getsId();

        System.out.println(student);

        sqlSession.commit();

        sqlSession.close();
    }
}
