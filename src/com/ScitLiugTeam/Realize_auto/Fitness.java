
/*
*       @���
*       @2020/8/25
*       ��Ӧ�Ⱥ����࣬�Ŵ��㷨�Ľӿڣ�
*       ��̭���壬�����¸���
*       �ҵ����Ž�
*
*
* */

package com.ScitLiugTeam.Realize_auto;

import com.ScitLiugTeam.auto_scheduling.*;
import com.conpara.ConPara;


import java.io.IOException;

import java.util.List;
import java.util.Map;

public class Fitness {
    //��ʼ����Ⱥ
    public static void Fitnessfun() throws IOException {

        Individual total=new RealizeIndividual();//���ս�

        //�½�һ����Ⱥ��
        Population pop=new RealizePopulation();

        //��ʼ����һ�����壬������ConPara.NUM��
        pop.setBitsSet(ConPara.NUM);
        total=pop.getBestIndividual();
        //����5000��
        for (int i = 0,a=2; i <ConPara.NRXTNUM ;a++ ,i++) {
            System.out.println("��"+(i+1)+"��"+"-->>������"+total.getScore());

            //���棬���죬ѡ����һ������
            pop.generateNextGeneration();

            //���µ���Ⱥ��ִ��
            pop.score(pop.getList());

            //��øô����Ÿ���
            total=pop.getBestIndividual();
            //�鿴���Ž��Ƿ�����
            if(total.getScore()>=560){
                break;
            }

            //�������5000�λ�û�еõ����ĸ��壬��ֱ������һ���е����Ž���Ϊ���ս�
            if(i+1==5000){
                System.out.println("����δ�ҵ����Ž�");
                break;
            }
        }
        System.out.println("�ҵ����Ž�");

        //���룬��ӡ�α�
        Decode.DecodeLesson(total);
        System.out.println("���շ�����"+total.getScore());
    }


    //�����������



}
