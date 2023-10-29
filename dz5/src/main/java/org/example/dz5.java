package org.example;

import java.util.HashMap;

class BankAccount {
    private final String ownerName;
    private double balance;

    public BankAccount(String ownerName, double initialBalance) {
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Successfully deposited: " + amount);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Successfully withdrawn: " + amount);
            return true;
        } else {
            System.out.println("Insufficient funds for withdrawal.");
            return false;
        }
    }

    public void transfer(BankAccount receiver, double amount) {
        if (withdraw(amount)) {
            receiver.deposit(amount);
            System.out.println("Successfully transferred: " + amount + " to account of " + receiver.getOwnerName());
        } else {
            System.out.println("Transfer unsuccessful. Insufficient funds.");
        }
    }
}

class BankSystem {
    private final HashMap<Integer, BankAccount> accounts;

    public BankSystem() {
        accounts = new HashMap<>();
    }

    public void createAccount(String ownerName, double initialBalance, int accountNumber) {
        if (!accounts.containsKey(accountNumber)) {
            BankAccount newAccount = new BankAccount(ownerName, initialBalance);
            accounts.put(accountNumber, newAccount);
            System.out.println("Account created for " + ownerName + " with account number: " + accountNumber);
        } else {
            System.out.println("Account number already exists. Please choose a different number.");
        }
    }

    public void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            accounts.get(accountNumber).deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            accounts.get(accountNumber).withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void transfer(int senderAccountNumber, int receiverAccountNumber, double amount) {
        if (accounts.containsKey(senderAccountNumber) && accounts.containsKey(receiverAccountNumber)) {
            accounts.get(senderAccountNumber).transfer(accounts.get(receiverAccountNumber), amount);
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    public void checkBalance(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Balance for account number " + accountNumber + " is: " + accounts.get(accountNumber).getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public void getAccountInfo(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            BankAccount acc = accounts.get(accountNumber);
            System.out.println("Account Information:");
            System.out.println("Owner Name: " + acc.getOwnerName());
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Current Balance: " + acc.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
}


