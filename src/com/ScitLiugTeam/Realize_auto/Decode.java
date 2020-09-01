/*
*
*   解码，将课表解码
*   @冯杰
*   @2020/8/15
*   班级编码+课程编码+老师编码+课时*(是否单双周+上课时段+教室编码)=原子码
* */

package com.ScitLiugTeam.Realize_auto;

import com.ScitLiugTeam.auto_scheduling.*;
import com.conpara.ConPara;
import com.iostream.Imp.StudentClassImport;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Decode {

    //编码：班级编码+课程编码+老师编码+教室编码+是否单双周+上课时段=原子码
    public static void DecodeLesson(Individual vial) throws IOException {
        Bits bits = vial.getBits();
        int being = 0;
        int end = ConPara.CLASSES_NUMBIT;

        List<StudentClaass> studentClaassList = ConPara.RES.getStudentClaassList();
        Map<StudentClaass, List<Course>> studentClaassListMap = ConPara.RES.getStudentClaassListMap();
        Map<Course, List<Classroom>> courseRoomListMap = ConPara.RES.getCourseListclassroomMap();
        Map<Course, List<Teacher>> courseTeacherListMap = ConPara.RES.getCourseListteachertMap();

        int classes;//班级
        int course;//课程
        int teachsr;//老师
        int Tow = 0;//单双周
        int Week = 0;//星期
        int DayTime = 0;//一天的时段
        int Room;//教室
        System.out.println("二进制长度：-->>" + bits.length());

        for (int num=end; num<=bits.length() ;being+=ConPara.ROOM_NUMBIT,end+=ConPara.CLASSES_NUMBIT, num=end) {

//          System.out.println("班级:"+being+"-->>"+end);
            classes=bits.getValue(being, end);

            StudentClaass studentClaass=studentClaassList.get(classes);
            System.out.println("\n\n班级："+studentClaass.getClassname()+"--->>"+studentClaass.getClassnum()+"--->>"+studentClaass.getClassID());
            List<Course> courseLists=studentClaassListMap.get(studentClaass);

            for (int i = 0; i < courseLists.size(); i++) {
                if(i==0) {
                    //一个课程时段
                    being+=ConPara.CLASSES_NUMBIT;
                    end+=ConPara.COURSE_NUMBIT;
                }else{
                    //第二次是从教室后开始加
                    being+=ConPara.ROOM_NUMBIT;
                    end+=ConPara.COURSE_NUMBIT;
                }

//                System.out.println("课程："+being+"-->>"+end);
                course=bits.getValue(being, end);

                //课程越界
                if(course>=courseLists.size()){
                    System.out.println("课程越界！");
                    return;
                }
                //课程
                Course course1=courseLists.get(course);

                //老师集合
                List<Teacher> teacherList=courseTeacherListMap.get(course1);
                //教室集合
                List<Classroom> classroomList=courseRoomListMap.get(course1);

                being+=ConPara.COURSE_NUMBIT;
                end+=ConPara.TEACHER_NUMBIT;
//                System.out.println("老师："+being+"-->>"+end);
                teachsr=bits.getValue(being, end);
                //老师越界
                if(teachsr>=teacherList.size()){
                    System.out.println("老师越界！");
                    return;
                }

                //老师
                Teacher teacher=teacherList.get(teachsr);
                System.out.println("课程："+course1.getCourseName()+"--->>"+course1.getID()+"--->>上课老师："+teacher.getName()+"-->>"+teacher.getID());
                //周学时
                for (int i1 = 0; i1 < course1.getWeekClassHours(); i1++) {
                    if(i1==0) {
                        //一个课时段
                        being+=ConPara.TEACHER_NUMBIT;
                        end+=ConPara.TWOORONE_BUMBIT;
                    }else{
                        //第二次是从教室后开始加
                        being+=ConPara.ROOM_NUMBIT;
                        end+=ConPara.TWOORONE_BUMBIT;
                    }
//                    System.out.println("单双周："+being+"-->>"+end);
                    //单双周
                    Tow=bits.getNp(being);

                    being+=ConPara.TWOORONE_BUMBIT;
                    end+=ConPara.WEEK_NUMBIT;
//                    System.out.println("星期："+being+"-->>"+end);
                    //星期
                    for (int j = being,a=1; j <end ;a++, j++) {
                        if(bits.getNp(j)==1){
                            Week=a;
                        }
                    }

                    //时段
                    being+=ConPara.WEEK_NUMBIT;
                    end+=ConPara.TIMEDAY_NUMBIT;
//                    System.out.println("时段："+being+"-->>"+end);
                    for (int j = being,a=1; j <end ;a++, j++) {
                        if(bits.getNp(j)==1){
                            DayTime=a;
                        }
                    }

                    //教室
                    being+=ConPara.TIMEDAY_NUMBIT;
                    end+=ConPara.ROOM_NUMBIT;
//                    System.out.println("教室："+being+"-->>"+end);
                    Room=bits.getValue(being, end);
                    if(Room>=classroomList.size()){
                        System.out.println("教室越界！");
                        return;
                    }

                    Classroom classroom=classroomList.get(Room);
                    System.out.println("上课时间教室："+"星期"+Week+"-->>第"+DayTime+"时段:--->>教室"+classroom.getM_sName()+"-->>"+classroom.getM_nID());


                }
            }

        }
    }
}
