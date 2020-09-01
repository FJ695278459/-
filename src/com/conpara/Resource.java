/*
*  资源管理
*   先创建得到资源，以后想拿直接来用
*   关系各种类
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
    //老师集合
    private List<Teacher> teacherList;
    //课程集合
    private List<Course> courseslist;
    //班级集合
    private List<StudentClaass> studentClaassList;
    //教室集合
    private  List<Classroom>  classroomslist;

    //课程-->>老师集合
    private Map<Course,List<Teacher>> courseListteachertMap;
    //课程-->>教室
    private Map<Course,List<Classroom>> courseListclassroomMap;
    //班级-->>课程
    private Map<StudentClaass,List<Course>> studentClaassListMap;


    //得到老师集合
    public List<Teacher> getTeacherList() {
        return teacherList;
    }
    //得到教室集合
    public List<Classroom> getClassroomslist() {
        return classroomslist;
    }
    //得到课程
    public List<Course> getCourseslist() {
        return courseslist;
    }
    //得到班级集合
    public List<StudentClaass> getStudentClaassList() {
        return studentClaassList;
    }
    //得到课程-->教室集合
    public Map<Course, List<Classroom>> getCourseListclassroomMap() {
        return courseListclassroomMap;
    }
    //课程老师
    public Map<Course,List<Teacher>> getCourseListteachertMap() {
        return courseListteachertMap;
    }
    //班级课程
    public Map<StudentClaass,List<Course>> getStudentClaassListMap() {
        return studentClaassListMap;
    }
    //老师,课程，教室集合赋值
    public void setList() throws IOException {

//        new Thread(()->{
//            System.out.println("课程...");
//            try {
//                this.courseslist = CourseImport.getCourse();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(()->{
//            System.out.println("老师...");
//            try {
//                this.teacherList = TeacherImports.getListTeacer();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(()->{
//            System.out.println("教室...");
//            try {
//                this.classroomslist = ClassRoomImport.getClassroom();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(()->{
//            System.out.println("班级...");
//            try {
//                Thread.sleep(1000);
//                this.studentClaassList= StudentClassImport.getStudentClass();
//            } catch (IOException | InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

        //课程
        System.out.println("课程...");
        this.courseslist = CourseImport.getCourse();
        //老师
        System.out.println("老师...");
        this.teacherList = TeacherImports.getListTeacer();

        System.out.println("教室...");
        //教室
       this.classroomslist = ClassRoomImport.getClassroom();
        //班级
        System.out.println("班级...");
        this.studentClaassList= StudentClassImport.getStudentClass();

    }

  //课程-->>教室，课程-->>老师,班级-->>课程
    public void setMap(List<Course> course,List<StudentClaass> Classes) throws IOException, InterruptedException {

        System.out.println("班级-->>课程...");
        //班级-->>课程
        this.studentClaassListMap =getLsit.getClasses(Classes);
        System.out.println("课程-->>教室...");
        //课程-->>教室
        this.courseListclassroomMap =getLsit.getCourse(course);
        System.out.println("课程-->>老师...");
        //课程-->>老师
        this.courseListteachertMap =getLsit.getCourseToTeacher(course);

    }


}
