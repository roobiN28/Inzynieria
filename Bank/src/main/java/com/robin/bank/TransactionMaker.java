package com.robin.bank;

import com.robin.bank.entity.Transaction;
import com.robin.bank.entity.TransactionState;
import com.robin.bank.exceptions.DebetException;
import lombok.extern.log4j.Log4j;

/**
 * Created by ${Robert} on 20.05.2016.
 */
public interface TransactionMaker {
    public void execute(Transaction t) throws DebetException;
}
