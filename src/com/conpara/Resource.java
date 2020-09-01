/*
*  ��Դ����
*   �ȴ����õ���Դ���Ժ�����ֱ������
*   ��ϵ������
* */

package com.conpara;

import com.ScitLiugTeam.auto_scheduling.Classroom;
import com.ScitLiugTeam.auto_scheduling.Course;
import com.ScitLiugTeam.auto_scheduling.StudentClaass;
import com.ScitLiugTeam.auto_scheduling.Teacher;
import com.iostream.Imp.ClassRoomImport;
import com.iostream.Imp.CourseImport;
import com.iostream.Imp.StudentClassImport;
import com.iostream.Imp.TeacherImports;
import com.ScitLiugTeam.Realize_auto.getLsit;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Resource {
    //��ʦ����
    private List<Teacher> teacherList;
    //�γ̼���
    private List<Course> courseslist;
    //�༶����
    private List<StudentClaass> studentClaassList;
    //���Ҽ���
    private  List<Classroom>  classroomslist;

    //�γ�-->>��ʦ����
    private Map<Course,List<Teacher>> courseListteachertMap;
    //�γ�-->>����
    private Map<Course,List<Classroom>> courseListclassroomMap;
    //�༶-->>�γ�
    private Map<StudentClaass,List<Course>> studentClaassListMap;


    //�õ���ʦ����
    public List<Teacher> getTeacherList() {
        return teacherList;
    }
    //�õ����Ҽ���
    public List<Classroom> getClassroomslist() {
        return classroomslist;
    }
    //�õ��γ�
    public List<Course> getCourseslist() {
        return courseslist;
    }
    //�õ��༶����
    public List<StudentClaass> getStudentClaassList() {
        return studentClaassList;
    }
    //�õ��γ�-->���Ҽ���
    public Map<Course, List<Classroom>> getCourseListclassroomMap() {
        return courseListclassroomMap;
    }
    //�γ���ʦ
    public Map<Course,List<Teacher>> getCourseListteachertMap() {
        return courseListteachertMap;
    }
    //�༶�γ�
    public Map<StudentClaass,List<Course>> getStudentClaassListMap() {
        return studentClaassListMap;
    }
    //��ʦ,�γ̣����Ҽ��ϸ�ֵ
    public void setList() throws IOException {

//        new Thread(()->{
//            System.out.println("�γ�...");
//            try {
//                this.courseslist = CourseImport.getCourse();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(()->{
//            System.out.println("��ʦ...");
//            try {
//                this.teacherList = TeacherImports.getListTeacer();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(()->{
//            System.out.println("����...");
//            try {
//                this.classroomslist = ClassRoomImport.getClassroom();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(()->{
//            System.out.println("�༶...");
//            try {
//                Thread.sleep(1000);
//                this.studentClaassList= StudentClassImport.getStudentClass();
//            } catch (IOException | InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

        //�γ�
        System.out.println("�γ�...");
        this.courseslist = CourseImport.getCourse();
        //��ʦ
        System.out.println("��ʦ...");
        this.teacherList = TeacherImports.getListTeacer();

        System.out.println("����...");
        //����
       this.classroomslist = ClassRoomImport.getClassroom();
        //�༶
        System.out.println("�༶...");
        this.studentClaassList= StudentClassImport.getStudentClass();

    }

  //�γ�-->>���ң��γ�-->>��ʦ,�༶-->>�γ�
    public void setMap(List<Course> course,List<StudentClaass> Classes) throws IOException, InterruptedException {

        System.out.println("�༶-->>�γ�...");
        //�༶-->>�γ�
        this.studentClaassListMap =getLsit.getClasses(Classes);
        System.out.println("�γ�-->>����...");
        //�γ�-->>����
        this.courseListclassroomMap =getLsit.getCourse(course);
        System.out.println("�γ�-->>��ʦ...");
        //�γ�-->>��ʦ
        this.courseListteachertMap =getLsit.getCourseToTeacher(course);

    }


}
