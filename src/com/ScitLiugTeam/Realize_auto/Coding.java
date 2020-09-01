/*
    @���
*   @2020/8/15

*   ����
*   ���α����
*   �༶����+�γ̱���+��ʦ����+��ʱ*(�Ƿ�˫��+�Ͽ�ʱ��+���ұ���)=ԭ����
*
* */

package com.ScitLiugTeam.Realize_auto;

import com.ScitLiugTeam.auto_scheduling.Classroom;
import com.ScitLiugTeam.auto_scheduling.Course;
import com.ScitLiugTeam.auto_scheduling.StudentClaass;
import com.ScitLiugTeam.auto_scheduling.Teacher;
import com.conpara.*;
import com.iostream.Imp.CourseImport;
import com.iostream.Imp.StudentClassImport;
import com.iostream.Imp.TeacherImports;
import com.iostream.csv.ImpStudentClass;

import java.awt.*;
import java.io.IOException;
import java.sql.Time;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;

public class Coding {



    //�ܵĶ��������У������α�
    public static String Total() throws IOException {


        ConPara.sb.delete(0,ConPara.sb.length());//�������֮ǰҪ������ַ������


        List<StudentClaass> studentClaassList=ConPara.RES.getStudentClaassList();
        Map<StudentClaass,List<Course>> studentClaassListMap=ConPara.RES.getStudentClaassListMap();
        for (int i = 0; i < studentClaassList.size(); i++) {
            //�ð༶���ϵĿγ�
//            System.out.println("\n\n�༶��"+studentClaassList.get(i).getClassname()+"-->>"+studentClaassList.get(i).getClassID());
            //�༶��ű���:11
            TurnBitsAndString.getByteForInt(ConPara.bits1,i);
            //�ð༶�Ŀγ�
            List<Course> courseList=studentClaassListMap.get(studentClaassList.get(i));

            ConPara.sb.append(TurnBitsAndString.getStringToArresByte(ConPara.bits1));
            for (int i1 = 0; i1 < courseList.size(); i1++) {
                ConPara.sb.append(Coursebit(courseList.get(i1),i1));
                //ÿ���γ̽������룬����γ̱�����ַ������
                ConPara.sb1.delete(0,ConPara.sb1.length());
            }
            ConPara.set.clear();
        }
        ConPara.TimecRoom.clear();
        ConPara.TimecRoom.clear();
        ConPara.set.clear();
        return ConPara.sb.toString();
    }

    //һ�����һ���γ�
    //���룺�༶����+�γ̱���+��ʦ����+���ұ���+�Ƿ�˫��+�Ͽ�ʱ��=ԭ����
   public static String Coursebit(Course course,int Course_tmp) throws IOException {
        Random ra=new Random();
        //��ǰ�γ�
        //��������01�ַ���
        //�ÿγ̿����ŵ���ʦ
        List<Teacher> list1=ConPara.RES.getCourseListteachertMap().get(course);
//       System.out.println(map1.size());
        //�ÿγ̿����Ž���
        List<Classroom> list2=ConPara.RES.getCourseListclassroomMap().get(course);
//       System.out.println(map2.size());
        //�༶���еĿγ�

        //�����ȡ��ʦ
       int Tmp1;

       if(list1.size()>=64) {
           Tmp1=ra.nextInt(64);
       }else {
            Tmp1=ra.nextInt(list1.size());
       }
        //�γ̱���:4

        TurnBitsAndString.getByteForInt(ConPara.bits2,Course_tmp);
        ConPara.sb1.append(TurnBitsAndString.getStringToArresByte(ConPara.bits2));

        //��ʦ����:6
//        System.out.println("��ʦ��"+list1.get(Tmp1).getName()+"--->>"+list1.get(Tmp1).getID()+"-->>���Ͽγ�:"+course.getCourseName()+"-->>"+course.getID());
        TurnBitsAndString.getByteForInt(ConPara.bits3,Tmp1);
        ConPara.sb1.append(TurnBitsAndString.getStringToArresByte(ConPara.bits3));


        //�Ͽ�ʱ��+���ң�=bits4.lenght,23*x
        byte[] bits4=TimeCourse(course,list2,list1.get(Tmp1).getID());
        ConPara.sb1.append(TurnBitsAndString.getStringToArresByte(bits4));

        return ConPara.sb1.toString();

    }

