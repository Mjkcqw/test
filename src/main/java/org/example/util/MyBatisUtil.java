package org.example.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private  static SqlSessionFactory factory=null;
    static{
        String config="MyBatis.xml";//这个需要和映射文件名称相同
        try{
            InputStream in= Resources.getResourceAsStream(config);
            //创建SqlSessionFactory对象，使用SqlSessionFactoryBuild
            factory =new SqlSessionFactoryBuilder().build(in);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //获取SqlSession的方法
    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        if(factory!=null){
            sqlSession=factory.openSession(true);//自动提交事务
        }
        return sqlSession;
    }
}
