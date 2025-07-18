package com.pluralsight;

import java.util.Scanner;

public class BankLedgerApp {
    static Scanner scanner = new Scanner(System.in);
    static int res;
    public static void main(String[] args) {
        TransactionManager.breakTransactionLine();
        res = homeScreen();
    }
    public  static int homeScreen(){
        display("Please select Option");
        boolean display = true;
        while (display){
            display("-------- You are in the Home Screen ---------");
            display("1 - Add Deposit");
            display("2 - Make Payment (Debit)");
            display("3 - Ledger Screen");
            display("4 - Exit");
            display("Enter Command: ");
            res = scanner.nextInt();
            scanner.nextLine();
            switch (res){
                case 1:
                    TransactionManager.addDeposit();
                    break;
                case 2:
                    TransactionManager.makePayment();
                    break;
                case 3:
                    LedgerMenu.ledgerScreen();
                    break;
                case 4:
                    display("Exiting app.... Bye...... \uD83D\uDE0A");
                    display = false;
                    break;
            }
        }
        return res;
    }
    public static void display(String message){
        System.out.println(message);
    }
}
//package com.pluralsight;
//
//import java.util.Scanner;
//
//public class BankLedgerApp {
//    public static void main(String[] args) {
//                Scanner scanner = new Scanner(System.in);
//                boolean running = true;
//
//                while (running) {
//                    System.out.println("\n--- Bank Ledger App ---");
//                    System.out.println("D) Add Deposit");
//                    System.out.println("P) Make Payment (Debit)");
//                    System.out.println("L) Ledger");
//                    System.out.println("X) Exit");
//                    System.out.print("Enter option: ");
//
//                    String choice = scanner.nextLine().trim().toUpperCase();
//                    switch (choice) {
//                        case "D":
//                            Transactions.addTransaction(true);
//                            break;
//                        case "P":
//                            Transactions.addTransaction(false);
//                            break;
//                        case "L":
//                            LedgerMenu.displayLedgerMenu();
//                            break;
//                        case "X":
//                            System.out.println("Goodbye!");
//                            running = false;
//                            break;
//                        default:
//                            System.out.println("Invalid choice. Try again.");
//                    }
//                }
//            }
//
