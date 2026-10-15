package Assignment26;

class Task implements Runnable {
    private String taskName;

    Task(String taskName) {
        this.taskName = taskName;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + ": " + i);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(taskName + " interrupted.");
                return;
            }
        }

        System.out.println(taskName + " completed.");
    }
}
public class RunnableDemo {
    public static void main(String[] args) {
        Task task1 = new Task("Task-1");
        Task task2 = new Task("Task-2");

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Main thread completed.");
    }
}
