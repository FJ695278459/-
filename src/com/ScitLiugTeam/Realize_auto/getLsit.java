/*
*    得到老师，课程，教室，老师，集合关系
*   得到
*   老师--->课程list
*   课程-->教室list
*   班级--->课程list
*   课程-->老师list
*
* */
package com.ScitLiugTeam.Realize_auto;

import com.ScitLiugTeam.auto_scheduling.Classroom;
import com.ScitLiugTeam.auto_scheduling.Course;
import com.ScitLiugTeam.auto_scheduling.StudentClaass;
import com.ScitLiugTeam.auto_scheduling.Teacher;
import com.conpara.ConPara;
import com.iostream.Imp.ClassRoomImport;
import com.iostream.Imp.CourseImport;
import com.iostream.Imp.TeacherImports;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class getLsit {




    //课程---》教室
    public static Map<Course,List<Classroom>> getCourse(List<Course> course) throws IOException {
        //教室
        List<Classroom> list2= ConPara.RES.getClassroomslist();
        Map<Course,List<Classroom>> map= new HashMap<>();
        for (Course course1 : course) {
            List<Classroom> Cls=new ArrayList<>();
            for (Classroom classroom : list2) {
               if(classroom.getM_stResources().equals(course1.getCouresNeede())){
                   Cls.add(classroom);
               }
            }
            map.put(course1,Cls);
        }
        return map;
    }
    //课程————》老师
    public static Map<Course, List<Teacher>> getCourseToTeacher(List<Course> course) throws IOException {
        List<Teacher> list= ConPara.RES.getTeacherList();
        Map<Course,List<Teacher>> map=new HashMap<>();
        for (Course course1 : course) {
            List<Teacher> tea=new ArrayList<>();
            for (Teacher teacher : list) {
                 if(teacher.getM_mpAvaCourses().containsKey(course1.getID())){
                     tea.add(teacher);
                 }
            }
            map.put(course1,tea);
        }
        return map;
    }
    //班级--》课程
    public static Map<StudentClaass, List<Course>> getClasses(List<StudentClaass> classes) throws IOException {
        List<Course> list=ConPara.RES.getCourseslist();
        Map<StudentClaass,List<Course>> map=new HashMap<>();
        for (StudentClaass aClass : classes) {
            List<Course> cou=new ArrayList<>();
            for (Course course : list) {
                if(aClass.getCourse().contains(course.getCourseName())){
                    cou.add(course);
                }
            }
            map.put(aClass,cou);
        }
        return map;
    }
//    //得到该班级可上的课程
//    public static Map<Integer,Course> integerCourseMap(StudentClaass studentClaass){
//        Map<Integer,Course> map=ConPara.RES.getCourseslist();
//        Map<Integer, Course> map1=new HashMap<>();
//
//        for (Integer integer : map.keySet()) {
//            if(studentClaass.getCourse().contains(map.get(integer).getCourseName())){
//                map1.put(integer,map.get(integer));
//            }
//        }
//        return map1;
//
//    }
//
//    //得到某课程可上的教室集合
//    public static Map<Integer,Classroom> integerClassroomMap(Course course) {
////        Map<Integer, Classroom> map1 = ConPara.RES.getCourseListclassroomMap().get(course);
//        Map<Integer,Classroom> map1=new HashMap<>();
//        Map<Integer,Classroom> map=ConPara.RES.getClassroomslist();
//
//        for (Integer integer : map.keySet()) {
//           if(course.getCouresNeede().equals(map.get(integer).getM_stResources())){
//               map1.put(integer,map.get(integer));
//           }
//      }
//        return map1;
//    }
//    //得到某课程可上课的老师
//    public static Map<Integer,Teacher> integerTeacherMap(Course course){
////        Map<Integer,Teacher> map1=ConPara.RES.getCourseListteachertMap().get(course);
//
//        Map<Integer,Teacher> map=ConPara.RES.getTeacherList();
//
//        Map<Integer,Teacher> map1= new HashMap<>();
//
//        for (Integer integer : map.keySet()) {
//            Set<Integer> set=map.get(integer).getM_stRegCourses();
//            for (Integer integer2 : set) {
//                if(integer2==course.getID()){
//                    //       System.out.println(course.get(integer).getCourseName()+"-->>"+course.get(integer).getID()+"-->>"+list.get(integer1).getName()+"-->>"+list.get(integer1).getID());
//                    map1.put(integer,map.get(integer));
//                    break;
//                }
//            }
//        }
//        return map1;
//    }
}
