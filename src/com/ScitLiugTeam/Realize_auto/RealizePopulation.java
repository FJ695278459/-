/*
 * ��Ⱥ
 * @���
 * @2020/8/19
 */


package com.ScitLiugTeam.Realize_auto;

import com.ScitLiugTeam.auto_scheduling.Bits;
import com.ScitLiugTeam.auto_scheduling.Individual;
import com.ScitLiugTeam.auto_scheduling.Population;
import com.conpara.ConPara;
import com.multithreaded.MyThread;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class RealizePopulation extends Population {
    private double fitnesses;//��Ⱥ���и�������ܺ�
    private final double vriation=0.01;//������
    private final double crossover=0.6;//������

    //�õ���Ⱥ
    @Override
    public List<Individual> getList() {
        return m_vdIndividuals;
    }

    //  ����õ���һ����Ⱥ
    @Override
    public void setBitsSet(int n) {
        //1000������
        fitnesses=0;
        for (int i = 0; i <n ; i++) {
            Individual individual=new RealizeIndividual();
            individual.randInitialize();
            //����������һ��ʱ��������
            m_vdIndividuals.add(individual);
            System.out.println(Thread.currentThread().getName()+"��"+(i+1)+"������---->>>>"+(i+1)+"-->>������"+individual.getScore());
            fitnesses+=individual.getScore();
        }
    }

    //������Ⱥ���д��
    @Override
    public void score(List<Individual> ind) throws IOException {
        //��Ⱥ���������´��
        fitnesses=0;

        //����
        for (int i = 0; i < ind.size(); i++) {
            ind.get(i).score();
            //�������Ϊ0�����α����ϣ������ſΣ���������ƣ����
            if(ind.get(i).getScore()==0){
                ind.get(i).getBits().fromString(Coding.Total());
                ind.get(i).score();
            }
//            System.out.println("---------->>������"+ind.get(i).getScore());
            fitnesses+=ind.get(i).getScore();
        }
        //��Ӧ��
    }


    /**/
    //����ÿ������ĵ÷֣�ͨ�����̶ķ�ʽ����������һ��
    @Override
    public void generateNextGeneration() {

        int n=ConPara.NUM-1;

        //��һ������Ⱥ
        List<Individual> next=new ArrayList<>();

        //�����һ�����Ÿ���
        next.add(getMax());

        //�����ɽ�����죬������һ��
        for (int i = 0; i <n; i++) {
            Cosses(next);
        }

        //�����һ��
        m_vdIndividuals.clear();
        m_vdIndividuals=next;
    }

    /**/


    //�������
    public Individual getMax(){
        Individual ind=new RealizeIndividual();
        m_dBestIndividual=m_vdIndividuals.get(0);
        for (Individual m_vdIndividual : m_vdIndividuals) {
            m_dBestIndividual=m_vdIndividual.getScore()>=m_dBestIndividual.getScore()?m_vdIndividual:m_dBestIndividual;
        }
        ind.copyFrom(m_dBestIndividual);
        return ind;
    }

    //��ȡ���Ÿ���
    @Override
    public Individual getBestIndividual() {
        m_dBestIndividual=m_vdIndividuals.get(0);
        for (Individual m_vdIndividual : m_vdIndividuals) {
            m_dBestIndividual=m_vdIndividual.getScore()>=m_dBestIndividual.getScore()?m_vdIndividual:m_dBestIndividual;
        }
        return m_dBestIndividual;
    }
    //��������
    protected void Cosses(List<Individual> rap){
        Random ra=new Random();
        //��һ������
        Individual p1;
        Individual p2;

        //ͨ�����̶�ѡ�񸸱�
        p1=Choose();
        while(true){
            p2=Choose();
            if(p1.getScore()!=p2.getScore()) {
                break;
            }
        }
        //���棬0.6
       if(Math.random()<crossover){
           //����λ��
           int np1=ra.nextInt(p1.getBits().getM_bits().length);
           int np2;
           while (true){
               np2=ra.nextInt(p1.getBits().getM_bits().length);
               if(np1<np2){
                   break;
               }
           }

           //����
           p1.getBits().cross(p1.getBits(), p2.getBits(), np1, np2);
       }
        //����
        turnBit(p1);
        turnBit(p2);

        rap.add(p1);
    }

    //ѡ�����ӣ��������̶�ѡ�񸸱�
    protected Individual Choose(){
        double num=0;
        double rand=Math.random();
        for (Individual m_vdIndividual : m_vdIndividuals) {
            num+=m_vdIndividual.getScore()/fitnesses;
            if(rand<num){
                return  m_vdIndividual;
            }
        }
        System.out.println("��");
        return  null;
    }

    protected void turnBit(Individual p1){
        //����
        Random ra=new Random();
        //�������3λ
        if(vriation>Math.random()){
            for (int i = 0; i <4 ; i++) {
                int turn=ra.nextInt(p1.getBits().getM_bits().length);
//                System.out.println("��"+turn+"λ����");
                p1.getBits().negate(turn);
            }
        }
        ra=null;
    }
}
