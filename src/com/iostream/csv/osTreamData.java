/*
 *   �ļ���ȡ
 *   CsvReader������libĿ¼�µ�javacsv.jar������ģ���Ҫ��javacsv.jar������
 *   ��csv�ļ��ж�ȡ����
 *   outPutdata()��������ȡ�ļ����ݣ����list�����������ظ�����
 *   @2020.7.27
 *   @���
 * */


package com.iostream.csv;

import com.ScitLiugTeam.auto_scheduling.Teacher;
import com.conpara.ConPara;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

public class osTreamData {

    public static String pathFilecsv; //Ҫ��ȡ���ļ���·��

    //��ȡ�ļ���1���ݷ���list����
    public static List<Map<String, String>> outPutData(String pathfile) throws IOException {
        pathFilecsv=pathfile;
        List<Map<String, String>> table = new ArrayList<>();
        //����һ����ȡ�ļ��Ķ���
        CsvReader csvreader = new CsvReader(pathFilecsv,',', Charset.forName("GBK"));
        //����ͷ
        csvreader.readHeaders();
        String[] head = csvreader.getHeaders();//�����ͷ

        while (csvreader.readRecord()) {
            Map<String, String> row = new HashMap<>();
            for (int i = 0; i < head.length; i++) {
                row.put(head[i], csvreader.get(head[i]));//��ȡһ�У���mpa�洢
            }
          //  System.out.println(row);//��ӡ����Ԫ��
            table.add(row);//���õ���map����list
        }
        //System.out.println(table);//��ӡһ��list
        csvreader.close();
        return table;
    }

//    public static String getPathFIle(){
//        System.out.print("����Ҫ��ȡ�ļ����ļ���·��:");
//        String path=new Scanner(System.in).next();
//        System.out.print("����Ҫ��ȡ���ļ���:");
//        String file=new Scanner(System.in).next();
//        return path+File.separator+file;
//    }

}
