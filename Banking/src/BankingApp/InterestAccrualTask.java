package BankingApp;

public class InterestAccrualTask extends Thread {
    private Bank bank;

    public InterestAccrualTask(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(60000); // every 60 sec for demo
                bank.applyInterestToSavings();
                System.out.println(">>> Interest applied to all savings accounts.");
            }
        } catch (InterruptedException e) {
            System.out.println("Interest task stopped.");
        }
    }
}
