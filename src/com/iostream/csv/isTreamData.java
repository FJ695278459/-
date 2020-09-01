
/*
 *   �������ݵ�csv�ļ�
 *   CsvWriter������libĿ¼�µ�javacsv.jar������ģ���Ҫ��javacsv.jar������
 *   inputData()����
 *   @2020.7.27
 *   @���
 * */


package com.iostream.csv;
import com.conpara.ConPara;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class isTreamData {

    public static String pathFilecsv;  //Ҫ�����ļ�·����

    public static void inputData(List<Map<String, Object>> table) throws IOException {
        pathFilecsv=getPathFile();
        //����һ���������
        CsvWriter csvwriter = new CsvWriter(pathFilecsv, ',', Charset.forName("GBK"));//���������ļ���·��
        CsvReader csvread = new CsvReader(osTreamData.pathFilecsv, ',', Charset.forName("GBK"));//��ȡ�ļ���·����Ϊ�˵õ�ÿ��Ԫ�ظ���
        //�����ͷ��
        csvread.readHeaders();
        String[] head = csvread.getHeaders();//�����ͷ��Ԫ�أ��õ���ͷ��һ��Ԫ�صĸ���
        csvwriter.writeRecord(head);//�����ͷ,Ϊ�˵õ�ÿ��Ԫ�ظ���

        String[] xom = new String[head.length];//����һ���ϵ�Ԫ��

        for (int i = 0; i < table.size(); i++) {
            Map<String, Object> map = table.get(i);
            for (int j = 0; j < head.length; j++) {
                xom[j] = map.get(head[j]).toString();//��õ�i�е�����
            }
            csvwriter.writeRecord(xom);//��һ��Ԫ��д���ļ�
            System.out.println(map);
        }
        System.out.println("д��ɹ���");
        csvread.close();
        csvwriter.close();
    }
    //��ȡ�ļ�·��������
    public static String getPathFile(){

        System.out.print("����Ҫ�������ݵ��ļ�·�������Դ����ļ�����");
        String path=new Scanner(System.in).next();
        System.out.print("����Ҫ�洢���ļ���(���û�д�csv�ļ���������һ��csv�ļ�)��");
        String nameFile=new Scanner(System.in).next();
        File file=new File(path+File.separator+nameFile);
        return path+ File.separator+nameFile;
    }
}
