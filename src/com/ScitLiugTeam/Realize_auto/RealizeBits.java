/*
*   Bits������ʵ���࣬Bits����
*    @���
 *   @2020/8/16
* */

package com.ScitLiugTeam.Realize_auto;

import com.ScitLiugTeam.auto_scheduling.Bits;

public class RealizeBits extends Bits {
    //�½�����Ϊn��λ���顣ע�⣺���n�Ƕ���������ʵ��ĳ��ȡ��ܵĶ��������۳�����n+16����ʵ���ܳ���Ӧ����ceil((n+16)/8.0)*8
    @Override
    public void newBits(int n) {
        byte[] bytes=new byte[n];
        m_bits=bytes;
    }
    //�õ���byte[]
    @Override
    public byte[] getM_bits() {
        return this.m_bits;
    }

    //��ȡm_bits���鳤�ȣ�Ҳ����HEAD���������
    @Override
    public int length() {
        return m_bits.length;
    }

    //����01�ַ����½����������У��ַ����ǰ�����HEAD��
    @Override
    public void fromString(String sBits) {
        //Stringת��byte[]
        m_bits=TurnBitsAndString.getArresBytesForString(sBits);
    }

    //����
    @Override
    public Bits copy() {
        //�����¶���
        RealizeBits bit=new RealizeBits();
        bit.newBits(m_bits.length);
        String str=TurnBitsAndString.getStringToArresByte(m_bits);
        //���¶����byte[]��ֵ
        bit.fromString(str);
        return bit;
    }
    //����p1������������p2��������λ֮���ֵ��ΪnVal������������ȷ��p2>p1>=0����λ���㹻�����������
    //p1��p2��ʾ���Ƕ�����ʵ���е�λ�ã�������HEAD
    @Override
    public void assign(int nP1, int nP2, int nVal) {
        if(nP2<nP1||nP1<=0){
            System.out.println("����");
            return;
        }
        for (int i = nP1; i <nP2 ; i++) {
            m_bits[i]= (byte) nVal;
        }
    }
    //��ȡ��p1������������p2��������λ֮���ֵ
    @Override
    public int getValue(int nP1, int nP2) {
        StringBuffer sb=new StringBuffer();
        for (int i = nP1; i <nP2 ; i++) {
            sb.append(m_bits[i]);
        }
//        System.out.println("-->>"+sb.toString());
        return TurnBitsAndString.getIntForByte(sb.toString());
    }
    //����pλȡ��,����
    @Override
    public void negate(int nP) {
        if(m_bits[nP]==0){
            m_bits[nP]=1;
        }else if(m_bits[nP]==1){
            m_bits[nP]=0;
        }
    }
    //���ص�npλ
    public  byte getNp(int np){
        return m_bits[np];
    }
    //����pλ��Ϊ0��1��nBitֻȡ0��1
    @Override
    public void setBit(int nP, int nBit) {
        //�ж��Ƿ�λ1��0
        m_bits[nP]= (byte) nBit;
    }
    //����Bits���󽻻�d��p1λ����p2λ֮�������,˫�㽻��
    @Override
    public void cross(Bits bitsA, Bits bitsB, int nP1, int nP2) {
        byte[] bytes1=bitsA.getM_bits();
        byte[] bytes2=bitsB.getM_bits();
        //����ֵ
        for (int i = nP1; i <=nP2 ; i++) {
            byte Tmp=bytes1[i];
            bytes1[i]=bytes2[i];
            bytes2[i]=Tmp;
        }
    }

    //����Bits�����pλ���档�����㷨�ǣ�����������A������������B
    @Override
    public void cross(Bits bitsA, Bits bitsB, int nP) {
        byte[] bytes1=bitsA.getM_bits();
        byte[] bytes2=bitsB.getM_bits();
        //����
        for (int i = 0; i <=nP ; i++) {
            byte Tmp=bytes1[i];
            bytes1[i]=bytes2[i];
            bytes2[i]=Tmp;
        }
    }
    //����p1������������p2��������λ֮���ֵ����
    @Override
    public void reverse(int nP1, int nP2) {
        while(nP2>nP1){
            byte Tmp=m_bits[nP1];
            m_bits[nP1]=m_bits[nP2];
            m_bits[nP2]=Tmp;
            nP1++;
            nP2--;
        }
    }
    //�������ӡΪ����01�ַ�����
    @Override
    public String toString() {
        String str=TurnBitsAndString.getStringToArresByte(m_bits);
        System.out.println(str);
        return str;
    }
}
