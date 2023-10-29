package org.example;

public class Main {
    public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem();

        bankSystem.createAccount("John Doe", 1000.0, 1001);
        bankSystem.createAccount("Jane Smith", 500.0, 1002);

        bankSystem.deposit(1001, 500.0);
        bankSystem.withdraw(1002, 200.0);
        bankSystem.transfer(1001, 1002, 300.0);

        bankSystem.checkBalance(1001);
        bankSystem.checkBalance(1002);

        bankSystem.getAccountInfo(1001);
        bankSystem.getAccountInfo(1002);
    }
}
