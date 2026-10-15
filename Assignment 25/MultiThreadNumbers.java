package A25;
class NumberThread extends Thread {
    private String threadName;
    private int start, end;

    NumberThread(String name, int start, int end) {
        this.threadName = name;
        this.start = start;
        this.end = end;
    }
    public void run() {
        for (int i = start; i <= end; i++) {
            System.out.println(threadName + ": " + i);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
                return;
            }
        }

        System.out.println(threadName + " finished.");
    }
}
public class MultiThreadNumbers {
    public static void main(String[] args) {
        NumberThread t1 = new NumberThread("Thread-1", 1, 10);
        NumberThread t2 = new NumberThread("Thread-2", 11, 20);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Main thread finished.");
    }
}
