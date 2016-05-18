package com.robin.bank.repositories;

import com.robin.bank.entity.Transaction;

import java.util.List;

/**
 * Created by Rober on 18.05.2016.
 */
public interface TransactionRepository {
    List<Transaction> getAllTransactions();
}
