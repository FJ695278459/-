package com.conpara;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
*   ���ݳ�����
*
* */

public class ConPara {
    public static final String CSV_PATH=System.getProperty("user.dir")+ File.separator+"data"+File.separator;//����·��
    public static final String CSV_TEACHER_FILE="teachar.csv";
    public static final String CSV_STUDENT_FILE="student.csv";
    public static final String CSV_SQILT="E:\\java_oooo\\java_HelloWorld\\scit_liug_team_pub\\auto_scheduling\\randPeopList\\student.csv";
    public static final String PATH_CSV_CLASSROOM="����10.csv";//����
    public static final String PATH_CSV_COURSE="�γ�3000.csv";//�γ�
    public static final String PATH_CSV_STUDENT="";//ѧ����Ϣ·��
    public static final String PATH_CSV_TEACHER="��ʦ111.csv";//��ʦ
    public static final String PATH_CSV_COURSEBASE="����γ�10.csv";//����γ�
    public static final String PATH_APPEND_TEACHER="����Ҫ��2.csv";//����Ҫ��
    public static final String PATH_CSV_MAJOR="רҵ����.csv";//רҵ����
    public static final String PATH_STUDENT_CLASS="�༶����10000.csv";//�༶����
    public static final String PATH_DATABASE="shujuk.db";//����
    public static final String JDBC="org.sqlite.JDBC";//��������
    public static final Resource RES=new Resource();//��Դ�����Ҽ���.�༶���γ̣����ֹ�ϵ


    static {
        //���Ҽ���.�༶���γ�
        try {
            System.out.println("������Դ��:list");
            RES.setList();
        } catch (IOException e) {
            System.out.println("list��Դ��������");
            e.printStackTrace();
        }
        try {
            System.out.println("������Դ��:map");
            RES.setMap(RES.getCourseslist(),RES.getStudentClaassList());
            System.out.println("����ɹ���");
        } catch (IOException | InterruptedException e) {
            System.out.println("Map��Դ��������");
            e.printStackTrace();
        }

    }

    public static   Set<String> TimecRoom=new HashSet<>();//�����жϰ༶֮��ʱ������Ƿ��ظ�
    public static   Set<String> set=new HashSet<>();//���ڴ��һ���༶���Ͽ�ʱ���
    public static   Set<String> Teagche=new HashSet<>();//�����ж���ʦ�Ƿ���ͬһʱ�������ÿ�
    public static   StringBuilder sb1=new StringBuilder();//һ���༶��һ���γ̵�01
    public static  StringBuffer sb=new StringBuffer();//s���а༶��01


  public static  StringBuffer sb01=new StringBuffer();//�洢�����ƣ��洢���п�ʱ��01����
   public static StringBuffer Tmp=new StringBuffer();//��ʱ���洢һ����ʱ��01����

    public static  byte[] bits1=new byte[11];//�༶����
    public static  byte[] bits2=new byte[4];//�γ̱���
    public static  byte[] bits3=new byte[6];//��ʦ����
    public static  byte[] byte10=new byte[1];//��˫��
    public static  byte[] bytes1=new byte[6];//6��
    public static  byte[] bytes2=new byte[5];//5��ʱ
    public static  byte[] bytes3=new byte[10];//����

    public static final int CLASSES_NUMBIT=bits1.length;//�༶���볤��
    public static final int COURSE_NUMBIT=bits2.length;//�γ̱��볤��
    public static final int WEEK_NUMBIT=bytes1.length;//����
    public static final int TIMEDAY_NUMBIT=bytes2.length;//�Ͽ�ʱ��
    public static final int TWOORONE_BUMBIT=byte10.length;//��˫��
    public static final int ROOM_NUMBIT=bytes3.length;//����
    public static final int TIME_ROOM_NUMBIT=23;//�Ͽ�ʱ��ӽ���
    public static final int TEACHER_NUMBIT=bits3.length;//��ʦ���볤��


    public static final int NUM=100;//��Ⱥ�������
    public static final int NRXTNUM=5000;//��������

}
