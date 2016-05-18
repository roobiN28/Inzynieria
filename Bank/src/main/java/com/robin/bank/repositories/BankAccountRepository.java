package com.robin.bank.repositories;

import com.robin.bank.entity.BankAccount;

import java.util.List;

/**
 * Created by Rober on 18.05.2016.
 */
public interface BankAccountRepository {


    List<BankAccount> getAllBankAccount();
    BankAccount findBankAccountByNumber(int number);

}
