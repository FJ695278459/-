
/*
*
*   大类课程类，将所有大类课程对象放进list<CourseBase>集合，并返回
*   @2020.8.4
*   @冯杰
* */

package com.iostream.Imp;

import com.ScitLiugTeam.auto_scheduling.Classroom;
import com.ScitLiugTeam.auto_scheduling.CourseBase;
import com.iostream.csv.ClassesRoom;
import com.iostream.csv.ImportCourseBase;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;

public class CourseBaseImport {
    public static List<CourseBase> getCourseBase() throws IOException {
        List<CourseBase> Coursebase=new ArrayList<>();
        List<Map<String, String>> list= ImportCourseBase.getCourseBase();
        for (int i = 0; i <list.size() ; i++) {
            //创建一个CourseBase对象
            CourseBase sumber=new CourseBase();
            //大类课程名
            sumber.steBaseName(list.get(i).get("课程名"));
            //大类课程编号
            sumber.setID(Integer.parseInt(list.get(i).get("课程编号")));
            //大类课程资源
            sumber.setCourseNeede(getCoursRes(list.get(i)));
            Coursebase.add(sumber);
        }
        list.clear();//释放内存
        return Coursebase;
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
