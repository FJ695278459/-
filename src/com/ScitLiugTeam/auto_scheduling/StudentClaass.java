/*
*  �༶�����������༶��Ϣ
* */
package com.ScitLiugTeam.auto_scheduling;

import java.awt.*;
import java.util.List;
import java.util.Set;

public class StudentClaass {
    private String ClassID;//�༶���
    private String Classname;//����רҵ
    private String num;//�༶ѧ����
    private String Classnum;//1`x�༶
    private String course;//�γ�
    //רҵthi
    public String getClassname() {
        return Classname;
    }
    public void setClassname(String classname) {
        Classname = classname;
    }
    //���
    public void setClassID(String classID) {
        ClassID = classID;
    }
    public String getClassID() {
        return ClassID;
    }

    //x�༶
    public String getClassnum() {
        return Classnum;
    }
    public void setClassnum(String classnum) {
        Classnum = classnum;
    }
    //ѧ����
    public void setNum(String num) {
        this.num = num;
    }
    public String getNum() {
        return num;
    }
    //�γ�
    public  String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
}
