package BankingApp;

import java.math.BigDecimal;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Bank bank = new Bank();
        InterestAccrualTask task = new InterestAccrualTask(bank);
        task.start();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Banking Simulator ===");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Show Accounts");
            System.out.println("7. Mini Statement");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            try {
                switch (ch) {
                    case 1:
                        System.out.print("Account No: ");
                        String sAcc = sc.nextLine();
                        System.out.print("Holder Name: ");
                        String sName = sc.nextLine();
                        bank.createSavingsAccount(sAcc, sName);
                        break;

                    case 2:
                        System.out.print("Account No: ");
                        String cAcc = sc.nextLine();
                        System.out.print("Holder Name: ");
                        String cName = sc.nextLine();
                        bank.createCurrentAccount(cAcc, cName);
                        break;

                    case 3:
                        System.out.print("Account No: ");
                        String dAcc = sc.nextLine();
                        System.out.print("Amount: ");
                        BigDecimal dAmt = sc.nextBigDecimal();
                        bank.deposit(dAcc, dAmt);
                        break;

                    case 4:
                        System.out.print("Account No: ");
                        String wAcc = sc.nextLine();
                        System.out.print("Amount: ");
                        BigDecimal wAmt = sc.nextBigDecimal();
                        bank.withdraw(wAcc, wAmt);
                        break;

                    case 5:
                        System.out.print("From Account: ");
                        String fAcc = sc.nextLine();
                        System.out.print("To Account: ");
                        String tAcc = sc.nextLine();
                        System.out.print("Amount: ");
                        BigDecimal tAmt = sc.nextBigDecimal();
                        bank.transfer(fAcc, tAcc, tAmt);
                        break;

                    case 6:
                        for (var acc : bank.getAllAccounts()) {
                            System.out.println(acc);
                        }
                        break;

                    case 7:
                        System.out.print("Account No: ");
                        String mAcc = sc.nextLine();
                        bank.printMiniStatement(mAcc);
                        break;

                    case 0:
                        task.interrupt();
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
