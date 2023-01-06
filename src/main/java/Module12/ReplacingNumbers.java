package Module12;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ReplacingNumbers {

    public ArrayList<Integer> numbersLine (int n){
        ArrayList<Integer> line = new ArrayList<>();
        for (int i = 1; i <= n; i ++){
            line.add(i);
        }
        return line;
    }

    public static class Fizz{
        public String replaceWithFizz(int n){
            if (n % 3 == 0)
                return "fizz";
            return String.valueOf(n);
        }
    }

    public static class ThreadA implements Callable<String> {
        private final int n;

        public ThreadA(int n) {
            this.n = n;
        }

        Fizz fizz = new Fizz();

        @Override
        public String call() {
            return fizz.replaceWithFizz(n);
        }
    }

    public static class Buzz{
        public String replaceWithBuzz(int n){
            if (n % 5 == 0)
                return "buzz";
            return String.valueOf(n);
        }
    }

    public static class ThreadB implements Callable<String> {
        private final int n;

        public ThreadB(int n) {
            this.n = n;
        }

        Buzz buzz = new Buzz();

        @Override
        public String call() {
            return buzz.replaceWithBuzz(n);
        }
    }

    public static class FizzBuzz{
        public String replaceWithFizzBuzz(int n){
            if ((n % 3 == 0) && (n % 5 == 0))
                return "fizzbuzz";
            return String.valueOf(n);
        }
    }

    public static class ThreadC implements Callable<String> {
        private final int n;

        public ThreadC(int n) {
            this.n = n;
        }

        FizzBuzz fizzbuzz = new FizzBuzz();

        @Override
        public String call() {
            return fizzbuzz.replaceWithFizzBuzz(n);
        }
    }

//    public void number(){
//
//    }

}
