
/*
*    老师类，将所有老师对象放进list<Teacher>集合，并返回
*    @2020.8.4
*    @冯杰
*
* */

package com.iostream.Imp;

import com.ScitLiugTeam.auto_scheduling.Teacher;
import com.iostream.csv.ImporTeacher;
import com.iostream.csv.ImportAppendTeacher;
import com.iostream.csv.ImportCourse;
import com.iostream.csv.ImportCourseBase;

import java.io.IOException;
import java.util.*;

public class TeacherImports {

    //得到老师类信息集合list<Teacher>
    public static List<Teacher> getListTeacer() throws IOException {
       List<Map<String, String>> list= ImporTeacher.getTeacher();
        List<Teacher> teachers=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            //创建一个老师类对象
            Teacher sumer=new Teacher();
            //获取老师可带课程编号
            sumer.setM_mpAvaCourses(getCourseId((String)list.get(i).get("可带课程")));
            //获取老师常带课程编号
            sumer.setM_stReCourses(getCouresID((String) list.get(i).get("常带课程")));
            //老师编号
            sumer.setID(Integer.parseInt(list.get(i).get("老师编号")));
            //老师姓名
            sumer.setNmame((String) list.get(i).get("老师姓名"));
            //老师工号
            sumer.setM_sEmployeeNum((String) list.get(i).get("老师工号"));
            //老师倾向
            sumer.setTeacherTend(getTeacherTend(list.get(i)));
            sumer.setM_stSkipHours(getTeacherPhours(list.get(i)));
            //将对象放入list集合
            teachers.add(sumer);
        }
        list.clear();//释放内存
        return teachers;
    }

    //获得老师上课集中分散倾向倾向
    private static Teacher.TeacherTend getTeacherTend(Map<String,String> map) throws IOException {
        List<Map<String,String>> list= ImportAppendTeacher.getAppend();//附加信息
        for (int i = 0; i <list.size() ; i++) {
            //找到对应老师编号
            if(list.get(i).get("老师编号").equals(map.get("老师编号"))){

                switch(list.get(i).get("集中分散倾向")){
                    case "尽可能分散":
                        //尽可能分散
                        Teacher.TeacherTend one=Teacher.TeacherTend.SLT_TT_SCATTER;
                        one.setTend("尽可能分散");
                        return one;
                    case "尽可能集中":
                        //尽可能集中
                        Teacher.TeacherTend Tow=Teacher.TeacherTend.SLT_TT_CONCENT;//
                        Tow.setTend("尽可能集中");
                        return Tow;
                    default:
                        //无所谓
                        break;
                }
            }
        }
        //都没有就是无所谓
        Teacher.TeacherTend Three= Teacher.TeacherTend.SLT_TT_UNDEF;
        Three.setTend("无所谓");
        return Three;

    }
    private static Set<Teacher.SkipHours> getTeacherPhours(Map<String,String> map) throws IOException {
        List<Map<String,String>> list= ImportAppendTeacher.getAppend();//附加信息
        Set<Teacher.SkipHours> Phours=new HashSet<>();

        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).get("老师编号").equals(map.get("老师编号"))){
                String[] str=list.get(i).get("不上课时段").split("[\\;\\；\\s]+");
                for (int j = 0; j <str.length ; j++) {
                    switch(str[j]){
                        case "不喜欢周一上课":
                            //星期一
                            Teacher.SkipHours one=Teacher.SkipHours.SLT_SH_MONDAY;
                            one.setPhours("不喜欢周一上课");
                            Phours.add(one);
                            break;
                        case "不喜欢周二上课":
                            //星期二
                            Teacher.SkipHours Tow=Teacher.SkipHours.SLT_SH_TUESDAY;
                            Tow.setPhours("不喜欢星期二上课");
                            Phours.add(Tow);
                            break;
                        case "不喜欢周三上课":
                            //星期三
                            Teacher.SkipHours Three=Teacher.SkipHours.SLT_SH_WEDNESDAY;
                            Three.setPhours("不喜欢星期三上课");
                            Phours.add(Three);
                            break;
                        case "不喜欢周四上课":
                            //星期四
                            Teacher.SkipHours four=Teacher.SkipHours.SLT_SH_THURSDAY;
                            four.setPhours("不喜欢周四上课");
                            Phours.add(four);
                            break;
                        case "不喜欢周五上课":
                            //星期五
                            Teacher.SkipHours five=Teacher.SkipHours.SLT_SH_FRIDAY;
                            five.setPhours("不喜欢周五上课");
                            Phours.add(five);
                            break;
                        case "不喜欢周六上课":
                            //星期六
                            Teacher.SkipHours six=Teacher.SkipHours.SLT_SH_SATURDAY;
                            six.setPhours("不喜欢周六上课");
                            Phours.add(six);
                            break;
                        case "不喜欢晚上上课":
                            //晚上
                            Teacher.SkipHours nigh=Teacher.SkipHours.SLT_SH_NIGHT;
                            nigh.setPhours("不喜欢晚上上课");
                            Phours.add(nigh);
                            break;
                        default:
                            Teacher.SkipHours Ten=Teacher.SkipHours.SLT_SH_UNDEF;
                            Phours.add(Ten);
                            return Phours;
                    }
                }
            }
        }
        return Phours;
    }
    //获取常带课程编号集合
    private static Set<Integer> getCouresID(String som) throws IOException {
        //整个课程的信息
        List<Map<String,String>> list1= ImportCourse.getCourse();
        //大类课程信息
        List<Map<String,String>> list2= ImportCourseBase.getCourseBase();
        //课程与编号的map
        Map<String,Integer> IdAndCourse=getmap(list1);
        //大类课程与编号map
        Map<String,Integer> IdAndCourseBase=getmap(list2);
        Set<Integer> num=new HashSet<>();
        //老师的常带（常带课程）
        String[] str=som.split("[\\;\\；\\s]+");
        for (int i = 0; i <str.length ; i++) {
            if(IdAndCourse.get(str[i])!=null) num.add(IdAndCourse.get(str[i]));
            if(IdAndCourseBase.get(str[i])!=null) num.add(IdAndCourseBase.get(str[i]));
        }
        return num;
    }


    //获取可带课程编号集合
    private static Map<Integer,Double> getCourseId(String som) throws IOException {
        //整个课程的信息
        List<Map<String,String>> list=ImportCourse.getCourse();
        //大类课程信息
        List<Map<String,String>> list2= ImportCourseBase.getCourseBase();
        //课程与编号的map
        Map<String,Integer> IdAndCourse=getmap(list);
        //大类课程与编号map
        Map<String,Integer> IdAndCourseBase=getmap(list2);
        Map<Integer,Double> num=new HashMap<>();
        //老师的可带（可带课程）
        String[] str=som.split("[\\;\\；\\s]+");
        double x=1.0;//老师对该课程熟练度i
        for (int i = 0; i <str.length ; i++) {
           if(IdAndCourse.get(str[i])!=null) num.put(IdAndCourse.get(str[i]),x);
           if(IdAndCourseBase.get(str[i])!=null) num.put(IdAndCourseBase.get(str[i]),x);
            x=x/2;
        }
        return num;
    }

    //得到课程与编号的map容器
    private static Map<String,Integer> getmap(List<Map<String,String>> list){
        Map<String,Integer> map=new HashMap<>();
        for (int i = 0; i <list.size() ; i++) {
            //课程名为key值，value为编号
            map.put((String) list.get(i).get("课程名"), Integer.parseInt(list.get(i).get("课程编号")));
        }
        return map;
    }
}
