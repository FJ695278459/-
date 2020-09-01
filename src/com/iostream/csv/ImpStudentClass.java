/*
*   从文件读取班级资源类
*
* */


package com.iostream.csv;

import com.conpara.ConPara;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ImpStudentClass {
    public static List<Map<String, String>> getStudentClass() throws IOException {
        //获得班级名单
        List<Map<String,String>> studentClass=osTreamData.outPutData(ConPara.CSV_PATH+ConPara.PATH_STUDENT_CLASS);
        return studentClass;
    }
}
