/*
 * ����γ���
 * liug@ScitLiugTeam 2020.06.24
 */

package com.ScitLiugTeam.auto_scheduling;

import java.util.Set;

public class Course extends CourseBase {
	public enum CourseType{
		SLT_CT_PUBCO("�������޿�"), //�������޿�
		SLT_CT_PUBELE("����ѡ�޿�"), //����ѡ�޿�
		SLT_CT_PROCOM("רҵ���޿�"), //רҵ���޿�
		SLT_CT_PROELE("רҵѡ�޿�");  //רҵѡ�޿�
		CourseType(){}
		//���ι���
		CourseType(String nameType) {this.Type=nameType;}
		private String Type;
		public void  setType(String Type) {this.Type=Type;}
		public String getType(){return Type;}

	}
	//���γ̱��
	private int m_nID;
	//�γ��������磺��ѧ����B1
	private String m_sName;
	//��ѧʱ
	private int m_nWeeklyClassHours;
	//��ѧ����ѧʱ
	private int m_nTotalClassHours;
	//�γ�����
	private CourseType m_dCourseType;
	//�õ��γ̱��
	public int getID() { return m_nID; }
	// �γ̱�Ÿ�ֵ
	public void setID(int id) { this.m_nID=id; }
	//�õ��γ���
	public String getCourseName(){ return m_sName;}
	//�γ�����ֵ
	public void setCourseName(String name) { this.m_sName=name;}
	//�õ�ѧ��ʱ
	public int getWeekClassHours(){return m_nWeeklyClassHours;}
	//ѧ��ʱ��ֵ
	public void setWeekClassHours(int WeekHous) {this.m_nWeeklyClassHours=WeekHous;}
	//�õ���ѧ����ѧʱ
	public int getnTotalClassHourse(){return m_nTotalClassHours;}
	//��ѧʱ��ֵ
	public void setnTotalClassGourse(int nTotaHourse){this.m_nTotalClassHours=nTotaHourse;}
	//�õ��γ�����
	public CourseType getCourseType(){ return m_dCourseType;}
	//�γ����ֵ
	public void setCourseTyoe(CourseType Type) {this.m_dCourseType=Type;}
	//�õ��γ�����Ҫ����Դ
	public Set<Classroom.ClassroomRes> getCouresNeede(){return  m_dResourcesNeeded;}
	//�γ�����Ҫ����Դ��ֵ
	public void setCourseNeede(Set<Classroom.ClassroomRes> Courseneed) {this.m_dResourcesNeeded=Courseneed;}

}
