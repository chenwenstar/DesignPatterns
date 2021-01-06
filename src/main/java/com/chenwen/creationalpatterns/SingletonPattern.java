package com.chenwen.creationalpatterns;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 单例
 * @author chen.jw
 * @date 2021/1/6 15:28
 */
public class SingletonPattern {
    private static SingletonPattern instance = null;

    private SingletonPattern(){
    }

    public static SingletonPattern getInstance() {
         //double check
        if (null==instance) {
            synchronized (SingletonPattern.class){
                if (null==instance) {
                    System.out.println("-----------new class:----------"+Thread.currentThread());
                    instance=new SingletonPattern();
                }
                return instance;
            }

        }
        return instance;
    }

    private static final int NUM=100;
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for(int i=0;i<NUM;i++){
            es.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程："+Thread.currentThread()+":"+SingletonPattern.getInstance());
                }
            });
        }
        es.shutdown();
    }
}
