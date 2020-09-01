/*
 * 具体课程类
 * liug@ScitLiugTeam 2020.06.24
 */

package com.ScitLiugTeam.auto_scheduling;

import java.util.Set;

public class Course extends CourseBase {
	public enum CourseType{
		SLT_CT_PUBCO("公共必修课"), //公共必修课
		SLT_CT_PUBELE("公共选修课"), //公共选修课
		SLT_CT_PROCOM("专业必修课"), //专业必修课
		SLT_CT_PROELE("专业选修课");  //专业选修课
		CourseType(){}
		//带参构造
		CourseType(String nameType) {this.Type=nameType;}
		private String Type;
		public void  setType(String Type) {this.Type=Type;}
		public String getType(){return Type;}

	}
	//本课程编号
	private int m_nID;
	//课程名，比如：大学物理B1
	private String m_sName;
	//周学时
	private int m_nWeeklyClassHours;
	//本学期总学时
	private int m_nTotalClassHours;
	//课程类型
	private CourseType m_dCourseType;
	//得到课程编号
	public int getID() { return m_nID; }
	// 课程编号赋值
	public void setID(int id) { this.m_nID=id; }
	//得到课程名
	public String getCourseName(){ return m_sName;}
	//课程名赋值
	public void setCourseName(String name) { this.m_sName=name;}
	//得到学周时
	public int getWeekClassHours(){return m_nWeeklyClassHours;}
	//学周时赋值
	public void setWeekClassHours(int WeekHous) {this.m_nWeeklyClassHours=WeekHous;}
	//得到本学期总学时
	public int getnTotalClassHourse(){return m_nTotalClassHours;}
	//总学时赋值
	public void setnTotalClassGourse(int nTotaHourse){this.m_nTotalClassHours=nTotaHourse;}
	//得到课程类型
	public CourseType getCourseType(){ return m_dCourseType;}
	//课程类别赋值
	public void setCourseTyoe(CourseType Type) {this.m_dCourseType=Type;}
	//得到课程所需要的资源
	public Set<Classroom.ClassroomRes> getCouresNeede(){return  m_dResourcesNeeded;}
	//课程所需要的资源赋值
	public void setCourseNeede(Set<Classroom.ClassroomRes> Courseneed) {this.m_dResourcesNeeded=Courseneed;}

}
