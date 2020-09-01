/*
 * ��Ⱥ
 * liug@ScitLiugTeam 2020.6.25
 */

package com.ScitLiugTeam.auto_scheduling;
import com.ScitLiugTeam.auto_scheduling.Individual;

import java.io.IOException;
import java.util.*;

public abstract class Population {
	//��Ⱥ��ȫ������
	protected List<Individual> m_vdIndividuals = new ArrayList<>();
	public abstract List<Individual> getList();
	//��ʼ����Ⱥ
	public abstract void setBitsSet(int n);
	//���Ÿ���
	protected Individual m_dBestIndividual;
	//����Ⱥ���д��
	public abstract void score(List<Individual> ind) throws IOException;

	//����ÿ������ĵ÷֣�ͨ�����̶ķ�ʽ����������һ��
	public abstract void generateNextGeneration();
	//��ȡ���Ÿ���
	public abstract Individual getBestIndividual();
}
