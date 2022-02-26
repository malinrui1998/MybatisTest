package com.test.mapper;

import com.test.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentMapper {

    List<Student> getStudentList();

    Student selectStudentById(int id);

    List<Student> selectStudentByCondition(@Param("sName") String name, @Param("sAge") Integer age, @Param("sSex") String sex);

    List<Student> selectStudentByCondition(Student student);

    //多条件动态查询
    List<Student> selectStudentByCondition(Map map);

    //单条件动态查询
    List<Student> selectStudentByConditionSingle(Student student);

    void insertStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentById(int id);

    //    void deleteStudentByIds(@Param("ids") int[] ids);

    void deleteStudentByIds(int[] ids);
}

