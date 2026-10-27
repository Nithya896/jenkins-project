package com.payment;

public class App {
    public static void main(String[] args) {
        System.out.println("Payment App Started on EC2");
        System.out.println(makePayment("USER123", 1000));
        System.out.println(makePayment("USER456", 2500));
    }
    public static String makePayment(String user, double amount){
        if(amount <= 0) return "FAILED for " + user;
        String txn = "TXN" + System.currentTimeMillis();
        return "SUCCESS: " + user + " paid Rs." + amount + " Txn=" + txn;
    }
}