package com.Iven.dao;


import com.Iven.ParamDemo.QueryParam;
import com.Iven.sqlName.SqlName;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//操作t_users数据表
public interface StudentDao {
    //查询student表的所有的数据
    public List<SqlName> selectStudents();

    //插入方法
    //参数： student ,表示要插入到数据库的数据
    //返回值： int ， 表示执行insert操作后的 影响数据库的行数
    public int insertStudent(SqlName sqlName);



    /**
     *  test文件中AppTest.java中测试
     *  传入一个或多个简单类型的参数：
     *  简单类型： mybatis把java的基本数据类型和String都叫简单类型。
     *  在mapper文件获取简单类型的一个参数的值，使用 #{任意字符}
     *  方法：命名参数，在形参定义的前面加入 @Param("自定义参数名称")
     */
     List<SqlName> selectMultiParam(@Param("myname") String name,
                                   @Param("mypass") String pass);


    /**
     *  test文件中AppTest.java中测试
     *  使用java对象(QueryParam对象)作为接口中方法的参数
     *  在mapper文件获取简单类型的一个参数的值，使用 #{任意字符}
     */
    List<SqlName> selectMultiObject(QueryParam param);


    /**
     *  test文件中AppTest.java中测试
     *  动态sql ，使用java对象作为参数
     *  mybatis提供标签：
     *  -----<if>:判断条件，即<if:test="使用参数java对象的属性值作为判断条件，语法 属性=XXX值">
     *  -----<where>:用来包含多个<if>，即： <where> <if> <if>...</where>
     *  -----<foreach>:对数组与集合遍历，foreach使用： List<Integer>
     *
     *  SQL代码片段的复用（xml文件中）
     *  1、先定义<sql id = "自定义名称唯一">sql语句等</sql>
     *  2、再使用<include refid = "id值"></>
     *
     * //where使用
     */
    List<SqlName> selectStudentWhere(QueryParam param);
}
