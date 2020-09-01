package com.conpara;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
*   数据常量区
*
* */

public class ConPara {
    public static final String CSV_PATH=System.getProperty("user.dir")+ File.separator+"data"+File.separator;//绝对路径
    public static final String CSV_TEACHER_FILE="teachar.csv";
    public static final String CSV_STUDENT_FILE="student.csv";
    public static final String CSV_SQILT="E:\\java_oooo\\java_HelloWorld\\scit_liug_team_pub\\auto_scheduling\\randPeopList\\student.csv";
    public static final String PATH_CSV_CLASSROOM="教室10.csv";//教室
    public static final String PATH_CSV_COURSE="课程3000.csv";//课程
    public static final String PATH_CSV_STUDENT="";//学生信息路径
    public static final String PATH_CSV_TEACHER="老师111.csv";//老师
    public static final String PATH_CSV_COURSEBASE="大类课程10.csv";//大类课程
    public static final String PATH_APPEND_TEACHER="附加要求2.csv";//附加要求
    public static final String PATH_CSV_MAJOR="专业名称.csv";//专业名称
    public static final String PATH_STUDENT_CLASS="班级名单10000.csv";//班级名单
    public static final String PATH_DATABASE="shujuk.db";//数据
    public static final String JDBC="org.sqlite.JDBC";//驱动名字
    public static final Resource RES=new Resource();//资源，教室集合.班级，课程，各种关系


    static {
        //教室集合.班级，课程
        try {
            System.out.println("导入资源中:list");
            RES.setList();
        } catch (IOException e) {
            System.out.println("list资源解析错误！");
            e.printStackTrace();
        }
        try {
            System.out.println("导入资源中:map");
            RES.setMap(RES.getCourseslist(),RES.getStudentClaassList());
            System.out.println("导入成功！");
        } catch (IOException | InterruptedException e) {
            System.out.println("Map资源解析错误！");
            e.printStackTrace();
        }

    }

    public static   Set<String> TimecRoom=new HashSet<>();//用于判断班级之间时间教室是否重复
    public static   Set<String> set=new HashSet<>();//用于存放一个班级的上课时间段
    public static   Set<String> Teagche=new HashSet<>();//用于判断老师是否在同一时间上俩堂课
    public static   StringBuilder sb1=new StringBuilder();//一个班级的一个课程的01
    public static  StringBuffer sb=new StringBuffer();//s所有班级的01


  public static  StringBuffer sb01=new StringBuffer();//存储二进制，存储所有课时的01编码
   public static StringBuffer Tmp=new StringBuffer();//临时，存储一个课时的01编码

    public static  byte[] bits1=new byte[11];//班级编码
    public static  byte[] bits2=new byte[4];//课程编码
    public static  byte[] bits3=new byte[6];//老师编码
    public static  byte[] byte10=new byte[1];//单双周
    public static  byte[] bytes1=new byte[6];//6天
    public static  byte[] bytes2=new byte[5];//5课时
    public static  byte[] bytes3=new byte[10];//教室

    public static final int CLASSES_NUMBIT=bits1.length;//班级编码长度
    public static final int COURSE_NUMBIT=bits2.length;//课程编码长度
    public static final int WEEK_NUMBIT=bytes1.length;//星期
    public static final int TIMEDAY_NUMBIT=bytes2.length;//上课时段
    public static final int TWOORONE_BUMBIT=byte10.length;//单双周
    public static final int ROOM_NUMBIT=bytes3.length;//教室
    public static final int TIME_ROOM_NUMBIT=23;//上课时间加教室
    public static final int TEACHER_NUMBIT=bits3.length;//老师编码长度


    public static final int NUM=100;//种群个体个数
    public static final int NRXTNUM=5000;//迭代次数

}
