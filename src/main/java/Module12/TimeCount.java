package Module12;

public class TimeCount {
    static long start = System.currentTimeMillis();

    private static class BeeperOne implements Runnable {
        public void run() {
            try {
                while ((System.currentTimeMillis() - start) / 1000 < 30) {
                    Thread.sleep(1000);
                    System.out.println((System.currentTimeMillis() - start) / 1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Виконання задачі не завершене!");
            }
        }
    }

    private static class BeeperFive implements Runnable {
        public void run() {
            try {
                while ((System.currentTimeMillis() - start) / 1000 < 30) {
                    Thread.sleep(5000);
                    System.out.println("Минуло 5 секунд");
                }
            } catch (InterruptedException e) {
                System.out.println("Виконання задачі не завершене!");
            }
        }
    }

    public void beep() {

        Thread oneSecond = new Thread(new BeeperOne());
        Thread fiveSecond = new Thread(new BeeperFive());
        oneSecond.start();
        fiveSecond.start();
    }
}
