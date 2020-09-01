/*
 * 大类课程类
 * liug@ScitLiugTeam 2020.06.24
 */

package com.ScitLiugTeam.auto_scheduling;

import java.util.*;

public class CourseBase {
	//课程所需资源
	protected Set<Classroom.ClassroomRes> m_dResourcesNeeded = new HashSet<>();
	//课程名称
	private String m_sCourseBaseName;
	//课程ID
	private int m_nID;
	//返回课程名字
	public String getBaseName(){return  m_sCourseBaseName;}
	//课程名字赋值
	public void steBaseName(String Name) {this.m_sCourseBaseName=Name;}
	//获得课程ID
	public int getID(){return  m_nID;}
	//课程ID赋值
	public void setID(int id) {this.m_nID=id;}
	//得到课程所需要的资源
	public Set<Classroom.ClassroomRes> getCouresNeede(){return  m_dResourcesNeeded;}
	//课程所需要的资源赋值
	public void setCourseNeede(Set<Classroom.ClassroomRes> Courseneed) {this.m_dResourcesNeeded=Courseneed;}

}
