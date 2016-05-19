package com.robin.bank.view;

import com.robin.bank.entity.Transaction;

import java.util.List;

/**
 * Created by ${Robert} on 19.05.2016.
 */
public class TransactionSuccessView {
    public void show(Transaction t) {
        System.out.println("Udalo sie wykonac tranzakcje :");
        System.out.println(t.toString());
    }
}
