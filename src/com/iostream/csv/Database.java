/*
*   数据库操作类，将所有信息存入数据库
*   FJ@--2020/8/14
*
*
* */
package com.iostream.csv;

import com.ScitLiugTeam.auto_scheduling.*;
import com.conpara.ConPara;

import java.sql.*;

import java.util.List;
import java.util.Map;

public class Database {
    //老师信息
    public static void StorageTeacher(List<Teacher> list) throws ClassNotFoundException, SQLException {
        //连接数据库
        Class.forName(ConPara.JDBC);
        //数据库路径名字
        String db=ConPara.CSV_PATH+ConPara.PATH_DATABASE;
        Connection conn= DriverManager.getConnection("jdbc:sqlite:"+db);
        Statement state=conn.createStatement();
        //创建一个老师表
        state.execute("drop table if exists teachers;");
        state.execute("create table if not exists teachers(老师编号 int,老师姓名 txt,老师工号 txt,可带课程 txt,常带课程 txt,集中分布倾向 txt,上课时段 txt);");

        PreparedStatement sql=conn.prepareStatement("insert into teachers "+"values(?,?,?,?,?,?,?)");
        for (int i = 0; i <list.size() ; i++) {
            sql.setInt(1,list.get(i).getID());//编号
            sql.setString(2,list.get(i).getName());//名字
            sql.setString(3,list.get(i).getm_sEmployeeNum());//工号
            sql.setString(4,list.get(i).getM_mpAvaCourses().toString());//可带课程
            sql.setString(5,list.get(i).getM_stRegCourses().toString());//常带课程
            sql.setString(6,list.get(i).getTeacherTend().getTend());//集中分布情况
            StringBuffer sb=new StringBuffer();
            for (Teacher.SkipHours m_stSkipHour : list.get(i).getM_stSkipHours()) {
                sb.append(m_stSkipHour.getPhours()+",");
            }
            sql.setString(7,sb.toString());//不上课时段
            sql.executeUpdate();
        }
        System.out.println("写入成功!");
        conn.close();
        state.close();
        sql.close();
    }
    //学生信息
    public static void StorageStudent(List<Map<String,String>> list) throws SQLException, ClassNotFoundException {
        //连接数据库
        Class.forName(ConPara.JDBC);
        //数据库路径名字
        String db=ConPara.CSV_PATH+ConPara.PATH_DATABASE;
        Connection conn= DriverManager.getConnection("jdbc:sqlite:"+db);
        Statement state=conn.createStatement();
        //创建一个老师表
        state.execute("drop table if exists students;");
        state.execute("create table if not exists students(名字 txt,学号 txt,班级 txt,专业 txt);");

        PreparedStatement sql=conn.prepareStatement("insert into students "+"values(?,?,?,?)");
        for (int i = 0; i <list.size() ; i++) {
            sql.setString(1,list.get(i).get("名字"));
            sql.setString(2,list.get(i).get("学号"));
            sql.setString(3,list.get(i).get("班级"));
            sql.setString(4,list.get(i).get("专业"));
            sql.executeUpdate();
        }
        System.out.println("写入成功!");
        conn.close();
        state.close();
        sql.close();
    }
    //班级信息
    public static void StorageClasses(List<StudentClaass> list) throws SQLException, ClassNotFoundException {
        //连接数据库
        Class.forName(ConPara.JDBC);
        //数据库路径名字
        String db=ConPara.CSV_PATH+ConPara.PATH_DATABASE;
        Connection conn= DriverManager.getConnection("jdbc:sqlite:"+db);
        Statement state=conn.createStatement();
        //创建一个老师表
        state.execute("drop table if exists classe;");
        state.execute("create table if not exists classe(班级 txt,班级编号 txt,学生人数 txt,专业 txt);");

        PreparedStatement sql=conn.prepareStatement("insert into classe "+"values(?,?,?,?)");
        for (int i = 0; i <list.size() ; i++) {
            sql.setString(1,list.get(i).getClassnum());//班级
            sql.setString(2,list.get(i).getClassID());//班级编号
            sql.setString(3,list.get(i).getNum());//学生人数
            sql.setString(4,list.get(i).getClassname());//专业
            sql.executeUpdate();
        }
        System.out.println("写入成功!");
        conn.close();
        state.close();
        sql.close();
    }
    //课程
    public static void StorageCourse(List<Course> list) throws SQLException, ClassNotFoundException {
        //连接数据库
        Class.forName(ConPara.JDBC);
        //数据库路径名字
        String db=ConPara.CSV_PATH+ConPara.PATH_DATABASE;
        Connection conn= DriverManager.getConnection("jdbc:sqlite:"+db);
        Statement state=conn.createStatement();
        //创建一个老师表
        state.execute("drop table if exists Course;");
        state.execute("create table if not exists Course(课程 txt,课程编号 int,所属大类课程 txt,周学时 int,总学时 int,性质 txt,资源 txt);");

        PreparedStatement sql=conn.prepareStatement("insert into Course "+"values(?,?,?,?,?,?,?)");
        for (int i = 0; i <list.size() ; i++) {
            sql.setString(1,list.get(i).getCourseName());//课程
            sql.setInt(2,list.get(i).getID());//课程编号
            sql.setString(3,list.get(i).getBaseName());//所属大类
            sql.setInt(4,list.get(i).getWeekClassHours());//周学时
            sql.setInt(5,list.get(i).getnTotalClassHourse());//总学时
            sql.setString(6,list.get(i).getCourseType().getType());//性质
            StringBuffer sb=new StringBuffer();
            for (Classroom.ClassroomRes classroomRes : list.get(i).getCouresNeede()) {
                sb.append(classroomRes.getRoomRes()+",");
            }
            sql.setString(7,sb.toString());//资源
            sql.executeUpdate();
        }
        System.out.println("写入成功!");
        conn.close();
        state.close();
        sql.close();
    }
    //大类课程
    public static void StorageCourseBase(List<CourseBase> list) throws SQLException, ClassNotFoundException {
        //连接数据库
        Class.forName(ConPara.JDBC);
        //数据库路径名字
        String db=ConPara.CSV_PATH+ConPara.PATH_DATABASE;
        Connection conn= DriverManager.getConnection("jdbc:sqlite:"+db);
        Statement state=conn.createStatement();
        //创建一个老师表
        state.execute("drop table if exists CourseBase;");
        state.execute("create table if not exists CourseBase(课程 txt,课程编号 int,资源 txt);");

        PreparedStatement sql=conn.prepareStatement("insert into CourseBase "+"values(?,?,?)");
        for (int i = 0; i <list.size() ; i++) {
            sql.setString(1,list.get(i).getBaseName());//课程
            sql.setInt(2,list.get(i).getID());//课程编号
            StringBuffer sb=new StringBuffer();
            for (Classroom.ClassroomRes classroomRes : list.get(i).getCouresNeede()) {
                sb.append(classroomRes.getRoomRes()+",");
            }
            sql.setString(3,sb.toString());//资源
            sql.executeUpdate();
        }
        System.out.println("写入成功!");
        conn.close();
        state.close();
        sql.close();
    }
    //教室
    public static void StorageClassRoom(List<Classroom> list) throws SQLException, ClassNotFoundException {
        //连接数据库
        Class.forName(ConPara.JDBC);
        //数据库路径名字
        String db=ConPara.CSV_PATH+ConPara.PATH_DATABASE;
        Connection conn= DriverManager.getConnection("jdbc:sqlite:"+db);
        Statement state=conn.createStatement();
        //创建一个老师表
        state.execute("drop table if exists ClassRoom;");
        state.execute("create table if not exists ClassRoom(教室名 txt,可容纳学生数 int,教室编号 int,资源 txt);");

        PreparedStatement sql=conn.prepareStatement("insert into ClassRoom "+"values(?,?,?,?)");
        for (int i = 0; i <list.size() ; i++) {
            sql.setString(1,list.get(i).getM_sName());//教室名
            sql.setInt(2,list.get(i).getM_Studentnumber());//教室可容纳学生
            sql.setInt(3,list.get(i).getM_nID());//教室编号
            StringBuffer sb=new StringBuffer();
            for (Classroom.ClassroomRes m_stResource : list.get(i).getM_stResources()) {
                sb.append(m_stResource.getRoomRes()+",");
            }
            sql.setString(4,sb.toString());//资源
            sql.executeUpdate();
        }
        System.out.println("写入成功!");
        conn.close();
        state.close();
        sql.close();
    }
    //

}
