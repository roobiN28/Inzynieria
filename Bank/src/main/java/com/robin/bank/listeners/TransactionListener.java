package com.robin.bank.listeners;

import com.robin.bank.entity.Transaction;
import lombok.extern.log4j.Log4j;

/**
 * Created by ${Robert} on 20.05.2016.
 */
@Log4j
public class TransactionListener {
    public void save (Transaction t) {
        log.debug("TransactionListener:\n   "+
        t.toString());
    }
}
