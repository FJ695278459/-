
/*
*
*   从文件读取教室资源
*
*
* */

package com.iostream.csv;

import com.ScitLiugTeam.auto_scheduling.Classroom;
import com.conpara.ConPara;

import java.io.IOException;
import java.util.*;



public class ClassesRoom {

    public static List<Map<String,String>> getClassesRoom() throws IOException {
        //读取教室资源
        List<Map<String, String>> Classesroom=osTreamData.outPutData(ConPara.CSV_PATH+ConPara.PATH_CSV_CLASSROOM);
        return Classesroom;
    }
}
