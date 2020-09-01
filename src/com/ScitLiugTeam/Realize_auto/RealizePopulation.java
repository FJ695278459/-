/*
 * 种群
 * @冯杰
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
    private double fitnesses;//总群所有个体分数总和
    private final double vriation=0.01;//变异率
    private final double crossover=0.6;//交叉率

    //得到种群
    @Override
    public List<Individual> getList() {
        return m_vdIndividuals;
    }

    //  随机得到第一代总群
    @Override
    public void setBitsSet(int n) {
        //1000个个体
        fitnesses=0;
        for (int i = 0; i <n ; i++) {
            Individual individual=new RealizeIndividual();
            individual.randInitialize();
            //当两个课题一样时，不计入
            m_vdIndividuals.add(individual);
            System.out.println(Thread.currentThread().getName()+"第"+(i+1)+"个个体---->>>>"+(i+1)+"-->>分数："+individual.getScore());
            fitnesses+=individual.getScore();
        }
    }

    //对新种群进行打分
    @Override
    public void score(List<Individual> ind) throws IOException {
        //种群分数需重新打分
        fitnesses=0;

        //分数
        for (int i = 0; i < ind.size(); i++) {
            ind.get(i).score();
            //如果分数为0，即课表不符合，重新排课，编译二进制，打分
            if(ind.get(i).getScore()==0){
                ind.get(i).getBits().fromString(Coding.Total());
                ind.get(i).score();
            }
//            System.out.println("---------->>分数："+ind.get(i).getScore());
            fitnesses+=ind.get(i).getScore();
        }
        //适应度
    }


    /**/
    //根据每个个体的得分，通过轮盘赌方式交叉生成下一代
    @Override
    public void generateNextGeneration() {

        int n=ConPara.NUM-1;

        //下一代，种群
        List<Individual> next=new ArrayList<>();

        //添加上一代最优个体
        next.add(getMax());

        //个体由交叉变异，生成下一代
        for (int i = 0; i <n; i++) {
            Cosses(next);
        }

        //清空上一代
        m_vdIndividuals.clear();
        m_vdIndividuals=next;
    }

    /**/


    //获得最大解
    public Individual getMax(){
        Individual ind=new RealizeIndividual();
        m_dBestIndividual=m_vdIndividuals.get(0);
        for (Individual m_vdIndividual : m_vdIndividuals) {
            m_dBestIndividual=m_vdIndividual.getScore()>=m_dBestIndividual.getScore()?m_vdIndividual:m_dBestIndividual;
        }
        ind.copyFrom(m_dBestIndividual);
        return ind;
    }

    //获取最优个体
    @Override
    public Individual getBestIndividual() {
        m_dBestIndividual=m_vdIndividuals.get(0);
        for (Individual m_vdIndividual : m_vdIndividuals) {
            m_dBestIndividual=m_vdIndividual.getScore()>=m_dBestIndividual.getScore()?m_vdIndividual:m_dBestIndividual;
        }
        return m_dBestIndividual;
    }
    //交叉算子
    protected void Cosses(List<Individual> rap){
        Random ra=new Random();
        //第一个父本
        Individual p1;
        Individual p2;

        //通过轮盘赌选择父本
        p1=Choose();
        while(true){
            p2=Choose();
            if(p1.getScore()!=p2.getScore()) {
                break;
            }
        }
        //交叉，0.6
       if(Math.random()<crossover){
           //交叉位置
           int np1=ra.nextInt(p1.getBits().getM_bits().length);
           int np2;
           while (true){
               np2=ra.nextInt(p1.getBits().getM_bits().length);
               if(np1<np2){
                   break;
               }
           }

           //交叉
           p1.getBits().cross(p1.getBits(), p2.getBits(), np1, np2);
       }
        //变异
        turnBit(p1);
        turnBit(p2);

        rap.add(p1);
    }

    //选择算子，运用轮盘赌选择父本
    protected Individual Choose(){
        double num=0;
        double rand=Math.random();
        for (Individual m_vdIndividual : m_vdIndividuals) {
            num+=m_vdIndividual.getScore()/fitnesses;
            if(rand<num){
                return  m_vdIndividual;
            }
        }
        System.out.println("空");
        return  null;
    }

    protected void turnBit(Individual p1){
        //变异
        Random ra=new Random();
        //随机变异3位
        if(vriation>Math.random()){
            for (int i = 0; i <4 ; i++) {
                int turn=ra.nextInt(p1.getBits().getM_bits().length);
//                System.out.println("第"+turn+"位变异");
                p1.getBits().negate(turn);
            }
        }
        ra=null;
    }
}
