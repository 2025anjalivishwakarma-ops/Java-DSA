
import java.util.concurrent.Semaphore;

class SharedResource {
    Semaphore semaphore = new Semaphore(1);

    void accessResource(String processName) {
        boolean acquired = false;

        try {
            semaphore.acquire();
            acquired = true;

            System.out.println(processName + " entered critical section.");

            for (int i = 1; i <= 3; i++) {
                System.out.println(processName + " is working...");
                Thread.sleep(500);
            }

            System.out.println(processName + " leaving critical section.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(processName + " was interrupted.");
        } finally {
            if (acquired) {
                semaphore.release();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread p1 = new Thread(() -> resource.accessResource("Process 1"));
        Thread p2 = new Thread(() -> resource.accessResource("Process 2"));
        Thread p3 = new Thread(() -> resource.accessResource("Process 3"));

        p1.start();
        p2.start();
        p3.start();
    }
}
