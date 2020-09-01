/*
*   ���ݿ�����࣬��������Ϣ�������ݿ�
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
    //��ʦ��Ϣ
    public static void StorageTeacher(List<Teacher> list) throws ClassNotFoundException, SQLException {
        //�������ݿ�
        Class.forName(ConPara.JDBC);
        //���ݿ�·������
        String db=ConPara.CSV_PATH+ConPara.PATH_DATABASE;
        Connection conn= DriverManager.getConnection("jdbc:sqlite:"+db);
        Statement state=conn.createStatement();
        //����һ����ʦ��
        state.execute("drop table if exists teachers;");
        state.execute("create table if not exists teachers(��ʦ��� int,��ʦ���� txt,��ʦ���� txt,�ɴ��γ� txt,�����γ� txt,���зֲ����� txt,�Ͽ�ʱ�� txt);");

        PreparedStatement sql=conn.prepareStatement("insert into teachers "+"values(?,?,?,?,?,?,?)");
        for (int i = 0; i <list.size() ; i++) {
            sql.setInt(1,list.get(i).getID());//���
            sql.setString(2,list.get(i).getName());//����
            sql.setString(3,list.get(i).getm_sEmployeeNum());//����
            sql.setString(4,list.get(i).getM_mpAvaCourses().toString());//�ɴ��γ�
            sql.setString(5,list.get(i).getM_stRegCourses().toString());//�����γ�
            sql.setString(6,list.get(i).getTeacherTend().getTend());//���зֲ����
            StringBuffer sb=new StringBuffer();
            for (Teacher.SkipHours m_stSkipHour : list.get(i).getM_stSkipHours()) {
                sb.append(m_stSkipHour.getPhours()+",");
            }
            sql.setString(7,sb.toString());//���Ͽ�ʱ��
            sql.executeUpdate();
        }
        System.out.println("д��ɹ�!");
        conn.close();
        state.close();
        sql.close();
    }
    //ѧ����Ϣ
    public static void StorageStudent(List<Map<String,String>> list) throws SQLException, ClassNotFoundException {
        //�������ݿ�
        Class.forName(ConPara.JDBC);
        //���ݿ�·������
        String db=ConPara.CSV_PATH+ConPara.PATH_DATABASE;
        Connection conn= DriverManager.getConnection("jdbc:sqlite:"+db);
        Statement state=conn.createStatement();
        //����һ����ʦ��
        state.execute("drop table if exists students;");
        state.execute("create table if not exists students(���� txt,ѧ�� txt,�༶ txt,רҵ txt);");

        PreparedStatement sql=conn.prepareStatement("insert into students "+"values(?,?,?,?)");
        for (int i = 0; i <list.size() ; i++) {
            sql.setString(1,list.get(i).get("����"));
            sql.setString(2,list.get(i).get("ѧ��"));
            sql.setString(3,list.get(i).get("�༶"));
            sql.setString(4,list.get(i).get("רҵ"));
            sql.executeUpdate();
        }
        System.out.println("д��ɹ�!");
        conn.close();
        state.close();
        sql.close();
    }
    //�༶��Ϣ
    public static void StorageClasses(List<StudentClaass> list) throws SQLException, ClassNotFoundException {
        //�������ݿ�
        Class.forName(ConPara.JDBC);
        //���ݿ�·������
        String db=ConPara.CSV_PATH+ConPara.PATH_DATABASE;
        Connection conn= DriverManager.getConnection("jdbc:sqlite:"+db);
        Statement state=conn.createStatement();
        //����һ����ʦ��
        state.execute("drop table if exists classe;");
        state.execute("create table if not exists classe(�༶ txt,�༶��� txt,ѧ������ txt,רҵ txt);");

        PreparedStatement sql=conn.prepareStatement("insert into classe "+"values(?,?,?,?)");
        for (int i = 0; i <list.size() ; i++) {
            sql.setString(1,list.get(i).getClassnum());//�༶
            sql.setString(2,list.get(i).getClassID());//�༶���
            sql.setString(3,list.get(i).getNum());//ѧ������
            sql.setString(4,list.get(i).getClassname());//רҵ
            sql.executeUpdate();
        }
        System.out.println("д��ɹ�!");
        conn.close();
        state.close();
        sql.close();
    }
    //�γ�
    public static void StorageCourse(List<Course> list) throws SQLException, ClassNotFoundException {
        //�������ݿ�
        Class.forName(ConPara.JDBC);
        //���ݿ�·������
        String db=ConPara.CSV_PATH+ConPara.PATH_DATABASE;
        Connection conn= DriverManager.getConnection("jdbc:sqlite:"+db);
        Statement state=conn.createStatement();
        //����һ����ʦ��
        state.execute("drop table if exists Course;");
        state.execute("create table if not exists Course(�γ� txt,�γ̱�� int,��������γ� txt,��ѧʱ int,��ѧʱ int,���� txt,��Դ txt);");

        PreparedStatement sql=conn.prepareStatement("insert into Course "+"values(?,?,?,?,?,?,?)");
        for (int i = 0; i <list.size() ; i++) {
            sql.setString(1,list.get(i).getCourseName());//�γ�
            sql.setInt(2,list.get(i).getID());//�γ̱��
            sql.setString(3,list.get(i).getBaseName());//��������
            sql.setInt(4,list.get(i).getWeekClassHours());//��ѧʱ
            sql.setInt(5,list.get(i).getnTotalClassHourse());//��ѧʱ
            sql.setString(6,list.get(i).getCourseType().getType());//����
            StringBuffer sb=new StringBuffer();
            for (Classroom.ClassroomRes classroomRes : list.get(i).getCouresNeede()) {
                sb.append(classroomRes.getRoomRes()+",");
            }
            sql.setString(7,sb.toString());//��Դ
            sql.executeUpdate();
        }
        System.out.println("д��ɹ�!");
        conn.close();
        state.close();
        sql.close();
    }
    //����γ�
    public static void StorageCourseBase(List<CourseBase> list) throws SQLException, ClassNotFoundException {
        //�������ݿ�
        Class.forName(ConPara.JDBC);
        //���ݿ�·������
        String db=ConPara.CSV_PATH+ConPara.PATH_DATABASE;
        Connection conn= DriverManager.getConnection("jdbc:sqlite:"+db);
        Statement state=conn.createStatement();
        //����һ����ʦ��
        state.execute("drop table if exists CourseBase;");
        state.execute("create table if not exists CourseBase(�γ� txt,�γ̱�� int,��Դ txt);");

        PreparedStatement sql=conn.prepareStatement("insert into CourseBase "+"values(?,?,?)");
        for (int i = 0; i <list.size() ; i++) {
            sql.setString(1,list.get(i).getBaseName());//�γ�
            sql.setInt(2,list.get(i).getID());//�γ̱��
            StringBuffer sb=new StringBuffer();
            for (Classroom.ClassroomRes classroomRes : list.get(i).getCouresNeede()) {
                sb.append(classroomRes.getRoomRes()+",");
            }
            sql.setString(3,sb.toString());//��Դ
            sql.executeUpdate();
        }
        System.out.println("д��ɹ�!");
        conn.close();
        state.close();
        sql.close();
    }
    //����
    public static void StorageClassRoom(List<Classroom> list) throws SQLException, ClassNotFoundException {
        //�������ݿ�
        Class.forName(ConPara.JDBC);
        //���ݿ�·������
        String db=ConPara.CSV_PATH+ConPara.PATH_DATABASE;
        Connection conn= DriverManager.getConnection("jdbc:sqlite:"+db);
        Statement state=conn.createStatement();
        //����һ����ʦ��
        state.execute("drop table if exists ClassRoom;");
        state.execute("create table if not exists ClassRoom(������ txt,������ѧ���� int,���ұ�� int,��Դ txt);");

        PreparedStatement sql=conn.prepareStatement("insert into ClassRoom "+"values(?,?,?,?)");
        for (int i = 0; i <list.size() ; i++) {
            sql.setString(1,list.get(i).getM_sName());//������
            sql.setInt(2,list.get(i).getM_Studentnumber());//���ҿ�����ѧ��
            sql.setInt(3,list.get(i).getM_nID());//���ұ��
            StringBuffer sb=new StringBuffer();
            for (Classroom.ClassroomRes m_stResource : list.get(i).getM_stResources()) {
                sb.append(m_stResource.getRoomRes()+",");
            }
            sql.setString(4,sb.toString());//��Դ
            sql.executeUpdate();
        }
        System.out.println("д��ɹ�!");
        conn.close();
        state.close();
        sql.close();
    }
    //

}
