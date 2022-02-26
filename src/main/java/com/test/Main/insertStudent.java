package com.test.Main;

import com.test.mapper.StudentMapper;
import com.test.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class insertStudent {

    public static void main(String[] args) throws IOException {

        String sName = "周杰伦";
        Integer sAge = 40;
        String sSex = "男";

        Student student = new Student();
        student.setsName(sName);
        student.setsAge(sAge);
        student.setsSex(sSex);

//        1.加载mybatis核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        2.SqlSession获取对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        studentMapper.insertStudent(student);

        Integer id=student.getsId();

        System.out.println(id);

        sqlSession.commit();

        sqlSession.close();
    }
}
