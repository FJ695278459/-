/*
*   开启多线程
*   @超级机甲暴龙
*   @2020/8/31
*
* */

package com.multithreaded;

import com.ScitLiugTeam.Realize_auto.RealizeIndividual;
import com.ScitLiugTeam.Realize_auto.RealizePopulation;
import com.ScitLiugTeam.auto_scheduling.Individual;
import com.ScitLiugTeam.auto_scheduling.Population;
import com.conpara.ConPara;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread implements Runnable {
    public String name;
    private int count=ConPara.NUM;
    private int x=1;
    Lock ne=new ReentrantLock();
    public MyThread(){}
    public MyThread(String name){
        this.name=name;
    }

    @Override
    public void run() {
        System.out.println(count+"---------------"+Thread.currentThread().getName());
        //新建一个种群，
        //初始化第一代个体，个数有ConPara.NUM个
        while (count>0){
            ne.lock();
            if(count>0) {
                Individual individual=new RealizeIndividual();
                individual.randInitialize();
                //当两个课题一样时，不计入
                System.out.println(Thread.currentThread().getName()+"第"+x+"个个体---->>>>"+x+"-->>分数："+individual.getScore());
                x++;
                count--;
//                System.out.println(Thread.currentThread().getName() + "-->>" + count--);

            }
            ne.unlock();

        }
    }

//        x=0;
//        System.out.println(x+"-->>x");
//        for (int i = 0; i <5 ; i++) {
//            System.out.println(Thread.currentThread().getName()+"-->>"+count--+"--->>x:"+x++);
//
//        }

}
