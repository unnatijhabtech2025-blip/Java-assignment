package Assignment26;
class BankAccount {
    private int balance = 1000;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("[Deposit] Amount: " + amount
                + " | Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("[Withdrawal] Amount: " + amount
                    + " | Balance: " + balance);
        } else {
            System.out.println("[Withdrawal] Insufficient balance!"
                    + " | Balance: " + balance);
        }
    }

    public synchronized int getBalance() {
        return balance;
    }
}

class DepositTask implements Runnable {
    private BankAccount account;

    DepositTask(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            account.deposit(200);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("Deposit task interrupted.");
                return;
            }
        }
    }
}

class WithdrawalTask implements Runnable {
    private BankAccount account;

    WithdrawalTask(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            account.withdraw(150);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("Withdrawal task interrupted.");
                return;
            }
        }
    }
}

public class RunnableBankDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread depositThread = new Thread(new DepositTask(account));
        Thread withdrawalThread = new Thread(new WithdrawalTask(account));

        depositThread.start();
        withdrawalThread.start();

        try {
            depositThread.join();
            withdrawalThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}
