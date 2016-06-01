package com.robin.bank.entity;

import com.robin.bank.exceptions.DebetException;
import com.robin.bank.listeners.TransactionListener;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

/**
 * Created by Rober on 18.05.2016.
 */
@Getter

public class Transaction {
    @Setter
    BankAccount from;
    @Setter
    BankAccount to;
    @Setter
    int amount;

    TransactionState transactionState;
    List<TransactionListener> transactionListeners;
    public Transaction() {
        transactionState = TransactionState.READY;
    }

    public Transaction(BankAccount from, BankAccount to, int amount) {
        transactionState = TransactionState.READY;
        this.from = from;
        this.to = to;
        this.amount = amount;
        transactionListeners = new ArrayList<>();
        transactionListeners.add(new TransactionListener());
    }

    public void addActionListener (TransactionListener listener) {
        transactionListeners.add(listener);
    }
    public void setTransactionState(TransactionState state) {
        this.transactionState = state;
        ExecuteSaveOnListeners();

    }
    private void ExecuteSaveOnListeners() {
        transactionListeners.forEach(t -> t.save(this));
    }






    @Override
    public String toString() {
        return "Transaction{" +
                "from=" + from.getNumber() +
                ", to=" + to.getNumber() +
                ", amount=" + amount +
                " "+transactionState.toString()+
                '}';
    }



}
