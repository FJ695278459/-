
/*
*    ��ʦ�࣬��������ʦ����Ž�list<Teacher>���ϣ�������
*    @2020.8.4
*    @���
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

    //�õ���ʦ����Ϣ����list<Teacher>
    public static List<Teacher> getListTeacer() throws IOException {
       List<Map<String, String>> list= ImporTeacher.getTeacher();
        List<Teacher> teachers=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            //����һ����ʦ�����
            Teacher sumer=new Teacher();
            //��ȡ��ʦ�ɴ��γ̱��
            sumer.setM_mpAvaCourses(getCourseId((String)list.get(i).get("�ɴ��γ�")));
            //��ȡ��ʦ�����γ̱��
            sumer.setM_stReCourses(getCouresID((String) list.get(i).get("�����γ�")));
            //��ʦ���
            sumer.setID(Integer.parseInt(list.get(i).get("��ʦ���")));
            //��ʦ����
            sumer.setNmame((String) list.get(i).get("��ʦ����"));
            //��ʦ����
            sumer.setM_sEmployeeNum((String) list.get(i).get("��ʦ����"));
            //��ʦ����
            sumer.setTeacherTend(getTeacherTend(list.get(i)));
            sumer.setM_stSkipHours(getTeacherPhours(list.get(i)));
            //���������list����
            teachers.add(sumer);
        }
        list.clear();//�ͷ��ڴ�
        return teachers;
    }

    //�����ʦ�Ͽμ��з�ɢ��������
    private static Teacher.TeacherTend getTeacherTend(Map<String,String> map) throws IOException {
        List<Map<String,String>> list= ImportAppendTeacher.getAppend();//������Ϣ
        for (int i = 0; i <list.size() ; i++) {
            //�ҵ���Ӧ��ʦ���
            if(list.get(i).get("��ʦ���").equals(map.get("��ʦ���"))){

                switch(list.get(i).get("���з�ɢ����")){
                    case "�����ܷ�ɢ":
                        //�����ܷ�ɢ
                        Teacher.TeacherTend one=Teacher.TeacherTend.SLT_TT_SCATTER;
                        one.setTend("�����ܷ�ɢ");
                        return one;
                    case "�����ܼ���":
                        //�����ܼ���
                        Teacher.TeacherTend Tow=Teacher.TeacherTend.SLT_TT_CONCENT;//
                        Tow.setTend("�����ܼ���");
                        return Tow;
                    default:
                        //����ν
                        break;
                }
            }
        }
        //��û�о�������ν
        Teacher.TeacherTend Three= Teacher.TeacherTend.SLT_TT_UNDEF;
        Three.setTend("����ν");
        return Three;

    }
    private static Set<Teacher.SkipHours> getTeacherPhours(Map<String,String> map) throws IOException {
        List<Map<String,String>> list= ImportAppendTeacher.getAppend();//������Ϣ
        Set<Teacher.SkipHours> Phours=new HashSet<>();

        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).get("��ʦ���").equals(map.get("��ʦ���"))){
                String[] str=list.get(i).get("���Ͽ�ʱ��").split("[\\;\\��\\s]+");
                for (int j = 0; j <str.length ; j++) {
                    switch(str[j]){
                        case "��ϲ����һ�Ͽ�":
                            //����һ
                            Teacher.SkipHours one=Teacher.SkipHours.SLT_SH_MONDAY;
                            one.setPhours("��ϲ����һ�Ͽ�");
                            Phours.add(one);
                            break;
                        case "��ϲ���ܶ��Ͽ�":
                            //���ڶ�
                            Teacher.SkipHours Tow=Teacher.SkipHours.SLT_SH_TUESDAY;
                            Tow.setPhours("��ϲ�����ڶ��Ͽ�");
                            Phours.add(Tow);
                            break;
                        case "��ϲ�������Ͽ�":
                            //������
                            Teacher.SkipHours Three=Teacher.SkipHours.SLT_SH_WEDNESDAY;
                            Three.setPhours("��ϲ���������Ͽ�");
                            Phours.add(Three);
                            break;
                        case "��ϲ�������Ͽ�":
                            //������
                            Teacher.SkipHours four=Teacher.SkipHours.SLT_SH_THURSDAY;
                            four.setPhours("��ϲ�������Ͽ�");
                            Phours.add(four);
                            break;
                        case "��ϲ�������Ͽ�":
                            //������
                            Teacher.SkipHours five=Teacher.SkipHours.SLT_SH_FRIDAY;
                            five.setPhours("��ϲ�������Ͽ�");
                            Phours.add(five);
                            break;
                        case "��ϲ�������Ͽ�":
                            //������
                            Teacher.SkipHours six=Teacher.SkipHours.SLT_SH_SATURDAY;
                            six.setPhours("��ϲ�������Ͽ�");
                            Phours.add(six);
                            break;
                        case "��ϲ�������Ͽ�":
                            //����
                            Teacher.SkipHours nigh=Teacher.SkipHours.SLT_SH_NIGHT;
                            nigh.setPhours("��ϲ�������Ͽ�");
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
    //��ȡ�����γ̱�ż���
    private static Set<Integer> getCouresID(String som) throws IOException {
        //�����γ̵���Ϣ
        List<Map<String,String>> list1= ImportCourse.getCourse();
        //����γ���Ϣ
        List<Map<String,String>> list2= ImportCourseBase.getCourseBase();
        //�γ����ŵ�map
        Map<String,Integer> IdAndCourse=getmap(list1);
        //����γ�����map
        Map<String,Integer> IdAndCourseBase=getmap(list2);
        Set<Integer> num=new HashSet<>();
        //��ʦ�ĳ����������γ̣�
        String[] str=som.split("[\\;\\��\\s]+");
        for (int i = 0; i <str.length ; i++) {
            if(IdAndCourse.get(str[i])!=null) num.add(IdAndCourse.get(str[i]));
            if(IdAndCourseBase.get(str[i])!=null) num.add(IdAndCourseBase.get(str[i]));
        }
        return num;
    }


    //��ȡ�ɴ��γ̱�ż���
    private static Map<Integer,Double> getCourseId(String som) throws IOException {
        //�����γ̵���Ϣ
        List<Map<String,String>> list=ImportCourse.getCourse();
        //����γ���Ϣ
        List<Map<String,String>> list2= ImportCourseBase.getCourseBase();
        //�γ����ŵ�map
        Map<String,Integer> IdAndCourse=getmap(list);
        //����γ�����map
        Map<String,Integer> IdAndCourseBase=getmap(list2);
        Map<Integer,Double> num=new HashMap<>();
        //��ʦ�Ŀɴ����ɴ��γ̣�
        String[] str=som.split("[\\;\\��\\s]+");
        double x=1.0;//��ʦ�Ըÿγ�������i
        for (int i = 0; i <str.length ; i++) {
           if(IdAndCourse.get(str[i])!=null) num.put(IdAndCourse.get(str[i]),x);
           if(IdAndCourseBase.get(str[i])!=null) num.put(IdAndCourseBase.get(str[i]),x);
            x=x/2;
        }
        return num;
    }

    //�õ��γ����ŵ�map����
    private static Map<String,Integer> getmap(List<Map<String,String>> list){
        Map<String,Integer> map=new HashMap<>();
        for (int i = 0; i <list.size() ; i++) {
            //�γ���Ϊkeyֵ��valueΪ���
            map.put((String) list.get(i).get("�γ���"), Integer.parseInt(list.get(i).get("�γ̱��")));
        }
        return map;
    }
}
