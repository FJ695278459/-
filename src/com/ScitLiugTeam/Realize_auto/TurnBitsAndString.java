
/*
    @���
*   @2020/8/15
*   ������,byte[],String,�໥ת��ת������
*
*   �Լ�һЩ�㷨
*   intת�ɶ�����
*   �����Ʊ��int
* */

package com.ScitLiugTeam.Realize_auto;

import java.util.Random;

import static java.lang.Integer.parseInt;

public class TurnBitsAndString {
    //String����byte[]
    public static byte[] getArresBytesForString(String str){
        String[] sq=str.split("");
        byte[] bytes=new byte[sq.length];
        for (int i = 0; i <sq.length; i++) {
            int Tmp= Integer.parseInt(sq[i]);
            bytes[i]= (byte)Tmp;
        }
        return bytes;
    }
    //byte[]ת����String
    public static String getStringToArresByte(byte[] bytes){
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <bytes.length ; i++) {
            sb.append(String.valueOf(bytes[i]));
        }
        return sb.toString();
    }

    //intת�ɶ����ƣ���byte[] bytes���洢����������
    public static void getByteForInt(byte[] bytes,int bit){
        //�ȳ�ʼ��λ0
        for (int i = 0; i <bytes.length ; i++) {
            bytes[i]=0;
        }
        StringBuffer sb=new StringBuffer();
        //��intת�ɶ�����
        do{
            sb.append(bit%2);
            bit=bit/2;
            if(bit/2==0) sb.append(bit);
        }while (bit/2!=0);
        //��01�ַ�������byte[]����
        byte[] bytes1=TurnBitsAndString.getArresBytesForString(sb.toString());
        for (int i = 0,j=bytes.length-1; i <bytes1.length ; i++,j--) {
            bytes[j]=bytes1[i];
        }
        sb.delete(0,sb.length());

    }
    //Stringת�ɶ����ƣ���byte[] bytes���洢����������
    public static void getByteForInt(byte[] bytes,String str){
        //�ȳ�ʼ��λ0
        for (int i = 0; i <bytes.length ; i++) {
            bytes[i]=0;
        }
        //��intת�ɶ�����

    }

    //�����Ʊ��int,����ΪString
    public static int getIntForByte(String str){
        byte[] bytes=TurnBitsAndString.getArresBytesForString(str);
        int num=0;
        for (int i = 0,j=bytes.length-1; i <bytes.length ; i++,j--) {
            num+=bytes[i]*Math.pow(2,j);
        }
        return num;
    }
    //������ת��int,����Ϊbyte[]
    public static int getIntForByte(byte[] bytes){
        int num=0;
        for (int i = 0,j=bytes.length-1; i <bytes.length ; i++,j--) {
            num+=bytes[i]*Math.pow(2,j);
        }
        return num;
    }
    //��ȡ��p1������������p2��������λ֮���ֵ
    public static int getValue(int nP1, int nP2,byte[] m_bits) {
        StringBuffer sb=new StringBuffer();
        for (int i = nP1; i <=nP2 ; i++) {
            sb.append(m_bits[i]);
        }
        return TurnBitsAndString.getIntForByte(sb.toString());
    }

}
