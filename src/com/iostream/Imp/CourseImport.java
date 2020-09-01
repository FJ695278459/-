/*
*   �γ��࣬�����пγ̶���Ž�Lsit<Course>���ϣ�������
*   @2020.8.4
 *  @���
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
        //��ſγ̶���
        List<Course> Courses=new ArrayList<>();
        List<Map<String,String >> list= ImportCourse.getCourse();
        for (int i = 0; i <list.size() ; i++) {
            //����һ���γ̶���
            Course sumber=new Course();
            //�γ���
            sumber.setCourseName(list.get(i).get("�γ���"));
            //�γ̱��
            sumber.setID(Integer.parseInt(list.get(i).get("�γ̱��")));
            //�γ�ѧ��ʱ
            sumber.setWeekClassHours((int) (Integer.parseInt(list.get(i).get("��ѧʱ��h��"))));
            //��ѧʱ
            sumber.setnTotalClassGourse((int) (Integer.parseInt(list.get(i).get("��ѧʱ��h��"))));
            //�γ�����
            sumber.setCourseTyoe(getTupe(list.get(i)));
            //�γ���Դ
            sumber.setCourseNeede(getCoursRes(list.get(i)));
            //���뼯��
            Courses.add(sumber);
        }
        list.clear();//�ͷ��ڴ�
        return Courses;
    }
    //�õ��˿γ̵�����
    private static Course.CourseType getTupe(Map<String,String> Type){
        switch (Type.get("����")){
            case "�������޿�":
               Course.CourseType one= Course.CourseType.SLT_CT_PUBCO;
               return one;
            case "����ѡ�޿�":
                Course.CourseType Tow=Course.CourseType.SLT_CT_PUBELE;
                return Tow;
            case "רҵ���޿�":
                Course.CourseType Three=Course.CourseType.SLT_CT_PROCOM;
                return Three;
            case "רҵѡ�޿�":
                Course.CourseType four=Course.CourseType.SLT_CT_PROELE;
                return four;
        }
        return null;
    }
    private static Set<Classroom.ClassroomRes> getCoursRes(Map<String,String> map){
        Set<Classroom.ClassroomRes> CourseRes=new HashSet<>();
        if(Pattern.compile("\\w*��ý��\\w*").matcher(map.get("��Դ")).find()){
            Classroom.ClassroomRes one=Classroom.ClassroomRes.SLT_CRES_PROJECTOR;//ͶӰ��
            CourseRes.add(one);
        }
        if(Pattern.compile("\\w*�ڰ�\\w*").matcher(map.get("��Դ")).find()){
            Classroom.ClassroomRes Tow=Classroom.ClassroomRes.SLT_CRES_BLACKBOARD;//�ڰ�
            Classroom.ClassroomRes Three=Classroom.ClassroomRes.STL_CRES_EARASER;//�ڰ�ˢ
            Classroom.ClassroomRes four=Classroom.ClassroomRes.STL_CRES_CHALK;//�۱�
            CourseRes.add(Tow);
            CourseRes.add(Three);
            CourseRes.add(four);
        }
        if(Pattern.compile("\\w*��\\w*").matcher(map.get("��Դ")).find()){
            Classroom.ClassroomRes five=Classroom.ClassroomRes.SLT_CRES_SPEECH;//������
            CourseRes.add(five);
        }
        if(Pattern.compile("\\w*��ѧ\\w*").matcher(map.get("��Դ")).find()){
            Classroom.ClassroomRes four=Classroom.ClassroomRes.SLT_CRES_CHEMISTRY;//��ѧʵ����
            CourseRes.add(four);
        }
        if(Pattern.compile("\\w*����\\w*").matcher(map.get("��Դ")).find()){
            Classroom.ClassroomRes six=Classroom.ClassroomRes.STL_CRES_BIOLOGY;//����ʵ����
            CourseRes.add(six);
        }
        if(Pattern.compile("\\w*����\\w*").matcher(map.get("��Դ")).find()){
            Classroom.ClassroomRes seve=Classroom.ClassroomRes.SLT_CRES_ANATOMY;//����ʵ����
            CourseRes.add(seve);
        }
        if(Pattern.compile("\\w*����\\w*").matcher(map.get("��Դ")).find()){
            Classroom.ClassroomRes nigh=Classroom.ClassroomRes.SLT_CRES_PHYLAB;//����ʵ����
            CourseRes.add(nigh);
        }
        if(Pattern.compile("\\w*����\\w*").matcher(map.get("��Դ")).find()){
            Classroom.ClassroomRes Ten=Classroom.ClassroomRes.SLT_CRES_COMPUTER;//���Ի���
            CourseRes.add(Ten);
        }
        if(Pattern.compile("\\w*����\\W*").matcher(map.get("��Դ")).find()) {
            Classroom.ClassroomRes Ten3 = Classroom.ClassroomRes.STL_CRES_NURSE;//����ʵѵ��
            CourseRes.add(Ten3);
        }
        if(Pattern.compile("\\w*����\\W*").matcher(map.get("��Դ")).find()) {
            Classroom.ClassroomRes Ten4 = Classroom.ClassroomRes.STL_CRES_CAR;//����ʵѵ��
            CourseRes.add(Ten4);
        }
        if(Pattern.compile("\\w*����\\W*").matcher(map.get("��Դ")).find()) {
            Classroom.ClassroomRes Ten5 = Classroom.ClassroomRes.STL_CRES_ELECTOR;//����ʵѵ��
            CourseRes.add(Ten5);
        }

        return CourseRes;
    }
}