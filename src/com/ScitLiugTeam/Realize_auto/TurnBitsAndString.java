
/*
    @冯杰
*   @2020/8/15
*   二进制,byte[],String,相互转换转换，类
*
*   以及一些算法
*   int转成二进制
*   二进制变成int
* */

package com.ScitLiugTeam.Realize_auto;

import java.util.Random;

import static java.lang.Integer.parseInt;

public class TurnBitsAndString {
    //String换成byte[]
    public static byte[] getArresBytesForString(String str){
        String[] sq=str.split("");
        byte[] bytes=new byte[sq.length];
        for (int i = 0; i <sq.length; i++) {
            int Tmp= Integer.parseInt(sq[i]);
            bytes[i]= (byte)Tmp;
        }
        return bytes;
    }
    //byte[]转换成String
    public static String getStringToArresByte(byte[] bytes){
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <bytes.length ; i++) {
            sb.append(String.valueOf(bytes[i]));
        }
        return sb.toString();
    }

    //int转成二进制，用byte[] bytes来存储二进制序列
    public static void getByteForInt(byte[] bytes,int bit){
        //先初始化位0
        for (int i = 0; i <bytes.length ; i++) {
            bytes[i]=0;
        }
        StringBuffer sb=new StringBuffer();
        //将int转成二进制
        do{
            sb.append(bit%2);
            bit=bit/2;
            if(bit/2==0) sb.append(bit);
        }while (bit/2!=0);
        //将01字符串存入byte[]数组
        byte[] bytes1=TurnBitsAndString.getArresBytesForString(sb.toString());
        for (int i = 0,j=bytes.length-1; i <bytes1.length ; i++,j--) {
            bytes[j]=bytes1[i];
        }
        sb.delete(0,sb.length());

    }
    //String转成二进制，用byte[] bytes来存储二进制序列
    public static void getByteForInt(byte[] bytes,String str){
        //先初始化位0
        for (int i = 0; i <bytes.length ; i++) {
            bytes[i]=0;
        }
        //将int转成二进制

    }

    //二进制变成int,参数为String
    public static int getIntForByte(String str){
        byte[] bytes=TurnBitsAndString.getArresBytesForString(str);
        int num=0;
        for (int i = 0,j=bytes.length-1; i <bytes.length ; i++,j--) {
            num+=bytes[i]*Math.pow(2,j);
        }
        return num;
    }
    //二进制转成int,参数为byte[]
    public static int getIntForByte(byte[] bytes){
        int num=0;
        for (int i = 0,j=bytes.length-1; i <bytes.length ; i++,j--) {
            num+=bytes[i]*Math.pow(2,j);
        }
        return num;
    }
    //获取第p1（包含）到第p2（包含）位之间的值
    public static int getValue(int nP1, int nP2,byte[] m_bits) {
        StringBuffer sb=new StringBuffer();
        for (int i = nP1; i <=nP2 ; i++) {
            sb.append(m_bits[i]);
        }
        return TurnBitsAndString.getIntForByte(sb.toString());
    }

}
