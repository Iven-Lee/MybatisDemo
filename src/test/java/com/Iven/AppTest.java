package com.Iven;

import static org.junit.Assert.assertTrue;

import com.Iven.ParamDemo.QueryParam;
import com.Iven.dao.StudentDao;
import com.Iven.sqlName.SqlName;
import com.Iven.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    /**
     *  传入一个或多个简单类型的参数：
     *  简单类型： mybatis把java的基本数据类型和String都叫简单类型。
     */
    @Test
    public void testSelectMultiPosition(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);



        List<SqlName> students = dao. selectMultiParam("李四","123");

        for(SqlName stu: students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }
    /**
     *  使用java对象(QueryParam对象)作为接口中方法的参数
     */
    @Test
    public void testSelectMultiObject(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        QueryParam param = new QueryParam();
        param.setParamName("张三");
        param.setParamPass("123");
        List<SqlName> students = dao.selectMultiObject(param);

        for(SqlName stu: students){
            System.out.println("学生="+stu);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectStudentWhere(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao  =  sqlSession.getMapper(StudentDao.class);

        QueryParam param = new QueryParam();
        //student.setName("李四");
        //student.setAge(18);
        List<SqlName> students = dao.selectStudentWhere(param);
        for(SqlName stu:students){
            System.out.println("where==="+stu);
        }
    }
}
