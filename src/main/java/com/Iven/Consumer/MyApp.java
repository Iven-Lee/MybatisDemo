package com.Iven.Consumer;


import com.Iven.dao.StudentDao;
import com.Iven.sqlName.SqlName;
import com.Iven.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp {

    public static void main(String[] args) throws IOException {

        //方法一：传统dao方式
        /*
            //访问mybatis读取student数据
            //1.定义mybatis主配置文件的名称, 从类路径的根开始（target/clasess）
            String config="mybatis.xml";
            //2.读取这个config表示的文件
            InputStream in = Resources.getResourceAsStream(config);
            //3.创建了SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder builder  = new SqlSessionFactoryBuilder();
            //4.创建SqlSessionFactory对象
            SqlSessionFactory factory = builder.build(in);
            //5.获取SqlSession对象，从SqlSessionFactory中获取SqlSession
            SqlSession sqlSession = factory.openSession();
            //6.【重要】指定要执行的sql语句的标识。  sql映射文件中的namespace + "." + 标签的id值
            //String sqlId = "com.Iven.dao.StudentDao" + "." + "selectStudents";
            String sqlId = "com.Iven.dao.StudentDao.selectStudents";
            //7. 重要】执行sql语句，通过sqlId找到语句
            List<SqlName> studentList = sqlSession.selectList(sqlId);
            //8.输出结果
            //studentList.forEach( stu -> System.out.println(stu));
            for(Student stu : studentList){
                System.out.println("查询的学生="+stu);
            }
            //9.关闭SqlSession对象
            sqlSession.close();
        */

        //方法二：对传统的dao方式封装
        /*
            SqlSession sqlSession = MyBatisUtils.getSqlSession();

            //【重要】指定要执行的sql语句的标识。  sql映射文件中的namespace + "." + 标签的id值
            String sqlId = "com.Iven.dao.StudentDao.insertStudent";;
            //【重要】执行sql语句，通过sqlId找到语句
            SqlName sqlName = new SqlName();
            sqlName.setUserId(2);
            sqlName.setUserName("张飞");
            sqlName.setPword("456");
            sqlName.setSex("男");
            sqlName.setEmail("zhangF@qq.com");
            int res = sqlSession.insert(sqlId,sqlName);
            //mybatis默认不是自动提交事务，所以在insert、update、delete后要手动提交事务
            sqlSession.commit();
            //输出insert结果
            System.out.println("结果是：" + res);


            //【重要】指定要执行的sql语句的标识。  sql映射文件中的namespace + "." + 标签的id值
            String sqlIdq = "com.Iven.dao.StudentDao.selectStudents";
            //【重要】执行sql语句，通过sqlId找到语句
            List<SqlName> studentList = sqlSession.selectList(sqlIdq);
            //输出结果
            studentList.forEach( stu -> System.out.println(stu));


            //关闭SqlSession对象
            sqlSession.close();
        */


        //方法二：代理对象方法执行SQL
        //通过JDBC与AOP动态代理相结合实现对JDBC的增强
        //获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //动态代理获取其接口类
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //【重要】执行sql语句，通过sqlId找到语句
        SqlName sqlName = new SqlName();
        sqlName.setUserId(3);
        sqlName.setUserName("zhangF");
        sqlName.setPword("678");
        sqlName.setSex("男");
        sqlName.setEmail("zhangF@qq.com");
        int res = dao.insertStudent(sqlName);
        //mybatis默认不是自动提交事务，所以在insert、update、delete后要手动提交事务
        sqlSession.commit();
        //输出insert结果
        System.out.println("结果是：" + res);



        //【重要】执行sql语句，通过sqlId找到语句
        List<SqlName> studentList = dao.selectStudents();
        //输出结果
        studentList.forEach( stu -> System.out.println(stu));


        //关闭SqlSession对象
        sqlSession.close();

    }

}
