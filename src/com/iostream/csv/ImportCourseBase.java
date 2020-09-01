
/*
*  从文件读取大类课程资源
*
*
* */

package com.iostream.csv;

import com.conpara.ConPara;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ImportCourseBase {
    public static List<Map<String,String>> getCourseBase() throws IOException {

        //读取大类课程资源，存储进list
        List<Map<String,String>>  CourseBase=osTreamData.outPutData(ConPara.CSV_PATH+ConPara.PATH_CSV_COURSEBASE);
        return CourseBase;
    }

}
