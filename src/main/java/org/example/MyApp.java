package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp {
    public static void main(String[] args) throws IOException {
        /*
        //访问MyBatis读取student数据
        //1.定义MyBatis主配置文件的名称，从类路径根开始，也就是target/classes后
        String config="MyBatis.xml";
        //2.读取这个config表示的文件
        InputStream in= Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory=builder.build(in);
        //5.重要，获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession=factory.openSession();
        //6.重要，指定要执行的sql语句的标识，值为sql映射文件中的namespace+"."+标签的id值
        String sqlId="org.example.dao.StudentDao"+"."+"selectStudent";
        //7.执行sql语句，通过sqlId找到语句
        List<Student> studentList=sqlSession.selectList(sqlId);
        //8.输出结果
        for(Student stu:studentList)
            System.out.println(stu.getId()+" "+stu.getName()+" "+stu.getEmail()+" "+stu.getAge());
        //9.关闭SqlSession对象
        sqlSession.close();

         */

        //访问MyBatis读取student数据
        //1.定义MyBatis主配置文件的名称，从类路径根开始，也就是target/classes后
        String config="MyBatis.xml";
        //2.读取这个config表示的文件
        InputStream in= Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory=builder.build(in);
        //5.重要，获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession=factory.openSession(true);

        //6.重要，指定要执行的sql语句的标识，值为sql映射文件中的namespace+"."+标签的id值
        String sqlId="org.example.dao.StudentDao.insertStudent";
        //7.执行sql语句，通过sqlId找到语句
        Student student=new Student(1004,"刘备","liubei@163.com",20);
        int num=sqlSession.insert(sqlId,student);

        //8.输出结果
        System.out.println("执行insert的结果："+num);
        System.out.println(123);
        //9.关闭SqlSession对象
        sqlSession.close();
    }
}
