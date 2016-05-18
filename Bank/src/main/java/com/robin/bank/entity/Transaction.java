package com.robin.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Rober on 18.05.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    BankAccount from;
    BankAccount to;
    int amount;

    @Override
    public String toString() {
        return "Transaction{" +
                "from=" + from.getNumber() +
                ", to=" + to.getNumber() +
                ", amount=" + amount +
                '}';
    }
}
