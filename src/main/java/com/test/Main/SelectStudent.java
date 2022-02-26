package com.test.Main;

import com.test.mapper.StudentMapper;
import com.test.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SelectStudent {

    public static void main(String[] args) throws IOException {

        int id = 34;


        String s_name="吴";
        Integer s_age=30;
        String s_sex="女";

        s_name ="%"+s_name+"%";


        Student student = new Student();
//        student.setsName(s_name);
//        student.setsAge(s_age);
//        student.setsSex(s_sex);

        Map map = new HashMap<>();
        map.put("sName",s_name);
        map.put("sAge",s_age);
        map.put("sSex",s_sex);

//        1.加载mybatis核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        2.SqlSession获取对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);


//        List <Student> students =studentMapper.getStudentList();

//        Student students=studentMapper.selectStudentById(id);

        //散装方式封装参数（多个参数需要@Param）
//        List <Student> students =studentMapper.selectStudentByCondition(s_name,s_age,s_sex);

        //集合方式封装参数
//        List <Student> students =studentMapper.selectStudentByCondition(student);

        //map集合参数
//        List<Student> students = studentMapper.selectStudentByCondition(map);

//        List<Student> students = studentMapper.selectStudentByConditionSingle(student);

//        System.out.println(students);

        sqlSession.close();
    }


}
