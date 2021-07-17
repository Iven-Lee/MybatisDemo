package com.Iven.sqlName;

//数据访问层

//建立数据库的实体类

//  CREATE TABLE t_users(
//
//          userId int  primary key auto_increment, #用户编号
//          userName varchar(50),    #用户名称
//          pword    varchar(50),    #用户密码
//          sex      char(1),        #用户性别 '男' 或则 '女'
//          email    varchar(50)     #用户邮箱
//    )
public class SqlName {
    //包装类，避免空指针异常
    private Integer userId;
    private String userName;
    private String pword;
    private String sex;
    private String email;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //无参构造
    public SqlName() {
    }
    //有参构造
    public SqlName(Integer userId, String userName, String pword, String sex, String email) {
        this.userId = userId;
        this.userName = userName;
        this.pword = pword;
        this.sex = sex;
        this.email = email;
    }

    @Override
    public String toString() {
        return "SqlName{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", pword='" + pword + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
