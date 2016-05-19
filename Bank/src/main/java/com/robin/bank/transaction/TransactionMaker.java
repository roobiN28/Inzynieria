package com.robin.bank.transaction;

import com.robin.bank.entity.Transaction;
import com.robin.bank.exceptions.DebetException;

/**
 * Created by ${Robert} on 18.05.2016.
 */
public interface TransactionMaker {
    void makeTransaction (Transaction transaction) throws DebetException;
}
