package com.robin.bank.entity;

import com.robin.bank.exceptions.DebetException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Rober on 18.05.2016.
 */
@Getter
@Setter
public class Transaction {
    BankAccount from;
    BankAccount to;
    int amount;
    TransactionState transactionState;

    public Transaction() {
        transactionState = TransactionState.READY;
    }

    public Transaction(BankAccount from, BankAccount to, int amount) {
        transactionState = TransactionState.READY;
        this.from = from;
        this.to = to;
        this.amount = amount;
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
