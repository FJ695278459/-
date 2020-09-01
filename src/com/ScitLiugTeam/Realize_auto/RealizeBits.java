/*
*   Bits抽象类实现类，Bits子类
*    @冯杰
 *   @2020/8/16
* */

package com.ScitLiugTeam.Realize_auto;

import com.ScitLiugTeam.auto_scheduling.Bits;

public class RealizeBits extends Bits {
    //新建长度为n的位数组。注意：这个n是二进制序列实体的长度。总的二进制理论长度是n+16，而实际总长度应该是ceil((n+16)/8.0)*8
    @Override
    public void newBits(int n) {
        byte[] bytes=new byte[n];
        m_bits=bytes;
    }
    //得到该byte[]
    @Override
    public byte[] getM_bits() {
        return this.m_bits;
    }

    //获取m_bits数组长度，也就是HEAD代表的整数
    @Override
    public int length() {
        return m_bits.length;
    }

    //根据01字符串新建二进制序列，字符串是包含了HEAD的
    @Override
    public void fromString(String sBits) {
        //String转成byte[]
        m_bits=TurnBitsAndString.getArresBytesForString(sBits);
    }

    //复制
    @Override
    public Bits copy() {
        //创建新对象
        RealizeBits bit=new RealizeBits();
        bit.newBits(m_bits.length);
        String str=TurnBitsAndString.getStringToArresByte(m_bits);
        //给新对象的byte[]赋值
        bit.fromString(str);
        return bit;
    }
    //将第p1（包含）到第p2（包含）位之间的值设为nVal。调用者自行确保p2>p1>=0，且位数足够，不会溢出。
    //p1与p2表示的是二进制实体中的位置，不包括HEAD
    @Override
    public void assign(int nP1, int nP2, int nVal) {
        if(nP2<nP1||nP1<=0){
            System.out.println("错误");
            return;
        }
        for (int i = nP1; i <nP2 ; i++) {
            m_bits[i]= (byte) nVal;
        }
    }
    //获取第p1（包含）到第p2（包含）位之间的值
    @Override
    public int getValue(int nP1, int nP2) {
        StringBuffer sb=new StringBuffer();
        for (int i = nP1; i <nP2 ; i++) {
            sb.append(m_bits[i]);
        }
//        System.out.println("-->>"+sb.toString());
        return TurnBitsAndString.getIntForByte(sb.toString());
    }
    //将第p位取反,变异
    @Override
    public void negate(int nP) {
        if(m_bits[nP]==0){
            m_bits[nP]=1;
        }else if(m_bits[nP]==1){
            m_bits[nP]=0;
        }
    }
    //返回第np位
    public  byte getNp(int np){
        return m_bits[np];
    }
    //将第p位设为0或1。nBit只取0或1
    @Override
    public void setBit(int nP, int nBit) {
        //判断是否位1或0
        m_bits[nP]= (byte) nBit;
    }
    //两个Bits对象交换d第p1位到第p2位之间的数据,双点交叉
    @Override
    public void cross(Bits bitsA, Bits bitsB, int nP1, int nP2) {
        byte[] bytes1=bitsA.getM_bits();
        byte[] bytes2=bitsB.getM_bits();
        //交换值
        for (int i = nP1; i <=nP2 ; i++) {
            byte Tmp=bytes1[i];
            bytes1[i]=bytes2[i];
            bytes2[i]=Tmp;
        }
    }

    //两个Bits对象第p位交叉。交叉算法是：与运算结果给A、或运算结果给B
    @Override
    public void cross(Bits bitsA, Bits bitsB, int nP) {
        byte[] bytes1=bitsA.getM_bits();
        byte[] bytes2=bitsB.getM_bits();
        //交叉
        for (int i = 0; i <=nP ; i++) {
            byte Tmp=bytes1[i];
            bytes1[i]=bytes2[i];
            bytes2[i]=Tmp;
        }
    }
    //将第p1（包含）到第p2（包含）位之间的值倒序
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
    //将数组打印为可视01字符串，
    @Override
    public String toString() {
        String str=TurnBitsAndString.getStringToArresByte(m_bits);
        System.out.println(str);
        return str;
    }
}
