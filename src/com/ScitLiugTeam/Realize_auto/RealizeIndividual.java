/*
*   个体
*   @冯杰
*   2020/8/19
*
* */

package com.ScitLiugTeam.Realize_auto;

import com.ScitLiugTeam.auto_scheduling.*;
import com.conpara.ConPara;

import java.io.IOException;
import java.util.*;

public class RealizeIndividual implements Individual {
    private double fitness=0;//个体适应度
    private double score=0;   //分数初始为0
    private  Bits bits=new RealizeBits();//二进制编码
    //随机初始化


    //赋值适应度
    public void setFitness(double fitness) {

    }

    //获取适应度
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
            System.out.println("编码错误！");
            e.printStackTrace();
        }
        bits.newBits(str.length());
        bits.fromString(str);
        score();
        str=null;
    }

    //复制另外一个个体
    @Override
    public void copyFrom(Individual ind) {
        bits.fromString(TurnBitsAndString.getStringToArresByte(ind.getBits().getM_bits()));
    }

    //判断本基因组代表的解是否合法，合法返回true，不合法false
    @Override
    public boolean isLegal() {
        return false;
    }

    //本基因组的长度
    @Override
    public int length() {
        return bits.length();
    }

    //将本基因组解码为问题的解
    @Override
    public Solution decode() {
        return null;
    }

    //给始本基因组打分。这是初的打分
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
        int classes;//班级
        int course;//课程
        int teachsr;//老师
        int Tow = 0;//单双周
        int Week = 0;//星期
        int DayTime = 0;//一天的时段
        int Room;//教室

        int x=1;
        int y=1;
        for (int num=end; num<=bits.length() ;being+=ConPara.ROOM_NUMBIT,end+=ConPara.CLASSES_NUMBIT, num=end) {

            classes=bits.getValue(being, end);

            if(classes>=studentClaassList.size()){
                score=0;
                System.out.println("班级越界！");
                return;
            }

            StudentClaass studentClaass=studentClaassList.get(classes);
            List<Course> courseLists=studentClaassListMap.get(studentClaass);
            //课程
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

                course=bits.getValue(being, end);

                //课程越界
                if(course>=courseLists.size()){
                    //越界，直接分数位0
                    score=0;
//                    System.out.println("课程越界！");
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
                teachsr=bits.getValue(being, end);
                //老师越界
                if(teachsr>=teacherList.size()){
                    //越界，直接分数位0
                    score=0;
//                    System.out.println("老师越界！");
                    return;
                }
                //全部课在一天；

                //老师
                Teacher teacher=teacherList.get(teachsr);

                int Tmp=0;

                for (int i1 = 1; i1 < tmp.size(); i1++) {
//                    System.out.println(teacher.getTeacherTend().getTend()+"-->>"+tmp.get(i1));
                    if((teacher.getTeacherTend().getTend().contains("分散")&&tmp.get(i1)<=2)||teacher.getTeacherTend().getTend().contains("集中")&&tmp.get(i1)>=3){
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
                    //单双周
                    Tow=bits.getNp(being);

                    being+=ConPara.TWOORONE_BUMBIT;
                    end+=ConPara.WEEK_NUMBIT;
                    //星期
                    for (int j = being,a=1; j <end ;a++, j++) {
                        if(bits.getNp(j)==1){
                            Week=a;
                        }
                    }

                    //时段
                    being+=ConPara.WEEK_NUMBIT;
                    end+=ConPara.TIMEDAY_NUMBIT;
                    for (int j = being,a=1; j <end ;a++, j++) {
                        if(bits.getNp(j)==1){
                            DayTime=a;
                        }
                    }

                    for (Teacher.SkipHours m_stSkipHour : teacher.getM_stSkipHours()) {
//                        System.out.println(m_stSkipHour.getPhours().toString()+"-->>"+Week+"-->>"+DayTime);
                        if((m_stSkipHour.getPhours().contains("周一")&&Week==1)||(m_stSkipHour.getPhours().contains("周二")&&Week==2)||(m_stSkipHour.getPhours().contains("周三")&&Week==3)||(m_stSkipHour.getPhours().contains("周四")&&Week==4)||(m_stSkipHour.getPhours().contains("周五")&&Week==5)||(m_stSkipHour.getPhours().contains("周六")&&Week==6)||(m_stSkipHour.getPhours().contains("晚上")&&DayTime==5)){
//                            System.out.println("score==0");
                            score=score-y*0.1;
                            y++;
                        }else{
//                            System.out.println("score-0.01");
                            score=score+0.01;
                        }
                    }

                    //教室
                    being+=ConPara.TIMEDAY_NUMBIT;
                    end+=ConPara.ROOM_NUMBIT;
                    Room=bits.getValue(being, end);
                    if(Room>=classroomList.size()){
                        //越界，直接分数位0
                        score=0;
                        System.out.println("教室越界！");
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
    //给本基因组设置得分。这是根据种群个体整体情况对分数进行归一化之后重新设置分数
    @Override
    public void setScore(double fScore) {
        this.fitness = score/fitness;
    }

    //获取本基因组的得分,实体得分，适应度
    @Override
    public double getScore() {
        return this.score;
    }

    //打印二进制信息
    @Override
    public String toString() {
        return bits.getM_bits().toString();
    }
}
