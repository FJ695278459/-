/*
*   �õ��γ̣��༶�����ң���ʦ����
*   �γ�-->>��ʦ���γ�-->>��ʦ,�༶-->>�γ�
*    �����ûʲô�ã������õ�
*   @���
*   @2020/8/19
* */

package com.ScitLiugTeam.Realize_auto;

import com.ScitLiugTeam.auto_scheduling.Classroom;
import com.ScitLiugTeam.auto_scheduling.Course;
import com.ScitLiugTeam.auto_scheduling.StudentClaass;
import com.ScitLiugTeam.auto_scheduling.Teacher;
import com.conpara.ConPara;
import com.iostream.Imp.CourseImport;

import java.io.IOException;
import java.util.*;
import java.util.Map;

public class getList2 {
   public static void getsd(){
       List<StudentClaass> studentClaassList= ConPara.RES.getStudentClaassList();
       List<Course> courseslist=ConPara.RES.getCourseslist();

   }
   public static void getdi(){
       List<Course> courseList=ConPara.RES.getCourseslist();
       Map<Course,List<Teacher>> courseListMap=ConPara.RES.getCourseListteachertMap();
       for (Course course : courseList) {
//        if(courseListMap.get(course).size()==0){
            System.out.println(course.getCourseName()+"-->>"+course.getID()+"-->>"+"�ÿγ̿����ϵ���ʦ������"+courseListMap.get(course).size());

//        }
      }
   }
   public static void getdoi(){
       List<Course> courseList=ConPara.RES.getCourseslist();
       Map<Course,List<Classroom>> courseListMap=ConPara.RES.getCourseListclassroomMap();
       for (Course course : courseList) {
          if(courseListMap.get(course).size()==0){
              System.out.println(course.getCourseName()+"-->>"+course.getID());
          }
       }
   }
   //����ÿ����һ��Ҫ�ϵĿ�
    public static void getTime(){
        List<StudentClaass> studentClaassList= ConPara.RES.getStudentClaassList();
        List<Course> courseslist=ConPara.RES.getCourseslist();
        int a=0;
        Map<StudentClaass,List<Course>> studentClaassListMap=ConPara.RES.getStudentClaassListMap();
        for (StudentClaass studentClaass : studentClaassList) {
            for (Course course : studentClaassListMap.get(studentClaass)) {
               a+=course.getWeekClassHours();
            }
            System.out.println(studentClaass.getClassname()+"-->>"+studentClaass.getClassnum()+"-->>"+studentClaass.getClassID()+"-->>һ��Ҫ�ϵĿ�ʱ��"+a);
            a=0;
        }
    }
}
