/*
 * ����������
 * ���ǵĻ��򶼱��Ϊ���������У����������Ҫ����ʵ���������ࡣ���ļ�������ǳ����࣬��Ҫ����ʵ�֡�
 * liug@ScitLiugTeam 2020.6.25
 */

package com.ScitLiugTeam.auto_scheduling;

public abstract class Bits {
	//ʹ��byte�����������������С����鳤��Ӧ�ÿɱ䣬ʵ�����鳤�ȿɱ�ķ������£������������Ҫ��m_bits���ȱ�Ϊ10:
	//byte[] tempBits = new byte[10];
	//m_bits = tempBits;
	//ǰ16λ��Ҳ����2��byte������һ�����������������ʾm_bits������ܳ��ȡ����ǳ���16λΪHEAD
	//���Ǻ��潲�Ķ��������е�iλ�����i��������ΪHEAD��ǰ16λ��
	protected byte[] m_bits = new byte[0];
	public abstract byte[] getM_bits();
	//�½�����Ϊn��λ���顣ע�⣺���n�Ƕ���������ʵ��ĳ��ȡ��ܵĶ��������۳�����n+16����ʵ���ܳ���Ӧ����ceil((n+16)/8.0)*8
	public abstract void newBits(int n);
	//����01�ַ����½����������У��ַ����ǰ�����HEAD��
	public abstract void fromString(String sBits);
	//��ȡm_bits���鳤�ȣ�Ҳ����HEAD���������
	public abstract int length();
	//���ص�npλ��
	public abstract byte getNp(int np);
	//����
	public abstract Bits copy();
	//����p1������������p2��������λ֮���ֵ��ΪnVal������������ȷ��p2>p1>=0����λ���㹻�����������
	//p1��p2��ʾ���Ƕ�����ʵ���е�λ�ã�������HEAD
	public abstract void assign(int nP1, int nP2, int nVal);
	//��ȡ��p1������������p2��������λ֮���ֵ
	public abstract int getValue(int nP1, int nP2);
	//����p1������������p2��������λ֮���ֵ����
	public abstract void reverse(int nP1, int nP2);
	//����pλ��Ϊ0��1��nBitֻȡ0��1
	public abstract void setBit(int nP, int nBit);
	//����pλȡ��
	public abstract void negate(int nP);
	//����Bits���󽻻�d��p1λ����p2λ֮�������
	public abstract void cross(Bits bitsA, Bits bitsB, int nP1, int nP2);
	//����Bits�����pλ���档�����㷨�ǣ�����������A������������B
	public abstract void cross(Bits bitsA, Bits bitsB, int nP);
	//�������ӡΪ����01�ַ�����
	public abstract String toString();
}
