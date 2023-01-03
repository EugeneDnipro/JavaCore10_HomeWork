package Module12;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TimeCount {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(0);
    long start = System.currentTimeMillis();

    public void beep() {
        final Runnable beeperFive = () -> System.out.println("Минуло 5 секунд");

        final Runnable beeperOne = () -> System.out.println((System.currentTimeMillis() - start) / 1000);

        final ScheduledFuture<?> beeperHandleOne = scheduler.scheduleAtFixedRate(beeperOne, 1, 1, SECONDS);
        final ScheduledFuture<?> beeperHandleFive = scheduler.scheduleAtFixedRate(beeperFive, 5, 5, SECONDS);

        scheduler.schedule(() -> {
            beeperHandleOne.cancel(true);
            beeperHandleFive.cancel(true);
        }, 30, SECONDS);
    }
}