    //�Ͽ�ʱ��+����
    private static byte[] TimeCourse(Course course,List<Classroom> map,int teacherid){

        Random ra=new Random();
        int num=course.getWeekClassHours();//�γ�ѧ��ʱ

        while (num!=0){

            ConPara.Tmp.delete(0,ConPara.Tmp.length());
            //���ȣ�1+5+6+11==23
            //��ʾ��˫��
            ConPara.byte10[0]= (byte) ra.nextInt(2);

            //�������
            Initializebyte(ConPara.bytes1);//��ʼ��ֵ0
            int x=ra.nextInt(6)+1;
            ConPara.bytes1[x-1]=1;//6���������һ��Ϊ1����������Ͽ�


            //�Ͽ�ʱ�����
            Initializebyte(ConPara.bytes2);//��ʼ��ֵ0
            int y=ra.nextInt(5)+1;
            ConPara.bytes2[y-1]=1;//5��ʱ�������һΪ1�������ʱ���Ͽ�

            //��ͬ�༶֮���ʱ��
            //��˫��
            ConPara.Tmp.append(TurnBitsAndString.getStringToArresByte(ConPara.byte10));
            //����
            ConPara.Tmp.append(TurnBitsAndString.getStringToArresByte(ConPara.bytes1));
            //�Ͽ�ʱ��
            ConPara.Tmp.append(TurnBitsAndString.getStringToArresByte(ConPara.bytes2));

           int z;
           if(map.size()>=1024){
               z=ra.nextInt(1024);
           }else{
               z=ra.nextInt(map.size());
           }
            TurnBitsAndString.getByteForInt(ConPara.bytes3,z);//�ڸÿγ������ϵĽ���list�������ȡһ������List�±꽫����ɶ�����


            //�ж�ʱ����ң���ʦ��ͻ
            if(!ConPara.set.add(ConPara.Tmp.toString())||!ConPara.TimecRoom.add((map.get(z).getM_nID()+ConPara.Tmp.toString()))||!ConPara.Teagche.add(teacherid+ConPara.Tmp.toString())){
                ConPara.set.remove(ConPara.Tmp.toString());//һ���༶һ���γ�ʱ�䲻��ͻ
                ConPara.Teagche.remove(teacherid+ConPara.Tmp.toString());//��ʦ�Ͽ�ʱ�䲻��ͻ
                ConPara.TimecRoom.remove(map.get(z).getM_nID()+ConPara.Tmp.toString());//����ռ��ʱ�䲻��ͻ
                continue;
            }

//            System.out.println("����"+x+"--->>"+"��"+y+"ʱ��"+"-->>"+map.get(z).getM_sName()+"-->>"+map.get(z).getM_nID());
           //�����ж����Ʒ���һ��byte[]������
            ConPara.sb01.append(TurnBitsAndString.getStringToArresByte(ConPara.byte10));
            ConPara.sb01.append(TurnBitsAndString.getStringToArresByte(ConPara.bytes1));
            ConPara.sb01.append(TurnBitsAndString.getStringToArresByte(ConPara.bytes2));
            ConPara.sb01.append(TurnBitsAndString.getStringToArresByte(ConPara.bytes3));
            //����ַ���
            num--;
        }
        //��01�ַ������byte[]
        byte[] Total=TurnBitsAndString.getArresBytesForString(ConPara.sb01.toString());
        //��ʼ��
        ConPara.sb01.delete(0,ConPara.sb01.length());//�ͷ��ڴ�
        ConPara.Tmp.delete(0,ConPara.Tmp.length());
        return Total;
    }


    private static void Initializebyte(byte[] bytes) {
        //�ȳ�ʼ��λ0
        for (int i = 0; i <bytes.length ; i++) {
            bytes[i]=0;
        }
    }
}
