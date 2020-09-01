
/*
*       @冯杰
*       @2020/8/25
*       适应度函数类，遗传算法的接口，
*       淘汰个体，生成新个体
*       找到最优解
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
    //初始化种群
    public static void Fitnessfun() throws IOException {

        Individual total=new RealizeIndividual();//最终解

        //新建一个种群，
        Population pop=new RealizePopulation();

        //初始化第一代个体，个数有ConPara.NUM个
        pop.setBitsSet(ConPara.NUM);
        total=pop.getBestIndividual();
        //迭代5000此
        for (int i = 0,a=2; i <ConPara.NRXTNUM ;a++ ,i++) {
            System.out.println("第"+(i+1)+"代"+"-->>分数："+total.getScore());

            //交叉，变异，选择，下一代生成
            pop.generateNextGeneration();

            //给新的种群打分打分
            pop.score(pop.getList());

            //获得该代最优个体
            total=pop.getBestIndividual();
            //查看最优解是否满足
            if(total.getScore()>=560){
                break;
            }

            //如果迭代5000次还没有得到达标的个体，就直接用这一代中的最优解作为最终解
            if(i+1==5000){
                System.out.println("可能未找到最优解");
                break;
            }
        }
        System.out.println("找到最优解");

        //解码，打印课表
        Decode.DecodeLesson(total);
        System.out.println("最终分数："+total.getScore());
    }


    //解码给个体打分



}
