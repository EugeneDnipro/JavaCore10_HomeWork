package Module12;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TestParallelStreams {
    public static void main(String[] args) {
        TimeCount timer = new TimeCount();
        timer.beep();

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Callable threadA = new ReplacingNumbers.ThreadA(1);
        executor.submit(threadA);
        Callable threadB = new ReplacingNumbers.ThreadB(1);
        executor.submit(threadB);
        Callable threadC = new ReplacingNumbers.ThreadC(1);
        executor.submit(threadC);


    }
}
