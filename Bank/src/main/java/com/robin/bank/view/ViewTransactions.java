package com.robin.bank.view;

import com.robin.bank.entity.BankAccount;
import com.robin.bank.entity.Transaction;

import java.util.List;

/**
 * Created by Rober on 18.05.2016.
 */
public class ViewTransactions implements View {
    @Override
    public void show(List list) {
        System.out.println("----------------- TRANZAKCJE -----------------");
        list.forEach(e -> {
            Transaction t = (Transaction) e;
            System.out.println("From: "+ t.getFrom().getNumber() + " to: "+t.getTo().getNumber()+ " amount: "+t.getAmount());
        });
        System.out.println();
    }
}
