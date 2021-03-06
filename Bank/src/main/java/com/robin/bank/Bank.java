package com.robin.bank;

import com.robin.bank.entity.Transaction;
import com.robin.bank.entity.TransactionState;
import com.robin.bank.exceptions.DebetException;
import com.robin.bank.repositories.TransactionRepository;
import com.robin.bank.repositories.TransactionRepositoryImpl;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rober on 18.05.2016.
 */
@Log4j
public class Bank {
    private static Bank ourInstance = new Bank();

    public static Bank getInstance() {
        return ourInstance;
    }

    List<Transaction> transactionQueue;
    @Getter
    List<Transaction> unhandledTransactions;

    TransactionMaker transactionMaker;
    private Bank() {
        transactionQueue = new ArrayList<>();
        unhandledTransactions = new ArrayList<>();
        transactionMaker = new TransactionMakerImpl();
    }

    public void makeAllCurrentTransaction() {
        updateData();
        while( ! transactionQueue.isEmpty()) {
            Transaction current = transactionQueue.remove(0);
            try {

                transactionMaker.execute(current);
            } catch (DebetException e) {
                if(current.getTransactionState() == TransactionState.READY) {
                    transactionQueue.add(current);
                } else if(current.getTransactionState() == TransactionState.ERROR) {
                    unhandledTransactions.add(current);
                }
            }
        }
    }
    public void updateData() {
        // dodaj tranzakcje do kolejki
        TransactionRepository transactionRepo = TransactionRepositoryImpl.getInstance();
        transactionRepo.getAllTransactions().stream().forEach(transactionQueue::add);

    }


}
