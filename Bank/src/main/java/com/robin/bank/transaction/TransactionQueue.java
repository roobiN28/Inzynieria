package com.robin.bank.transaction;

import com.robin.bank.entity.Transaction;
import lombok.extern.log4j.Log4j;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Rober on 18.05.2016.
 */
@Log4j
public class TransactionQueue {
    Queue<Transaction> transactions;
    public TransactionQueue() {
        transactions = new ArrayDeque<>();
    }
    public void add (Transaction transaction) {
        transactions.add(transaction);
    }
    public Transaction get() {
        Transaction t =  transactions.poll();
        log.debug("tranzakcja wzieta z TransactionQueue = "+transactions.toString());
        return t;

    }
}
