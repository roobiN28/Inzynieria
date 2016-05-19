package com.robin.bank;

import com.robin.bank.entity.Transaction;
import com.robin.bank.entity.TransactionState;
import com.robin.bank.exceptions.DebetException;
import com.robin.bank.transaction.TransactionMaker;

/**
 * Created by Rober on 18.05.2016.
 */
public class Bank implements TransactionMaker {
    private static Bank ourInstance = new Bank();

    public static Bank getInstance() {
        return ourInstance;
    }

    private Bank() {

    }



    @Override
    public void makeTransaction(Transaction transaction) throws DebetException {
        try {
            transaction.getFrom().getMoney(transaction.getAmount());
            transaction.getTo().addMoney(transaction.getAmount());
            transaction.setTransactionState(TransactionState.SUCCESS);
            System.out.println();


        } catch (DebetException e) {
            throw new DebetException();
        }
    }
}
