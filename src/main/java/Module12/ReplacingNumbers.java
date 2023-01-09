package Module12;

public class ReplacingNumbers {
    static int count;

    static class Control {
        String s;

        boolean valueSet = false;

        synchronized String get() {
            while (!valueSet) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }

            valueSet = false;
            notify();
            return s;
        }

        synchronized void put(String s) {

            while (valueSet) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }

            this.s = s;
            valueSet = true;
            notify();
        }
    }

    static class Fizz implements Runnable {
        Control part;
        int n;
        Thread thread;

        public Fizz(Control part, int n) {
            this.part = part;
            this.n = n;

            thread = new Thread(this, "ThreadA");
            thread.start();
        }

        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ((n % 3 == 0) && (n % 5 != 0)) {
                part.put("fizz");
            }
        }
    }

    static class Buzz implements Runnable {
        Control part;
        int n;
        Thread thread;

        public Buzz(Control part, int n) {
            this.part = part;
            this.n = n;

            thread = new Thread(this, "ThreadB");
            thread.start();
        }

        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ((n % 5 == 0) && (n % 3 != 0)) {
                part.put("buzz");
            }
        }
    }

    static class FizzBuzz implements Runnable {
        Control part;
        int n;
        Thread thread;

        public FizzBuzz(Control part, int n) {
            this.part = part;
            this.n = n;

            thread = new Thread(this, "ThreadC");
            thread.start();
        }

        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ((n % 3 == 0) && (n % 5 == 0)) {
                part.put("fizzbuzz");
            }
        }
    }

    static class Number implements Runnable {
        Control part;
        int n;
        Thread thread;

        public Number(Control part, int n) {
            this.part = part;
            this.n = n;

            thread = new Thread(this, "ThreadD");
            thread.start();
        }

        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (n != count) {
                System.out.print(part.get() + ", ");
            } else {
                System.out.print(part.get() + "\n");
            }
        }
    }

    public synchronized void printSymbols(Control part, int n) {
        count = n;
        for (int i = 1; i <= n; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Fizz(part, i);
            new Buzz(part, i);
            new FizzBuzz(part, i);
            new Number(part, i);
            if (i % 3 != 0) {
                if (i % 5 != 0) {
                    part.put(String.valueOf(i));
                }
            }
        }
    }

    public static void main(String[] args) {
        ReplacingNumbers line = new ReplacingNumbers();
        Control part = new Control();
        line.printSymbols(part, 15);
    }
}


