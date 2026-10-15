package A25;


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
            System.out.println("[Withdraw] Amount: " + amount
                    + " | Balance: " + balance);
        } else {
            System.out.println("[Withdraw] Insufficient balance!"
                    + " | Balance: " + balance);
        }
    }

    public synchronized int getBalance() {
        return balance;
    }
}

class DepositThread extends Thread {
    private BankAccount account;

    DepositThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            account.deposit(200);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("Deposit thread interrupted.");
                return;
            }
        }
    }
}

class WithdrawalThread extends Thread {
    private BankAccount account;

    WithdrawalThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            account.withdraw(150);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("Withdrawal thread interrupted.");
                return;
            }
        }
    }
}

public class BankTransactionDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        DepositThread d = new DepositThread(account);
        WithdrawalThread w = new WithdrawalThread(account);

        d.start();
        w.start();

        try {
            d.join();
            w.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}
