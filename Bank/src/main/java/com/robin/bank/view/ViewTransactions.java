package com.robin.bank.view;

import com.robin.bank.entity.Transaction;

import java.util.List;
import java.util.Objects;

/**
 * Created by Rober on 18.05.2016.
 */
public class ViewTransactions implements View {
    @Override
    public void show(List<Object> list) {
        list.forEach(e -> {
            Transaction t = (Transaction) e;
            System.out.println("From: "+ t.getFrom().getNumber() + " to: "+t.getFrom().getNumber()+ " amount: "+t.getAmount());
        });
        System.out.printf("");
    }
}
