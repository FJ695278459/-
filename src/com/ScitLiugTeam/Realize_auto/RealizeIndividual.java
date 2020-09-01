/*
*   ����
*   @���
*   2020/8/19
*
* */

package com.ScitLiugTeam.Realize_auto;

import com.ScitLiugTeam.auto_scheduling.*;
import com.conpara.ConPara;

import java.io.IOException;
import java.util.*;

public class RealizeIndividual implements Individual {
    private double fitness=0;//������Ӧ��
    private double score=0;   //������ʼΪ0
    private  Bits bits=new RealizeBits();//�����Ʊ���
    //�����ʼ��


    //��ֵ��Ӧ��
    public void setFitness(double fitness) {

    }

    //��ȡ��Ӧ��
    public double getFitness() {
        return fitness;
    }



    public  Bits getBits() {
        return bits;
    }

    @Override
    public void randInitialize() {
        String str="";
        try {
            str=Coding.Total();
        } catch (IOException e) {
            System.out.println("�������");
            e.printStackTrace();
        }
        bits.newBits(str.length());
        bits.fromString(str);
        score();
        str=null;
    }

    //��������һ������
    @Override
    public void copyFrom(Individual ind) {
        bits.fromString(TurnBitsAndString.getStringToArresByte(ind.getBits().getM_bits()));
    }

    //�жϱ����������Ľ��Ƿ�Ϸ����Ϸ�����true�����Ϸ�false
    @Override
    public boolean isLegal() {
        return false;
    }

    //��������ĳ���
    @Override
    public int length() {
        return bits.length();
    }

    //�������������Ϊ����Ľ�
    @Override
    public Solution decode() {
        return null;
    }

