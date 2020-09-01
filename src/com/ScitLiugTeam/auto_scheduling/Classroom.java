/*
 * ������
 * liug@ScitLiugTeam 2020.06.24
 */

package com.ScitLiugTeam.auto_scheduling;

import java.util.HashSet;
import java.util.Set;

public class Classroom {
	//������Դ����
	public enum ClassroomRes{
		SLT_CRES_BLACKBOARD("�ڰ�"), //�ڰ�
		SLT_CRES_PROJECTOR("ͶӰ��"), //ͶӰ��
		STL_CRES_EARASER("�ڰ�ˢ"),//�ڰ��
		STL_CRES_CHALK("�۱�"),//�۱�
		SLT_CRES_SPEECH("������"), //������
		SLT_CRES_PHYLAB("����ʵ����"), //����ʵ��
		SLT_CRES_COMPUTER("���Ի���"), //���Ի���
		SLT_CRES_CHEMISTRY("��ѧʵ����"),//��ѧʵ����
		SLT_CRES_ANATOMY("ҽѧ����ʵ����"),//ҽѧ����ʵ����
		STL_CRES_BIOLOGY("����ʵ����"),//����ʵ����
		STL_CRES_NURSE("����ʵѵ��"),//����ʵѵ��
		STL_CRES_ELECTOR("����ʵѵ��"),//����ʵѵ��
		STL_CRES_CAR("����ʵѵ��"),//����ʵѵ��
		SLT_CRES_NUM("������"); //������
		ClassroomRes(String Roomres) {this.RoomRes=Roomres;}
		ClassroomRes(){}
		private String RoomRes;
		public String getRoomRes() {return RoomRes;}
		public void setRoomRes(String RoomRes) {this.RoomRes=RoomRes;}

	}

	//������Դ
	private Set<ClassroomRes> m_stResources = new HashSet<ClassroomRes>();
	//�����������磺6-404
	private String m_sName;
	//����ID,���
	private int m_nID;
	//������ѧ����
	private int m_Studentnumber;
	//���ؽ�����Դ
	public Set<ClassroomRes> getM_stResources() {return m_stResources;}
	//������Դ��ֵ
	public  void setM_stResources(Set<ClassroomRes> m_stResources) {this.m_stResources=m_stResources;}
	//���ؽ�������
	public String getM_sName() {return  m_sName;}
	//�������ָ�ֵ
	public void setM_sName(String name) {this.m_sName=name;}
	//���ؽ��ұ��
	public int getM_nID() {return m_nID;}
	//����id��ֵ
	public void setM_nID(int id) {this.m_nID=id;}
	//���ؽ��ҿ�����ѧ����
	public int getM_Studentnumber() {return m_Studentnumber;}
	//���ҿ�����ѧ������ֵ
	public void setM_Studentnumber(int m_Studentnumber) {this.m_Studentnumber=m_Studentnumber;}

	//TODO: ���Ʊ�������ݶ�д�����������ļ�����Դ�ж�ȡȫ���̣���������ʽӿ�



}
