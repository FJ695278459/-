
/*
*
*   ���ļ���ȡ����Ҫ����Ϣ
*
* */

package com.iostream.csv;

import com.conpara.ConPara;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ImportAppendTeacher {
    public static List<Map<String,String>> getAppend() throws IOException {
        //����Ҫ����Դ��ȡ
        List<Map<String,String>> TeacherAppend=osTreamData.outPutData(ConPara.CSV_PATH+ConPara.PATH_APPEND_TEACHER);
        return TeacherAppend;
    }

}
