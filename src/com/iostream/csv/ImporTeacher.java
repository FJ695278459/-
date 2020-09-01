
/*
*   从文件读取老师资源
*
* */

package com.iostream.csv;

import com.ScitLiugTeam.auto_scheduling.Teacher;
import com.conpara.ConPara;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ImporTeacher {
    public static List<Map<String ,String>> getTeacher() throws IOException {
        //老师
        List<Map<String, String>> TeachersData=osTreamData.outPutData(ConPara.CSV_PATH+ConPara.PATH_CSV_TEACHER);
        return  TeachersData;
    }
}
