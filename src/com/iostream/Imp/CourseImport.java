/*
*   课程类，将所有课程对象放进Lsit<Course>集合，并返回
*   @2020.8.4
 *  @冯杰
*
* */

package com.iostream.Imp;
import com.ScitLiugTeam.auto_scheduling.Classroom;
import com.ScitLiugTeam.auto_scheduling.Course;
import com.conpara.ConPara;
import com.iostream.csv.ImportCourse;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class CourseImport {
    public static List<Course> getCourse() throws IOException {
        //存放课程对象
        List<Course> Courses=new ArrayList<>();
        List<Map<String,String >> list= ImportCourse.getCourse();
        for (int i = 0; i <list.size() ; i++) {
            //创建一个课程对象
            Course sumber=new Course();
            //课程名
            sumber.setCourseName(list.get(i).get("课程名"));
            //课程编号
            sumber.setID(Integer.parseInt(list.get(i).get("课程编号")));
            //课程学周时
            sumber.setWeekClassHours((int) (Integer.parseInt(list.get(i).get("周学时（h）"))));
            //总学时
            sumber.setnTotalClassGourse((int) (Integer.parseInt(list.get(i).get("总学时（h）"))));
            //课程性质
            sumber.setCourseTyoe(getTupe(list.get(i)));
            //课程资源
            sumber.setCourseNeede(getCoursRes(list.get(i)));
            //存入集合
            Courses.add(sumber);
        }
        list.clear();//释放内存
        return Courses;
    }
    //得到此课程的类型
    private static Course.CourseType getTupe(Map<String,String> Type){
        switch (Type.get("性质")){
            case "公共必修课":
               Course.CourseType one= Course.CourseType.SLT_CT_PUBCO;
               return one;
            case "公共选修课":
                Course.CourseType Tow=Course.CourseType.SLT_CT_PUBELE;
                return Tow;
            case "专业必修课":
                Course.CourseType Three=Course.CourseType.SLT_CT_PROCOM;
                return Three;
            case "专业选修课":
                Course.CourseType four=Course.CourseType.SLT_CT_PROELE;
                return four;
        }
        return null;
    }
    private static Set<Classroom.ClassroomRes> getCoursRes(Map<String,String> map){
        Set<Classroom.ClassroomRes> CourseRes=new HashSet<>();
        if(Pattern.compile("\\w*多媒体\\w*").matcher(map.get("资源")).find()){
            Classroom.ClassroomRes one=Classroom.ClassroomRes.SLT_CRES_PROJECTOR;//投影仪
            CourseRes.add(one);
        }
        if(Pattern.compile("\\w*黑板\\w*").matcher(map.get("资源")).find()){
            Classroom.ClassroomRes Tow=Classroom.ClassroomRes.SLT_CRES_BLACKBOARD;//黑板
            Classroom.ClassroomRes Three=Classroom.ClassroomRes.STL_CRES_EARASER;//黑板刷
            Classroom.ClassroomRes four=Classroom.ClassroomRes.STL_CRES_CHALK;//粉笔
            CourseRes.add(Tow);
            CourseRes.add(Three);
            CourseRes.add(four);
        }
        if(Pattern.compile("\\w*麦\\w*").matcher(map.get("资源")).find()){
            Classroom.ClassroomRes five=Classroom.ClassroomRes.SLT_CRES_SPEECH;//语音室
            CourseRes.add(five);
        }
        if(Pattern.compile("\\w*化学\\w*").matcher(map.get("资源")).find()){
            Classroom.ClassroomRes four=Classroom.ClassroomRes.SLT_CRES_CHEMISTRY;//化学实验室
            CourseRes.add(four);
        }
        if(Pattern.compile("\\w*生物\\w*").matcher(map.get("资源")).find()){
            Classroom.ClassroomRes six=Classroom.ClassroomRes.STL_CRES_BIOLOGY;//生物实验室
            CourseRes.add(six);
        }
        if(Pattern.compile("\\w*解剖\\w*").matcher(map.get("资源")).find()){
            Classroom.ClassroomRes seve=Classroom.ClassroomRes.SLT_CRES_ANATOMY;//解剖实验室
            CourseRes.add(seve);
        }
        if(Pattern.compile("\\w*物理\\w*").matcher(map.get("资源")).find()){
            Classroom.ClassroomRes nigh=Classroom.ClassroomRes.SLT_CRES_PHYLAB;//物理实验室
            CourseRes.add(nigh);
        }
        if(Pattern.compile("\\w*电脑\\w*").matcher(map.get("资源")).find()){
            Classroom.ClassroomRes Ten=Classroom.ClassroomRes.SLT_CRES_COMPUTER;//电脑机房
            CourseRes.add(Ten);
        }
        if(Pattern.compile("\\w*护理\\W*").matcher(map.get("资源")).find()) {
            Classroom.ClassroomRes Ten3 = Classroom.ClassroomRes.STL_CRES_NURSE;//护理实训室
            CourseRes.add(Ten3);
        }
        if(Pattern.compile("\\w*汽车\\W*").matcher(map.get("资源")).find()) {
            Classroom.ClassroomRes Ten4 = Classroom.ClassroomRes.STL_CRES_CAR;//汽车实训室
            CourseRes.add(Ten4);
        }
        if(Pattern.compile("\\w*机电\\W*").matcher(map.get("资源")).find()) {
            Classroom.ClassroomRes Ten5 = Classroom.ClassroomRes.STL_CRES_ELECTOR;//机电实训室
            CourseRes.add(Ten5);
        }

        return CourseRes;
    }
}
