/*
*
*   教室资源类，将所有的教室对象存放进list<Classroom>集合
*    @2020.8.4
*    @冯杰
* */

package com.iostream.Imp;

import com.ScitLiugTeam.auto_scheduling.Classroom;
import com.iostream.csv.ClassesRoom;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class ClassRoomImport {
    public static List<Classroom> getClassroom() throws IOException {
        List<Classroom> ClassRooms=new ArrayList<>();
        List<Map<String,String>> list= ClassesRoom.getClassesRoom();
        for (int i = 0; i <list.size() ; i++) {
            //new一个教室对象
            Classroom sumber=new Classroom();
            //教室编号
            sumber.setM_nID(Integer.parseInt(list.get(i).get("教室编号")));
            //教室名字
            sumber.setM_sName(list.get(i).get("教室ID"));
            //教室最大容量
            sumber.setM_Studentnumber(Integer.parseInt(list.get(i).get("教室可容纳学生")));
            //教室资源
           sumber.setM_stResources(getroomRes(list.get(i)));
            //存入集合
            ClassRooms.add(sumber);
        }
        list.clear();//释放内存
        return ClassRooms;
    }
    private static Set<Classroom.ClassroomRes> getroomRes(Map<String,String> map)  throws IOException {
        Set<Classroom.ClassroomRes> roomres=new HashSet<>();
        List<Map<String,String>> list=ClassesRoom.getClassesRoom();
        if(Pattern.compile("\\w*黑板\\w*").matcher(map.get("资源")).find()){
            Classroom.ClassroomRes Tow=Classroom.ClassroomRes.SLT_CRES_BLACKBOARD;//黑板
            Classroom.ClassroomRes four=Classroom.ClassroomRes.STL_CRES_CHALK;//粉笔
            Classroom.ClassroomRes Three=Classroom.ClassroomRes.STL_CRES_EARASER;//黑板擦
            roomres.add(Three);
            roomres.add(four);
            roomres.add(Tow);
        }
           if(Pattern.compile("\\w*语音\\w*").matcher(map.get("资源")).find()) {
               Classroom.ClassroomRes five = Classroom.ClassroomRes.SLT_CRES_SPEECH;//语音室
               roomres.add(five);
           }
        if(Pattern.compile("\\w*电脑\\w*").matcher(map.get("资源")).find()) {
            Classroom.ClassroomRes six = Classroom.ClassroomRes.SLT_CRES_COMPUTER;//电脑机房
            roomres.add(six);
        }
        if(Pattern.compile("\\w*物理\\w*").matcher(map.get("资源")).find()) {
            Classroom.ClassroomRes seven = Classroom.ClassroomRes.SLT_CRES_PHYLAB;//物理实验室
            roomres.add(seven);
        }
        if(Pattern.compile("\\w*多媒体\\W*").matcher(map.get("资源")).find()) {
            Classroom.ClassroomRes nigh = Classroom.ClassroomRes.SLT_CRES_PROJECTOR;//投影仪
            roomres.add(nigh);
        }
        if(Pattern.compile("\\w*化学\\W*").matcher(map.get("资源")).find()) {
            Classroom.ClassroomRes Ten = Classroom.ClassroomRes.SLT_CRES_CHEMISTRY;//化学实验室
            roomres.add(Ten);
        }
        if(Pattern.compile("\\w*解剖\\W*").matcher(map.get("资源")).find()) {
            Classroom.ClassroomRes Ten1 = Classroom.ClassroomRes.SLT_CRES_ANATOMY;//医学解剖室
            roomres.add(Ten1);
        }
        if(Pattern.compile("\\w*生物\\W*").matcher(map.get("资源")).find()) {
            Classroom.ClassroomRes Ten2 = Classroom.ClassroomRes.STL_CRES_BIOLOGY;//生物实验室
            roomres.add(Ten2);
        }
        if(Pattern.compile("\\w*护理\\W*").matcher(map.get("资源")).find()) {
            Classroom.ClassroomRes Ten3 = Classroom.ClassroomRes.STL_CRES_NURSE;//护理实训室
            roomres.add(Ten3);
        }
        if(Pattern.compile("\\w*汽车\\W*").matcher(map.get("资源")).find()) {
            Classroom.ClassroomRes Ten4 = Classroom.ClassroomRes.STL_CRES_CAR;//汽车实训室
            roomres.add(Ten4);
        }
        if(Pattern.compile("\\w*机电\\W*").matcher(map.get("资源")).find()) {
            Classroom.ClassroomRes Ten5 = Classroom.ClassroomRes.STL_CRES_ELECTOR;//机电实训室
            roomres.add(Ten5);
        }
        return roomres;
    }
}
