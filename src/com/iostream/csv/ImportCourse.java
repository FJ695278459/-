/*
*  ���ļ���ȡ�γ���Դ
*
* */

package com.iostream.csv;

import com.conpara.ConPara;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImportCourse {
    public static List<Map<String,String>> getCourse() throws IOException {
        //��ȡ�γ���Դ
        List<Map<String,String>> Course=osTreamData.outPutData(ConPara.CSV_PATH+ConPara.PATH_CSV_COURSE);

        return Course;
    }
}
