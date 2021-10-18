package com.chenwen.behavioralpatterns;

/**
 * @author chen.jw
 * @date 2021/10/18 14:34
 */
public class StrategyPattern {
    public interface Strategy {
        public int doOperation(int num1, int num2);
    }

    public static class OperationAdd implements Strategy{
        @Override
        public int doOperation(int num1, int num2) {
            return num1 + num2;
        }
    }

    public static class OperationSubtract implements Strategy{
        @Override
        public int doOperation(int num1, int num2) {
            return num1 - num2;
        }
    }

    public static class Context {
        private Strategy strategy;

        public Context(Strategy strategy){
            this.strategy = strategy;
        }

        public int executeStrategy(int num1, int num2){
            return strategy.doOperation(num1, num2);
        }
    }

    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        // Context context = new Context(new new OperationSubtract());
        int i = context.executeStrategy(1, 2);
        System.out.println(i);
    }
}
