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
        List<BankAccount> bankAccounts;
        List<Transaction> transactions;
        BankAccountView bankAccountView = new BankAccountView();


        TransactionRepository transactionRepo = new TransactionRepositoryImpl();
        BankAccountRepository bankAccountRepository = new BankAccountRepositoryImpl();
        BankAccount ac = bankAccountRepository.findBankAccountByNumber(33333333);

        System.out.println(ac.getAmount() + "\n\n\n\n\n");

        bankAccounts = bankAccountRepository.getAllBankAccount();
        transactions = transactionRepo.getAllTransactions();

        bankAccountView.show(bankAccountRepository.getAllBankAccount());
        new ViewTransactions().show(transactionRepo.getAllTransactions());

        Queue<Transaction> queue = new ArrayDeque<>();
        transactions.forEach(queue::add);

        while(!queue.isEmpty()) {
            Transaction transaction = queue.poll();
            try {
                bank.makeTransaction(transaction);
                new TransactionSuccessView().show(transaction);

            } catch (DebetException e) {
                System.out.println("Nie mozna wykonac tranzakcji");
                if(transaction.getTransactionState() == TransactionState.READY) {
                    log.debug("wrzucam na koniec kolejki");
                    queue.add(transaction);
                } else if(transaction.getTransactionState() == TransactionState.ERROR) {
                    System.out.println("Dane:" + transaction.toString());
                }
            }
        }

        new BankAccountView().show(bankAccounts);


    }
}
