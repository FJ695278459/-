/*
 * 教室类
 * liug@ScitLiugTeam 2020.06.24
 */

package com.ScitLiugTeam.auto_scheduling;

import java.util.HashSet;
import java.util.Set;

public class Classroom {
	//教室资源类型
	public enum ClassroomRes{
		SLT_CRES_BLACKBOARD("黑板"), //黑板
		SLT_CRES_PROJECTOR("投影仪"), //投影仪
		STL_CRES_EARASER("黑板刷"),//黑板擦
		STL_CRES_CHALK("粉笔"),//粉笔
		SLT_CRES_SPEECH("语音室"), //语音室
		SLT_CRES_PHYLAB("物理实验室"), //物理实验
		SLT_CRES_COMPUTER("电脑机房"), //电脑机房
		SLT_CRES_CHEMISTRY("化学实验室"),//化学实验室
		SLT_CRES_ANATOMY("医学解剖实验室"),//医学解剖实验室
		STL_CRES_BIOLOGY("生物实验室"),//生物实验室
		STL_CRES_NURSE("护理实训室"),//护理实训室
		STL_CRES_ELECTOR("机电实训室"),//几点实训室
		STL_CRES_CAR("汽车实训室"),//汽车实训室
		SLT_CRES_NUM("无意义"); //无意义
		ClassroomRes(String Roomres) {this.RoomRes=Roomres;}
		ClassroomRes(){}
		private String RoomRes;
		public String getRoomRes() {return RoomRes;}
		public void setRoomRes(String RoomRes) {this.RoomRes=RoomRes;}

	}

	//教室资源
	private Set<ClassroomRes> m_stResources = new HashSet<ClassroomRes>();
	//教室名，比如：6-404
	private String m_sName;
	//教室ID,编号
	private int m_nID;
	//可容纳学生数
	private int m_Studentnumber;
	//返回教室资源
	public Set<ClassroomRes> getM_stResources() {return m_stResources;}
	//教室资源赋值
	public  void setM_stResources(Set<ClassroomRes> m_stResources) {this.m_stResources=m_stResources;}
	//返回教室名字
	public String getM_sName() {return  m_sName;}
	//教室名字赋值
	public void setM_sName(String name) {this.m_sName=name;}
	//返回教室编号
	public int getM_nID() {return m_nID;}
	//教室id赋值
	public void setM_nID(int id) {this.m_nID=id;}
	//返回教室可容纳学生数
	public int getM_Studentnumber() {return m_Studentnumber;}
	//教室可容纳学生数赋值
	public void setM_Studentnumber(int m_Studentnumber) {this.m_Studentnumber=m_Studentnumber;}

	//TODO: 完善本类的数据读写，包括：从文件室资源中读取全部教，其他类访问接口



}
