/*
 * ����γ���
 * liug@ScitLiugTeam 2020.06.24
 */

package com.ScitLiugTeam.auto_scheduling;

import java.util.*;

public class CourseBase {
	//�γ�������Դ
	protected Set<Classroom.ClassroomRes> m_dResourcesNeeded = new HashSet<>();
	//�γ�����
	private String m_sCourseBaseName;
	//�γ�ID
	private int m_nID;
	//���ؿγ�����
	public String getBaseName(){return  m_sCourseBaseName;}
	//�γ����ָ�ֵ
	public void steBaseName(String Name) {this.m_sCourseBaseName=Name;}
	//��ÿγ�ID
	public int getID(){return  m_nID;}
	//�γ�ID��ֵ
	public void setID(int id) {this.m_nID=id;}
	//�õ��γ�����Ҫ����Դ
	public Set<Classroom.ClassroomRes> getCouresNeede(){return  m_dResourcesNeeded;}
	//�γ�����Ҫ����Դ��ֵ
	public void setCourseNeede(Set<Classroom.ClassroomRes> Courseneed) {this.m_dResourcesNeeded=Courseneed;}

}
