/*
 *   文件读取
 *   CsvReader方法是lib目录下的javacsv.jar包引入的，需要将javacsv.jar包引入
 *   从csv文件中读取数据
 *   outPutdata()方法，读取文件内容，存放list容器，并返回该容器
 *   @2020.7.27
 *   @冯杰
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

    public static String pathFilecsv; //要读取的文件的路径

    //读取文件将1数据放入list容器
    public static List<Map<String, String>> outPutData(String pathfile) throws IOException {
        pathFilecsv=pathfile;
        List<Map<String, String>> table = new ArrayList<>();
        //创建一个读取文件的对象
        CsvReader csvreader = new CsvReader(pathFilecsv,',', Charset.forName("GBK"));
        //读表头
        csvreader.readHeaders();
        String[] head = csvreader.getHeaders();//输入表头

        while (csvreader.readRecord()) {
            Map<String, String> row = new HashMap<>();
            for (int i = 0; i < head.length; i++) {
                row.put(head[i], csvreader.get(head[i]));//读取一行，用mpa存储
            }
          //  System.out.println(row);//打印此行元素
            table.add(row);//将得到的map存入list
        }
        //System.out.println(table);//打印一下list
        csvreader.close();
        return table;
    }

//    public static String getPathFIle(){
//        System.out.print("输入要读取文件的文件夹路径:");
//        String path=new Scanner(System.in).next();
//        System.out.print("输入要读取的文件名:");
//        String file=new Scanner(System.in).next();
//        return path+File.separator+file;
//    }

}
