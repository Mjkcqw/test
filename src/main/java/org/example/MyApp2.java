package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.Student;
import org.example.util.MyBatisUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp2 {
    public static void main(String[] args) throws IOException {

        //获取SqlSession对象，这一步是固定的
        SqlSession sqlSession= MyBatisUtil.getSqlSession();

        //指定要执行的sql语句的标识，值为sql映射文件中的namespace+"."+标签的id值
        String sqlId="org.example.dao.StudentDao.insertStudent";
        //执行sql语句，通过sqlId找到语句
        Student student=new Student(1005,"刘备","liubei@163.com",20);
        int num=sqlSession.insert(sqlId,student);
        //输出结果
        System.out.println("执行insert的结果："+num);
        //关闭SqlSession对象
        sqlSession.close();
    }
}
