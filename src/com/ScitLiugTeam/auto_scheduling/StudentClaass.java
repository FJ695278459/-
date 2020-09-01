/*
*  班级名单，包含班级信息
* */
package com.ScitLiugTeam.auto_scheduling;

import java.awt.*;
import java.util.List;
import java.util.Set;

public class StudentClaass {
    private String ClassID;//班级编号
    private String Classname;//所属专业
    private String num;//班级学生数
    private String Classnum;//1`x班级
    private String course;//课程
    //专业thi
    public String getClassname() {
        return Classname;
    }
    public void setClassname(String classname) {
        Classname = classname;
    }
    //编号
    public void setClassID(String classID) {
        ClassID = classID;
    }
    public String getClassID() {
        return ClassID;
    }

    //x班级
    public String getClassnum() {
        return Classnum;
    }
    public void setClassnum(String classnum) {
        Classnum = classnum;
    }
    //学生数
    public void setNum(String num) {
        this.num = num;
    }
    public String getNum() {
        return num;
    }
    //课程
    public  String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
}
