
/*
 *   输入数据到csv文件
 *   CsvWriter方法是lib目录下的javacsv.jar包引入的，需要将javacsv.jar包引入
 *   inputData()方法
 *   @2020.7.27
 *   @冯杰
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

    public static String pathFilecsv;  //要输入文件路径名

    public static void inputData(List<Map<String, Object>> table) throws IOException {
        pathFilecsv=getPathFile();
        //创建一个输入对象
        CsvWriter csvwriter = new CsvWriter(pathFilecsv, ',', Charset.forName("GBK"));//输入数据文件的路径
        CsvReader csvread = new CsvReader(osTreamData.pathFilecsv, ',', Charset.forName("GBK"));//读取文件的路径，为了得到每行元素个数
        //输入表头，
        csvread.readHeaders();
        String[] head = csvread.getHeaders();//储存表头的元素，得到表头那一行元素的个数
        csvwriter.writeRecord(head);//输入表头,为了得到每行元素个数

        String[] xom = new String[head.length];//储存一行上的元素

        for (int i = 0; i < table.size(); i++) {
            Map<String, Object> map = table.get(i);
            for (int j = 0; j < head.length; j++) {
                xom[j] = map.get(head[j]).toString();//获得第i行的数据
            }
            csvwriter.writeRecord(xom);//将一行元素写入文件
            System.out.println(map);
        }
        System.out.println("写入成功！");
        csvread.close();
        csvwriter.close();
    }
    //获取文件路径，名字
    public static String getPathFile(){

        System.out.print("输入要储存数据的文件路径（可以创建文件）：");
        String path=new Scanner(System.in).next();
        System.out.print("输入要存储的文件名(如果没有此csv文件，将创建一个csv文件)：");
        String nameFile=new Scanner(System.in).next();
        File file=new File(path+File.separator+nameFile);
        return path+ File.separator+nameFile;
    }
}
