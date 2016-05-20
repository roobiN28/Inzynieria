package com.robin.bank;

import com.robin.bank.entity.Transaction;
import com.robin.bank.entity.TransactionState;
import com.robin.bank.exceptions.DebetException;
import lombok.extern.log4j.Log4j;

/**
 * Created by ${Robert} on 20.05.2016.
 */
@Log4j
public class TransactionMakerImpl implements TransactionMaker {
    @Override
    public void execute(Transaction t) throws DebetException{
    try {
        int money = t.getAmount();
        t.getFrom().getMoney(money);
        t.getTo().addMoney(money);
        t.setTransactionState(TransactionState.SUCCESS);
    } catch (DebetException e) {
        log.debug("Nie udalo sie wykonac tranzakcji: "+t.toString());
        throw e;
    }
}
}
