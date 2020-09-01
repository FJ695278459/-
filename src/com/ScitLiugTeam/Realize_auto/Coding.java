/*
    @冯杰
*   @2020/8/15

*   编码
*   将课表编码
*   班级编码+课程编码+老师编码+课时*(是否单双周+上课时段+教室编码)=原子码
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



    //总的二进制序列，整个课表
    public static String Total() throws IOException {


        ConPara.sb.delete(0,ConPara.sb.length());//个体编码之前要将这个字符串清空


        List<StudentClaass> studentClaassList=ConPara.RES.getStudentClaassList();
        Map<StudentClaass,List<Course>> studentClaassListMap=ConPara.RES.getStudentClaassListMap();
        for (int i = 0; i < studentClaassList.size(); i++) {
            //该班级可上的课程
//            System.out.println("\n\n班级："+studentClaassList.get(i).getClassname()+"-->>"+studentClaassList.get(i).getClassID());
            //班级编号编码:11
            TurnBitsAndString.getByteForInt(ConPara.bits1,i);
            //该班级的课程
            List<Course> courseList=studentClaassListMap.get(studentClaassList.get(i));

            ConPara.sb.append(TurnBitsAndString.getStringToArresByte(ConPara.bits1));
            for (int i1 = 0; i1 < courseList.size(); i1++) {
                ConPara.sb.append(Coursebit(courseList.get(i1),i1));
                //每个课程结束编码，储存课程编码的字符串清空
                ConPara.sb1.delete(0,ConPara.sb1.length());
            }
            ConPara.set.clear();
        }
        ConPara.TimecRoom.clear();
        ConPara.TimecRoom.clear();
        ConPara.set.clear();
        return ConPara.sb.toString();
    }

    //一个班的一个课程
    //编码：班级编码+课程编码+老师编码+教室编码+是否单双周+上课时段=原子码
   public static String Coursebit(Course course,int Course_tmp) throws IOException {
        Random ra=new Random();
        //当前课程
        //储存所有01字符串
        //该课程可以排的老师
        List<Teacher> list1=ConPara.RES.getCourseListteachertMap().get(course);
//       System.out.println(map1.size());
        //该课程可以排教室
        List<Classroom> list2=ConPara.RES.getCourseListclassroomMap().get(course);
//       System.out.println(map2.size());
        //班级所有的课程

        //随机获取老师
       int Tmp1;

       if(list1.size()>=64) {
           Tmp1=ra.nextInt(64);
       }else {
            Tmp1=ra.nextInt(list1.size());
       }
        //课程编码:4

        TurnBitsAndString.getByteForInt(ConPara.bits2,Course_tmp);
        ConPara.sb1.append(TurnBitsAndString.getStringToArresByte(ConPara.bits2));

        //老师编码:6
//        System.out.println("老师："+list1.get(Tmp1).getName()+"--->>"+list1.get(Tmp1).getID()+"-->>所上课程:"+course.getCourseName()+"-->>"+course.getID());
        TurnBitsAndString.getByteForInt(ConPara.bits3,Tmp1);
        ConPara.sb1.append(TurnBitsAndString.getStringToArresByte(ConPara.bits3));


        //上课时间+教室：=bits4.lenght,23*x
        byte[] bits4=TimeCourse(course,list2,list1.get(Tmp1).getID());
        ConPara.sb1.append(TurnBitsAndString.getStringToArresByte(bits4));

        return ConPara.sb1.toString();

    }

    //上课时间+教室
    private static byte[] TimeCourse(Course course,List<Classroom> map,int teacherid){

        Random ra=new Random();
        int num=course.getWeekClassHours();//课程学周时

        while (num!=0){

            ConPara.Tmp.delete(0,ConPara.Tmp.length());
            //长度：1+5+6+11==23
            //表示单双周
            ConPara.byte10[0]= (byte) ra.nextInt(2);

            //星期随机
            Initializebyte(ConPara.bytes1);//初始赋值0
            int x=ra.nextInt(6)+1;
            ConPara.bytes1[x-1]=1;//6天中随机边一个为1。代表该天上课


            //上课时段随机
            Initializebyte(ConPara.bytes2);//初始赋值0
            int y=ra.nextInt(5)+1;
            ConPara.bytes2[y-1]=1;//5课时中随机变一为1，代表该时段上课

            //不同班级之间的时间
            //单双周
            ConPara.Tmp.append(TurnBitsAndString.getStringToArresByte(ConPara.byte10));
            //星期
            ConPara.Tmp.append(TurnBitsAndString.getStringToArresByte(ConPara.bytes1));
            //上课时段
            ConPara.Tmp.append(TurnBitsAndString.getStringToArresByte(ConPara.bytes2));

           int z;
           if(map.size()>=1024){
               z=ra.nextInt(1024);
           }else{
               z=ra.nextInt(map.size());
           }
            TurnBitsAndString.getByteForInt(ConPara.bytes3,z);//在该课程所能上的教室list中随机获取一个，该List下标将他变成二进制


            //判断时间教室，老师冲突
            if(!ConPara.set.add(ConPara.Tmp.toString())||!ConPara.TimecRoom.add((map.get(z).getM_nID()+ConPara.Tmp.toString()))||!ConPara.Teagche.add(teacherid+ConPara.Tmp.toString())){
                ConPara.set.remove(ConPara.Tmp.toString());//一个班级一个课程时间不冲突
                ConPara.Teagche.remove(teacherid+ConPara.Tmp.toString());//老师上课时间不冲突
                ConPara.TimecRoom.remove(map.get(z).getM_nID()+ConPara.Tmp.toString());//教室占用时间不冲突
                continue;
            }

//            System.out.println("星期"+x+"--->>"+"第"+y+"时段"+"-->>"+map.get(z).getM_sName()+"-->>"+map.get(z).getM_nID());
           //将所有二进制放在一个byte[]数组里
            ConPara.sb01.append(TurnBitsAndString.getStringToArresByte(ConPara.byte10));
            ConPara.sb01.append(TurnBitsAndString.getStringToArresByte(ConPara.bytes1));
            ConPara.sb01.append(TurnBitsAndString.getStringToArresByte(ConPara.bytes2));
            ConPara.sb01.append(TurnBitsAndString.getStringToArresByte(ConPara.bytes3));
            //清空字符串
            num--;
        }
        //将01字符串变成byte[]
        byte[] Total=TurnBitsAndString.getArresBytesForString(ConPara.sb01.toString());
        //初始化
        ConPara.sb01.delete(0,ConPara.sb01.length());//释放内存
        ConPara.Tmp.delete(0,ConPara.Tmp.length());
        return Total;
    }


    private static void Initializebyte(byte[] bytes) {
        //先初始化位0
        for (int i = 0; i <bytes.length ; i++) {
            bytes[i]=0;
        }
    }
}
