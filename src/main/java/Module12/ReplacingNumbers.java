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

        public synchronized void run() {
            for (int i = 1; i <= n; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ((i % 3 == 0) && (i % 5 != 0)) {
                    part.put("fizz");
                }
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

        public synchronized void run() {
            for (int i = 1; i <= n; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ((i % 5 == 0) && (i % 3 != 0)) {
                    part.put("buzz");
                }
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
            for (int i = 1; i <= n; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ((i % 3 == 0) && (i % 5 == 0)) {
                    part.put("fizzbuzz");
                }
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

        public synchronized void run() {
            for (count = 1; count <= n; count++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count % 3 != 0) {
                    if (count % 5 != 0) {
                        part.put(String.valueOf(count));
                    }
                }
                if (n != count) {
                    System.out.print(part.get() + ", ");
                } else {
                    System.out.print(part.get() + "\n");
                }
            }
        }
    }

    public synchronized void printSymbols(Control part, int n) {
        new Number(part, n);
        new Fizz(part, n);
        new Buzz(part, n);
        new FizzBuzz(part, n);
    }

    public static void main(String[] args) {
        ReplacingNumbers line = new ReplacingNumbers();
        Control part = new Control();
        line.printSymbols(part, 15);
    }
}


