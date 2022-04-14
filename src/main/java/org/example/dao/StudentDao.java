package org.example.dao;

import org.example.entity.Student;

import java.util.List;

//接口操作student表
public interface StudentDao {

    //查询student表中的所有数据
    public List<Student> selectStudent();

    //插入方法，返回值int表示执行操作后影响数据库的行数
    public int insertStudent(Student student);
}
