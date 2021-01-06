package com.chenwen.behavioralpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者
 * @author chen.jw
 * @date 2021/1/6 14:45
 */
public class ObserverPattern {
    public static class Subject{
        private final List<Observer> observerList=new ArrayList <>();
        private int state;

        public void setState(int state) {
            this.state = state;
            notifyObservers();
        }
        private void notifyObservers(){
            observerList.forEach(observer->observer.readMessage(state));
        }
    }

    public interface Observer{
        /**
         * 观察者状态
         * @param state 状态
         */
        void readMessage(int state);
    }

    public static class Aobserver implements Observer{
        public Aobserver(Subject subject){
            subject.observerList.add(this);
        }
        @Override
        public void readMessage(int state) {
            System.out.println("Aobserver,消费消息："+state);
        }
    }

    public static class Bobserver implements Observer{
        public Bobserver(Subject subject){
            subject.observerList.add(this);
        }
        @Override
        public void readMessage(int state) {
            System.out.println("Bobserver,消费消息："+state);
        }
    }

    public static void main(String[] args) {
        Subject subject = new Subject();
        new Aobserver(subject);
        new Bobserver(subject);
        //修改状态
        subject.setState(1);
    }
}
