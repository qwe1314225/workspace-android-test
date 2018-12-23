package com.zxyoyo.hosition.login_mvp.login;

import java.io.Serializable;

/**
 * time:2018/12/22
 * email:2024212718@qq.com
 * author:hosition
 * website:www.zxyoyo.com
 * -----------------------
 * function describe:
 * 用户信息实体类
 **/
public class User implements Serializable {
   private String  name;// 姓名
   private String  age;// 年龄
   private String  sex;// 性别
   private String  describe;//描述
   private String  mobile;//手机号

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
