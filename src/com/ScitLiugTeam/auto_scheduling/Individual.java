/*
 * 遗传算法之个体接口
 * 每个个体代表一个基因序列，它应该能够直接转化为问题的解。任何实现该接口的具体类都应该实现对问题的基因编码以及将基因编码表达为问题解
 * liug@ScitLiugTeam 2020.6.25
 */

package com.ScitLiugTeam.auto_scheduling;

import com.ScitLiugTeam.Realize_auto.RealizeBits;
import com.ScitLiugTeam.Realize_auto.RealizeIndividual;

public interface Individual {

	public Bits getBits();
	//随机初始化
	public void randInitialize();
	//复制另外一个个体
	public void copyFrom(Individual ind);
	//判断本基因组代表的解是否合法，合法返回true，不合法false
	public boolean isLegal();
	//本基因组的长度
	public int length();
	//将本基因组解码为问题的解
	public Solution decode();
	//给始本基因组打分。这是初的打分
	public void score();
	//给本基因组设置得分。这是根据种群个体整体情况对分数进行归一化之后重新设置分数
	public void setScore(double fScore);
	//获取本基因组的得分
	public double getScore();
	//打印二进制信息
	public String toString();
}
