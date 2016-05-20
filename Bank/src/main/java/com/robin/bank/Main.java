package com.robin.bank;

import com.robin.bank.entity.BankAccount;
import com.robin.bank.entity.Transaction;
import com.robin.bank.entity.TransactionState;
import com.robin.bank.exceptions.DebetException;
import com.robin.bank.repositories.BankAccountRepository;
import com.robin.bank.repositories.BankAccountRepositoryImpl;
import com.robin.bank.repositories.TransactionRepository;
import com.robin.bank.repositories.TransactionRepositoryImpl;
import com.robin.bank.view.BankAccountView;
import com.robin.bank.view.TransactionSuccessView;
import com.robin.bank.view.ViewTransactions;
import lombok.extern.log4j.Log4j;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * Created by Rober on 18.05.2016.
 */
@Log4j
public class Main {
    public static void main(String[] args) {

        Bank bank = Bank.getInstance();

        new BankAccountView().show(
                BankAccountRepositoryImpl.getInstance().getAllBankAccount()
        );

        new ViewTransactions().show(
                TransactionRepositoryImpl.getInstance().getAllTransactions()
        );

        bank.makeAllCurrentTransaction();

        new BankAccountView().show(
                BankAccountRepositoryImpl.getInstance().getAllBankAccount()
        );



    }
}
