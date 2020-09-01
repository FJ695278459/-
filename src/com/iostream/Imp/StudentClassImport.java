
/*
*   班级名单
*   每个班级的信息
* */

package com.iostream.Imp;

import com.ScitLiugTeam.auto_scheduling.Course;
import com.ScitLiugTeam.auto_scheduling.StudentClaass;
import com.iostream.csv.ImpStudentClass;
import com.conpara.*;

import javax.swing.plaf.synth.SynthRadioButtonUI;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class StudentClassImport {
    public static List<StudentClaass> getStudentClass() throws IOException {
        List<StudentClaass> Studencalss=new ArrayList<>();//班级
        List<Map<String ,String>> list= ImpStudentClass.getStudentClass();
        for (int i = 0; i <list.size() ; i++) {
            StudentClaass claass=new StudentClaass();
            //专业
            claass.setClassname(list.get(i).get("专业"));
            //班级编号
            claass.setClassID(list.get(i).get("班级编号"));
            //学生人数
            claass.setNum(list.get(i).get("学生人数"));
            //班级
            claass.setClassnum(list.get(i).get("班级"));
            //课程
            claass.setCourse(getcoursLsit(list.get(i)));
            Studencalss.add(claass);
        }
        list.clear();//释放内存
        return Studencalss;
    }
    public static String getcoursLsit(Map<String,String> map) throws IOException {

        List<Course> list2 = ConPara.RES.getCourseslist();
        StringBuffer sb = new StringBuffer();
        for (Course course : list2) {
            if(map.get("课程").contains(course.getCourseName())){
                sb.append(course.getCourseName());
            }
        }
        return sb.toString();
    }

}
