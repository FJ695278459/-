/*
*
*   ������Դ�࣬�����еĽ��Ҷ����Ž�list<Classroom>����
*    @2020.8.4
*    @���
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
            //newһ�����Ҷ���
            Classroom sumber=new Classroom();
            //���ұ��
            sumber.setM_nID(Integer.parseInt(list.get(i).get("���ұ��")));
            //��������
            sumber.setM_sName(list.get(i).get("����ID"));
            //�����������
            sumber.setM_Studentnumber(Integer.parseInt(list.get(i).get("���ҿ�����ѧ��")));
            //������Դ
           sumber.setM_stResources(getroomRes(list.get(i)));
            //���뼯��
            ClassRooms.add(sumber);
        }
        list.clear();//�ͷ��ڴ�
        return ClassRooms;
    }
    private static Set<Classroom.ClassroomRes> getroomRes(Map<String,String> map)  throws IOException {
        Set<Classroom.ClassroomRes> roomres=new HashSet<>();
        List<Map<String,String>> list=ClassesRoom.getClassesRoom();
        if(Pattern.compile("\\w*�ڰ�\\w*").matcher(map.get("��Դ")).find()){
            Classroom.ClassroomRes Tow=Classroom.ClassroomRes.SLT_CRES_BLACKBOARD;//�ڰ�
            Classroom.ClassroomRes four=Classroom.ClassroomRes.STL_CRES_CHALK;//�۱�
            Classroom.ClassroomRes Three=Classroom.ClassroomRes.STL_CRES_EARASER;//�ڰ��
            roomres.add(Three);
            roomres.add(four);
            roomres.add(Tow);
        }
           if(Pattern.compile("\\w*����\\w*").matcher(map.get("��Դ")).find()) {
               Classroom.ClassroomRes five = Classroom.ClassroomRes.SLT_CRES_SPEECH;//������
               roomres.add(five);
           }
        if(Pattern.compile("\\w*����\\w*").matcher(map.get("��Դ")).find()) {
            Classroom.ClassroomRes six = Classroom.ClassroomRes.SLT_CRES_COMPUTER;//���Ի���
            roomres.add(six);
        }
        if(Pattern.compile("\\w*����\\w*").matcher(map.get("��Դ")).find()) {
            Classroom.ClassroomRes seven = Classroom.ClassroomRes.SLT_CRES_PHYLAB;//����ʵ����
            roomres.add(seven);
        }
        if(Pattern.compile("\\w*��ý��\\W*").matcher(map.get("��Դ")).find()) {
            Classroom.ClassroomRes nigh = Classroom.ClassroomRes.SLT_CRES_PROJECTOR;//ͶӰ��
            roomres.add(nigh);
        }
        if(Pattern.compile("\\w*��ѧ\\W*").matcher(map.get("��Դ")).find()) {
            Classroom.ClassroomRes Ten = Classroom.ClassroomRes.SLT_CRES_CHEMISTRY;//��ѧʵ����
            roomres.add(Ten);
        }
        if(Pattern.compile("\\w*����\\W*").matcher(map.get("��Դ")).find()) {
            Classroom.ClassroomRes Ten1 = Classroom.ClassroomRes.SLT_CRES_ANATOMY;//ҽѧ������
            roomres.add(Ten1);
        }
        if(Pattern.compile("\\w*����\\W*").matcher(map.get("��Դ")).find()) {
            Classroom.ClassroomRes Ten2 = Classroom.ClassroomRes.STL_CRES_BIOLOGY;//����ʵ����
            roomres.add(Ten2);
        }
        if(Pattern.compile("\\w*����\\W*").matcher(map.get("��Դ")).find()) {
            Classroom.ClassroomRes Ten3 = Classroom.ClassroomRes.STL_CRES_NURSE;//����ʵѵ��
            roomres.add(Ten3);
        }
        if(Pattern.compile("\\w*����\\W*").matcher(map.get("��Դ")).find()) {
            Classroom.ClassroomRes Ten4 = Classroom.ClassroomRes.STL_CRES_CAR;//����ʵѵ��
            roomres.add(Ten4);
        }
        if(Pattern.compile("\\w*����\\W*").matcher(map.get("��Դ")).find()) {
            Classroom.ClassroomRes Ten5 = Classroom.ClassroomRes.STL_CRES_ELECTOR;//����ʵѵ��
            roomres.add(Ten5);
        }
        return roomres;
    }
}
