/*
*
*   ���룬���α����
*   @���
*   @2020/8/15
*   �༶����+�γ̱���+��ʦ����+��ʱ*(�Ƿ�˫��+�Ͽ�ʱ��+���ұ���)=ԭ����
* */

package com.ScitLiugTeam.Realize_auto;

import com.ScitLiugTeam.auto_scheduling.*;
import com.conpara.ConPara;
import com.iostream.Imp.StudentClassImport;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Decode {

    //���룺�༶����+�γ̱���+��ʦ����+���ұ���+�Ƿ�˫��+�Ͽ�ʱ��=ԭ����
    public static void DecodeLesson(Individual vial) throws IOException {
        Bits bits = vial.getBits();
        int being = 0;
        int end = ConPara.CLASSES_NUMBIT;

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
        System.out.println("�����Ƴ��ȣ�-->>" + bits.length());

        for (int num=end; num<=bits.length() ;being+=ConPara.ROOM_NUMBIT,end+=ConPara.CLASSES_NUMBIT, num=end) {

//          System.out.println("�༶:"+being+"-->>"+end);
            classes=bits.getValue(being, end);

            StudentClaass studentClaass=studentClaassList.get(classes);
            System.out.println("\n\n�༶��"+studentClaass.getClassname()+"--->>"+studentClaass.getClassnum()+"--->>"+studentClaass.getClassID());
            List<Course> courseLists=studentClaassListMap.get(studentClaass);

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

//                System.out.println("�γ̣�"+being+"-->>"+end);
                course=bits.getValue(being, end);

                //�γ�Խ��
                if(course>=courseLists.size()){
                    System.out.println("�γ�Խ�磡");
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
//                System.out.println("��ʦ��"+being+"-->>"+end);
                teachsr=bits.getValue(being, end);
                //��ʦԽ��
                if(teachsr>=teacherList.size()){
                    System.out.println("��ʦԽ�磡");
                    return;
                }

                //��ʦ
                Teacher teacher=teacherList.get(teachsr);
                System.out.println("�γ̣�"+course1.getCourseName()+"--->>"+course1.getID()+"--->>�Ͽ���ʦ��"+teacher.getName()+"-->>"+teacher.getID());
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
//                    System.out.println("��˫�ܣ�"+being+"-->>"+end);
                    //��˫��
                    Tow=bits.getNp(being);

                    being+=ConPara.TWOORONE_BUMBIT;
                    end+=ConPara.WEEK_NUMBIT;
//                    System.out.println("���ڣ�"+being+"-->>"+end);
                    //����
                    for (int j = being,a=1; j <end ;a++, j++) {
                        if(bits.getNp(j)==1){
                            Week=a;
                        }
                    }

                    //ʱ��
                    being+=ConPara.WEEK_NUMBIT;
                    end+=ConPara.TIMEDAY_NUMBIT;
//                    System.out.println("ʱ�Σ�"+being+"-->>"+end);
                    for (int j = being,a=1; j <end ;a++, j++) {
                        if(bits.getNp(j)==1){
                            DayTime=a;
                        }
                    }

                    //����
                    being+=ConPara.TIMEDAY_NUMBIT;
                    end+=ConPara.ROOM_NUMBIT;
//                    System.out.println("���ң�"+being+"-->>"+end);
                    Room=bits.getValue(being, end);
                    if(Room>=classroomList.size()){
                        System.out.println("����Խ�磡");
                        return;
                    }

                    Classroom classroom=classroomList.get(Room);
                    System.out.println("�Ͽ�ʱ����ң�"+"����"+Week+"-->>��"+DayTime+"ʱ��:--->>����"+classroom.getM_sName()+"-->>"+classroom.getM_nID());


                }
            }

        }
    }
}
