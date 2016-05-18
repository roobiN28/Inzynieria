package com.robin.bank.transaction;

import com.robin.bank.entity.Transaction;

/**
 * Created by Rober on 18.05.2016.
 */
public interface TransactionMaker {
    void makeTransaction (Transaction transaction);
}
