/*
 * 种群
 * liug@ScitLiugTeam 2020.6.25
 */

package com.ScitLiugTeam.auto_scheduling;
import com.ScitLiugTeam.auto_scheduling.Individual;

import java.io.IOException;
import java.util.*;

public abstract class Population {
	//种群的全部个体
	protected List<Individual> m_vdIndividuals = new ArrayList<>();
	public abstract List<Individual> getList();
	//初始化种群
	public abstract void setBitsSet(int n);
	//最优个体
	protected Individual m_dBestIndividual;
	//对种群进行打分
	public abstract void score(List<Individual> ind) throws IOException;

	//根据每个个体的得分，通过轮盘赌方式交叉生成下一代
	public abstract void generateNextGeneration();
	//获取最优个体
	public abstract Individual getBestIndividual();
}
