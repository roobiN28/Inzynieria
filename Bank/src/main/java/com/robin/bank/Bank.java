package com.robin.bank;

import com.robin.bank.repositories.BankAccountRepositoryImpl;

/**
 * Created by Rober on 18.05.2016.
 */
public class Bank {
    public static void main(String[] args) {
        BankAccountRepositoryImpl bank = new BankAccountRepositoryImpl();
        bank.getAllBankAccount();
    }
}