    //��ʼ���������֡����ǳ��Ĵ��
    @Override
    public void score() {
        score=0;
        int being = 0;
        int end = ConPara.CLASSES_NUMBIT;
        Vector<Integer> tmp=new Vector<>();

        List<StudentClaass> studentClaassList = ConPara.RES.getStudentClaassList();
        Map<StudentClaass, List<Course>> studentClaassListMap = ConPara.RES.getStudentClaassListMap();
        Map<Course, List<Classroom>> courseRoomListMap = ConPara.RES.getCourseListclassroomMap();
        Map<Course, List<Teacher>> courseTeacherListMap = ConPara.RES.getCourseListteachertMap();
        int classes;//�༶
        int course;//�γ�
        int teachsr;//��ʦ
        int Tow = 0;//��˫��
        int Week = 0;//����
        int DayTime = 0;//һ���ʱ��
        int Room;//����

        int x=1;
        int y=1;
        for (int num=end; num<=bits.length() ;being+=ConPara.ROOM_NUMBIT,end+=ConPara.CLASSES_NUMBIT, num=end) {

            classes=bits.getValue(being, end);

            if(classes>=studentClaassList.size()){
                score=0;
                System.out.println("�༶Խ�磡");
                return;
            }

            StudentClaass studentClaass=studentClaassList.get(classes);
            List<Course> courseLists=studentClaassListMap.get(studentClaass);
            //�γ�
            for (int i = 0; i < courseLists.size(); i++) {
                if(i==0) {
                    //һ���γ�ʱ��
                    being+=ConPara.CLASSES_NUMBIT;
                    end+=ConPara.COURSE_NUMBIT;
                }else{
                    //�ڶ����Ǵӽ��Һ�ʼ��
                    being+=ConPara.ROOM_NUMBIT;
                    end+=ConPara.COURSE_NUMBIT;
                }

                course=bits.getValue(being, end);

                //�γ�Խ��
                if(course>=courseLists.size()){
                    //Խ�磬ֱ�ӷ���λ0
                    score=0;
//                    System.out.println("�γ�Խ�磡");
                    return;
                }
                //�γ�
                Course course1=courseLists.get(course);

                //��ʦ����
                List<Teacher> teacherList=courseTeacherListMap.get(course1);
                //���Ҽ���
                List<Classroom> classroomList=courseRoomListMap.get(course1);

                being+=ConPara.COURSE_NUMBIT;
                end+=ConPara.TEACHER_NUMBIT;
                teachsr=bits.getValue(being, end);
                //��ʦԽ��
                if(teachsr>=teacherList.size()){
                    //Խ�磬ֱ�ӷ���λ0
                    score=0;
//                    System.out.println("��ʦԽ�磡");
                    return;
                }
                //ȫ������һ�죻

                //��ʦ
                Teacher teacher=teacherList.get(teachsr);

                int Tmp=0;

                for (int i1 = 1; i1 < tmp.size(); i1++) {
//                    System.out.println(teacher.getTeacherTend().getTend()+"-->>"+tmp.get(i1));
                    if((teacher.getTeacherTend().getTend().contains("��ɢ")&&tmp.get(i1)<=2)||teacher.getTeacherTend().getTend().contains("����")&&tmp.get(i1)>=3){
//                        System.out.println("score=0.01*score");
                        score=score-x*0.1;
                        x++;
                    } else{
//                        System.out.println("score+0.01");
                        if(tmp.get(i1)==0) {
                            score=score-0.01;
                        }else{
                            score=score+0.01;
                        }

                    }
                }
                tmp.clear();
                //��ѧʱ
                for (int i1 = 0; i1 < course1.getWeekClassHours(); i1++) {
                    if(i1==0) {
                        //һ����ʱ��
                        being+=ConPara.TEACHER_NUMBIT;
                        end+=ConPara.TWOORONE_BUMBIT;
                    }else{
                        //�ڶ����Ǵӽ��Һ�ʼ��
                        being+=ConPara.ROOM_NUMBIT;
                        end+=ConPara.TWOORONE_BUMBIT;
                    }
                    //��˫��
                    Tow=bits.getNp(being);

                    being+=ConPara.TWOORONE_BUMBIT;
                    end+=ConPara.WEEK_NUMBIT;
                    //����
                    for (int j = being,a=1; j <end ;a++, j++) {
                        if(bits.getNp(j)==1){
                            Week=a;
                        }
                    }

                    //ʱ��
                    being+=ConPara.WEEK_NUMBIT;
                    end+=ConPara.TIMEDAY_NUMBIT;
                    for (int j = being,a=1; j <end ;a++, j++) {
                        if(bits.getNp(j)==1){
                            DayTime=a;
                        }
                    }

                    for (Teacher.SkipHours m_stSkipHour : teacher.getM_stSkipHours()) {
//                        System.out.println(m_stSkipHour.getPhours().toString()+"-->>"+Week+"-->>"+DayTime);
                        if((m_stSkipHour.getPhours().contains("��һ")&&Week==1)||(m_stSkipHour.getPhours().contains("�ܶ�")&&Week==2)||(m_stSkipHour.getPhours().contains("����")&&Week==3)||(m_stSkipHour.getPhours().contains("����")&&Week==4)||(m_stSkipHour.getPhours().contains("����")&&Week==5)||(m_stSkipHour.getPhours().contains("����")&&Week==6)||(m_stSkipHour.getPhours().contains("����")&&DayTime==5)){
//                            System.out.println("score==0");
                            score=score-y*0.1;
                            y++;
                        }else{
//                            System.out.println("score-0.01");
                            score=score+0.01;
                        }
                    }

                    //����
                    being+=ConPara.TIMEDAY_NUMBIT;
                    end+=ConPara.ROOM_NUMBIT;
                    Room=bits.getValue(being, end);
                    if(Room>=classroomList.size()){
                        //Խ�磬ֱ�ӷ���λ0
                        score=0;
                        System.out.println("����Խ�磡");
                        return;
                    }
                    Classroom classroom=classroomList.get(Room);
                    score+=0.02;
                    Tmp=Week-Tmp;
                    tmp.add(Math.abs(Tmp));
                    Tmp=Week;
                }
            }

        }
    }
    //�������������õ÷֡����Ǹ�����Ⱥ������������Է������й�һ��֮���������÷���
    @Override
    public void setScore(double fScore) {
        this.fitness = score/fitness;
    }

    //��ȡ��������ĵ÷�,ʵ��÷֣���Ӧ��
    @Override
    public double getScore() {
        return this.score;
    }

    //��ӡ��������Ϣ
    @Override
    public String toString() {
        return bits.getM_bits().toString();
    }
}
