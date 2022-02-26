package com.test.Main;

import com.test.mapper.StudentMapper;
import com.test.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class deleteStudent {

    public static void main(String[] args) throws IOException {

//        int id =16;

        int[] ids = {36,39,41};
//        1.加载mybatis核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        2.SqlSession获取对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

//        studentMapper.deleteStudentById(id);
        studentMapper.deleteStudentByIds(ids);
        sqlSession.commit();

        sqlSession.close();
    }
}
