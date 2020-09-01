/*
 * 教师类
 * liug@ScitLiugTeam 2020.06.24
 */

package com.ScitLiugTeam.auto_scheduling;

import java.util.*;

public class Teacher {


	public enum TeacherTend{
		SLT_TT_CONCENT("尽可能集中"), //尽可能集中
		SLT_TT_SCATTER("尽可能分散"), //尽可能分散
		SLT_TT_UNDEF("无所谓"); //无所谓

		private  String Tend;
		TeacherTend(){}
		TeacherTend(String Tend) {this.Tend=Tend;}
		//得到倾向
		public void setTend(String Tend) { this.Tend=Tend; }
		//倾向赋值
		public String getTend(){return Tend;}

	}
	public enum SkipHours{
		SLT_SH_MONDAY("不喜欢周一上课"),  //不喜欢周一上课
		SLT_SH_TUESDAY("不喜欢周二上课"),  //不喜欢周二上课
		SLT_SH_WEDNESDAY("不喜欢周三上课"),  //不喜欢周三上课
		SLT_SH_THURSDAY("不喜欢周四上课"),  //不喜欢周四上课
		SLT_SH_FRIDAY("不喜欢周五上课"),  //不喜欢周五上课
		SLT_SH_SATURDAY("不喜欢周六上课"),  //不喜欢周六上课
		SLT_SH_NIGHT("不喜欢晚上上课"),  //不喜欢晚上上课
		SLT_SH_UNDEF("无所谓");  //无所谓
		private String Phours;
		SkipHours(){}
		SkipHours( String Phousr) { this.Phours=Phousr;}
		//得到倾向
		public String getPhours() {return Phours;}
		//倾向赋值
		public void setPhours(String Phours) {this.Phours=Phours;}

	}

	//老师的编号
	private int m_nID;
	//老师的工号
	private String m_sEmployeeNum;
	//老师的名字
	private String m_sName;
	//常带课程，参数是课程的ID。这里的课程是Course，不是CourseBase
	private Set<Integer> m_stRegCourses = new HashSet<>();
	//可带课程。Key是CourseBase的ID，Value是老师对该课程的熟悉程度打分，从0到1。如果文件中没有，我们就按照文件排列顺序，最前的1，最末的0，中间插值
	private Map<Integer, Double> m_mpAvaCourses = new HashMap<>(); 
	//老师的倾向
	private TeacherTend m_dTend ;

	private Set<SkipHours> m_stSkipHours = new HashSet<>();

	//返回老师编号
	public int getID(){return  m_nID;}
	//老师编号赋值
	public void setID(int id) {this.m_nID=id;}
	//老师工号
	public String getm_sEmployeeNum() { return m_sEmployeeNum;}
	//老师工号赋值
	public void setM_sEmployeeNum(String num) {this.m_sEmployeeNum=num;}
	//返回老师名字
	public String getName() {return  m_sName;}
	//老师名字赋值
	public void setNmame(String Name) { this.m_sName=Name;}
	//返回老师常带课程编号
	public Set<Integer> getM_stRegCourses() { return m_stRegCourses; }
	//老师常带课程编号赋值
	public void  setM_stReCourses(Set<Integer> Courses) {this.m_stRegCourses=Courses;}
	//返回老师可带课程
	public Map<Integer, Double> getM_mpAvaCourses() { return m_mpAvaCourses; }
	//老师可带课程编号赋值
	public void setM_mpAvaCourses(Map<Integer,Double> mpAvaCourses) {this.m_mpAvaCourses=mpAvaCourses;}
	//返回老师倾向_课程是否分布
	public TeacherTend getTeacherTend() {return m_dTend;}
	//老师倾向赋值_课程是否分布
	public void setTeacherTend(TeacherTend mdTend) {m_dTend=mdTend;}
	//返回老师倾向_喜欢上课的时间段
	public Set<SkipHours> getM_stSkipHours() { return m_stSkipHours; }
	//老师倾向赋值_喜欢上课的时间段
	public void setM_stSkipHours(Set<SkipHours> M_stSkipHourse) { this.m_stSkipHours=M_stSkipHourse;}
	//

}
