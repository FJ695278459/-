/*
 * ��ʦ��
 * liug@ScitLiugTeam 2020.06.24
 */

package com.ScitLiugTeam.auto_scheduling;

import java.util.*;

public class Teacher {


	public enum TeacherTend{
		SLT_TT_CONCENT("�����ܼ���"), //�����ܼ���
		SLT_TT_SCATTER("�����ܷ�ɢ"), //�����ܷ�ɢ
		SLT_TT_UNDEF("����ν"); //����ν

		private  String Tend;
		TeacherTend(){}
		TeacherTend(String Tend) {this.Tend=Tend;}
		//�õ�����
		public void setTend(String Tend) { this.Tend=Tend; }
		//����ֵ
		public String getTend(){return Tend;}

	}
	public enum SkipHours{
		SLT_SH_MONDAY("��ϲ����һ�Ͽ�"),  //��ϲ����һ�Ͽ�
		SLT_SH_TUESDAY("��ϲ���ܶ��Ͽ�"),  //��ϲ���ܶ��Ͽ�
		SLT_SH_WEDNESDAY("��ϲ�������Ͽ�"),  //��ϲ�������Ͽ�
		SLT_SH_THURSDAY("��ϲ�������Ͽ�"),  //��ϲ�������Ͽ�
		SLT_SH_FRIDAY("��ϲ�������Ͽ�"),  //��ϲ�������Ͽ�
		SLT_SH_SATURDAY("��ϲ�������Ͽ�"),  //��ϲ�������Ͽ�
		SLT_SH_NIGHT("��ϲ�������Ͽ�"),  //��ϲ�������Ͽ�
		SLT_SH_UNDEF("����ν");  //����ν
		private String Phours;
		SkipHours(){}
		SkipHours( String Phousr) { this.Phours=Phousr;}
		//�õ�����
		public String getPhours() {return Phours;}
		//����ֵ
		public void setPhours(String Phours) {this.Phours=Phours;}

	}

	//��ʦ�ı��
	private int m_nID;
	//��ʦ�Ĺ���
	private String m_sEmployeeNum;
	//��ʦ������
	private String m_sName;
	//�����γ̣������ǿγ̵�ID������Ŀγ���Course������CourseBase
	private Set<Integer> m_stRegCourses = new HashSet<>();
	//�ɴ��γ̡�Key��CourseBase��ID��Value����ʦ�Ըÿγ̵���Ϥ�̶ȴ�֣���0��1������ļ���û�У����ǾͰ����ļ�����˳����ǰ��1����ĩ��0���м��ֵ
	private Map<Integer, Double> m_mpAvaCourses = new HashMap<>(); 
	//��ʦ������
	private TeacherTend m_dTend ;

	private Set<SkipHours> m_stSkipHours = new HashSet<>();

	//������ʦ���
	public int getID(){return  m_nID;}
	//��ʦ��Ÿ�ֵ
	public void setID(int id) {this.m_nID=id;}
	//��ʦ����
	public String getm_sEmployeeNum() { return m_sEmployeeNum;}
	//��ʦ���Ÿ�ֵ
	public void setM_sEmployeeNum(String num) {this.m_sEmployeeNum=num;}
	//������ʦ����
	public String getName() {return  m_sName;}
	//��ʦ���ָ�ֵ
	public void setNmame(String Name) { this.m_sName=Name;}
	//������ʦ�����γ̱��
	public Set<Integer> getM_stRegCourses() { return m_stRegCourses; }
	//��ʦ�����γ̱�Ÿ�ֵ
	public void  setM_stReCourses(Set<Integer> Courses) {this.m_stRegCourses=Courses;}
	//������ʦ�ɴ��γ�
	public Map<Integer, Double> getM_mpAvaCourses() { return m_mpAvaCourses; }
	//��ʦ�ɴ��γ̱�Ÿ�ֵ
	public void setM_mpAvaCourses(Map<Integer,Double> mpAvaCourses) {this.m_mpAvaCourses=mpAvaCourses;}
	//������ʦ����_�γ��Ƿ�ֲ�
	public TeacherTend getTeacherTend() {return m_dTend;}
	//��ʦ����ֵ_�γ��Ƿ�ֲ�
	public void setTeacherTend(TeacherTend mdTend) {m_dTend=mdTend;}
	//������ʦ����_ϲ���Ͽε�ʱ���
	public Set<SkipHours> getM_stSkipHours() { return m_stSkipHours; }
	//��ʦ����ֵ_ϲ���Ͽε�ʱ���
	public void setM_stSkipHours(Set<SkipHours> M_stSkipHourse) { this.m_stSkipHours=M_stSkipHourse;}
	//

}
