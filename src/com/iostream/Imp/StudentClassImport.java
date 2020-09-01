
/*
*   �༶����
*   ÿ���༶����Ϣ
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
        List<StudentClaass> Studencalss=new ArrayList<>();//�༶
        List<Map<String ,String>> list= ImpStudentClass.getStudentClass();
        for (int i = 0; i <list.size() ; i++) {
            StudentClaass claass=new StudentClaass();
            //רҵ
            claass.setClassname(list.get(i).get("רҵ"));
            //�༶���
            claass.setClassID(list.get(i).get("�༶���"));
            //ѧ������
            claass.setNum(list.get(i).get("ѧ������"));
            //�༶
            claass.setClassnum(list.get(i).get("�༶"));
            //�γ�
            claass.setCourse(getcoursLsit(list.get(i)));
            Studencalss.add(claass);
        }
        list.clear();//�ͷ��ڴ�
        return Studencalss;
    }
    public static String getcoursLsit(Map<String,String> map) throws IOException {

        List<Course> list2 = ConPara.RES.getCourseslist();
        StringBuffer sb = new StringBuffer();
        for (Course course : list2) {
            if(map.get("�γ�").contains(course.getCourseName())){
                sb.append(course.getCourseName());
            }
        }
        return sb.toString();
    }

}
