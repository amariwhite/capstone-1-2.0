package com.pluralsight;

public class Transaction {
    private String name = "";
    private String date = "";
    private String time;
    private String vendor = "";
    private String description = "";
    private double amount = 0;

    public Transaction(String name, String date, String time, String vendor, String description, double amount) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.vendor = vendor;
        this.description = description;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
//package com.pluralsight;
//
//import java.io.*;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Transactions {
//    private static String filePath = "transactions.csv";
//    private String date;
//    private String time;
//    private String description;
//    private String vendor;
//    private double amount;
//
//    public static void addTransaction(boolean isDeposit) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter description: ");
//        String description = scanner.nextLine();
//
//        System.out.print("Enter vendor: ");
//        String vendor = scanner.nextLine();
//
//        System.out.print("Enter amount: ");
//        double amount = Double.parseDouble(scanner.nextLine());
//
//        if (!isDeposit) amount *= -1;
//
//        LocalDateTime now = LocalDateTime.now();
//        String record = String.format("%s|%s|%s|%s|%.2f", now.toLocalDate(), now.toLocalTime().withNano(0), description, vendor, amount);
//
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
//            writer.write(record);
//            writer.newLine();
//            System.out.println("Transaction recorded.");
//        } catch (IOException e) {
//            System.out.println("Error saving transaction: " + e.getMessage());
//        }
//    }
//
//    public static List<String[]> readAllTransactions() {
//        List<String[]> transactions = new ArrayList<>();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split("\\|");
//                if (parts.length == 5) transactions.add(parts);
//            }
//        } catch (IOException e) {
//            System.out.println("Error reading transactions: " + e.getMessage());
//        }
//
//        return transactions;
//    }
//
//    public static void displayTransactions(List<String[]> transactions) {
//        transactions.stream()
//                .sorted((a, b) -> b[0].compareTo(a[0]) != 0 ? b[0].compareTo(a[0]) : b[1].compareTo(a[1]))
//                .forEach(t -> System.out.printf("%s %s | %s | %s | $%.2f%n", t[0], t[1], t[2], t[3], Double.parseDouble(t[4])));
//    }
//
//    public static List<String[]> filterTransactionsByAmount(boolean isDeposit) {
//        List<String[]> all = readAllTransactions();
//        return all.stream()
//                .filter(t -> {
//                    double amount = Double.parseDouble(t[4]);
//                    return isDeposit ? amount > 0 : amount < 0;
//                }).toList();
//    }
//
//    public static List<String[]> filterByVendor(String vendor) {
//        return readAllTransactions().stream()
//                .filter(t -> t[3].equalsIgnoreCase(vendor))
//                .toList();
//    }
//
//    public static List<String[]> filterByDateRange(LocalDateTime start, LocalDateTime end) {
//        return readAllTransactions().stream()
//                .filter(t -> {
//                    LocalDateTime dateTime = LocalDateTime.parse(t[0] + "T" + t[1]);
//                    return !dateTime.isBefore(start) && !dateTime.isAfter(end);
//                }).toList();
//    }
//
//    public static void customSearch(List<Transactions> transactions, Scanner scanner) {
//        System.out.print("Enter start date (yyyy-mm-dd) or leave blank for no filter: ");
//        String startDate = scanner.nextLine().trim();
//
//        System.out.print("Enter end date (yyyy-mm-dd) or leave blank for no filter: ");
//        String endDate = scanner.nextLine().trim();
//
//        System.out.print("Enter description or leave blank for no filter: ");
//        String description = scanner.nextLine().trim().toLowerCase();
//
//        System.out.print("Enter vendor or leave blank for no filter: ");
//        String vendor = scanner.nextLine().trim().toLowerCase();
//
//        System.out.print("Enter amount or leave blank for no filter: ");
//        String amountInput = scanner.nextLine().trim();
//        Double amount = null;
//        if (!amountInput.isEmpty()) {
//            try {
//                amount = Double.parseDouble(amountInput);
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid amount entered. Skipping amount filter.");
//            }
//        }
//
//        System.out.println("\nFiltered Transactions:\n");
//
//        for (Transactions t : transactions) {
//            boolean matches = true;
//
//            if (!startDate.isEmpty() && t.getDate().compareTo(startDate) < 0) matches = false;
//            if (!endDate.isEmpty() && t.getDate().compareTo(endDate) > 0) matches = false;
//            if (!description.isEmpty() && !t.getDescription().toLowerCase().contains(description)) matches = false;
//            if (!vendor.isEmpty() && !t.getVendor().toLowerCase().contains(vendor)) matches = false;
//            if (amount != null && t.getAmount() != amount) matches = false;
//
//            if (matches) {
//                System.out.println(t);
//            }
//        }
//    }
//
//    public String getDate() { return date; }
//    public String getDescription() { return description; }
//    public String getVendor() { return vendor; }
//    public double getAmount() { return amount; }
//
//    @Override
//    public String toString() {
//        return date + " | " + time + " | " + description + " | " + vendor + " | " + amount;
//    }
