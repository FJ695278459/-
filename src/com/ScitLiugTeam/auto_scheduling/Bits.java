/*
 * 二进制序列
 * 我们的基因都表达为二进制序列，因此我们需要首先实现这样的类。本文件定义的是抽象类，需要具体实现。
 * liug@ScitLiugTeam 2020.6.25
 */

package com.ScitLiugTeam.auto_scheduling;

public abstract class Bits {
	//使用byte数组来表达二进制序列。数组长度应该可变，实现数组长度可变的方法如下：比如接下来需要把m_bits长度变为10:
	//byte[] tempBits = new byte[10];
	//m_bits = tempBits;
	//前16位（也就是2个byte）代表一个整数，这个整数揭示m_bits数组的总长度。我们称这16位为HEAD
	//我们后面讲的二进制序列第i位，这个i不包括作为HEAD的前16位。
	protected byte[] m_bits = new byte[0];
	public abstract byte[] getM_bits();
	//新建长度为n的位数组。注意：这个n是二进制序列实体的长度。总的二进制理论长度是n+16，而实际总长度应该是ceil((n+16)/8.0)*8
	public abstract void newBits(int n);
	//根据01字符串新建二进制序列，字符串是包含了HEAD的
	public abstract void fromString(String sBits);
	//获取m_bits数组长度，也就是HEAD代表的整数
	public abstract int length();
	//返回第np位数
	public abstract byte getNp(int np);
	//复制
	public abstract Bits copy();
	//将第p1（包含）到第p2（包含）位之间的值设为nVal。调用者自行确保p2>p1>=0，且位数足够，不会溢出。
	//p1与p2表示的是二进制实体中的位置，不包括HEAD
	public abstract void assign(int nP1, int nP2, int nVal);
	//获取第p1（包含）到第p2（包含）位之间的值
	public abstract int getValue(int nP1, int nP2);
	//将第p1（包含）到第p2（包含）位之间的值倒序
	public abstract void reverse(int nP1, int nP2);
	//将第p位设为0或1。nBit只取0或1
	public abstract void setBit(int nP, int nBit);
	//将第p位取反
	public abstract void negate(int nP);
	//两个Bits对象交换d第p1位到第p2位之间的数据
	public abstract void cross(Bits bitsA, Bits bitsB, int nP1, int nP2);
	//两个Bits对象第p位交叉。交叉算法是：与运算结果给A、或运算结果给B
	public abstract void cross(Bits bitsA, Bits bitsB, int nP);
	//将数组打印为可视01字符串，
	public abstract String toString();
}
