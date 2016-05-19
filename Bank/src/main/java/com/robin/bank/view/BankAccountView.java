package com.robin.bank.view;

import com.robin.bank.entity.BankAccount;

import java.util.List;

/**
 * Created by Rober on 18.05.2016.
 */
public class BankAccountView implements View {
    @Override
    public void show(List list) {
        System.out.println("------------Lista kont--------------");
        list.forEach(b -> {
            BankAccount bankAccount = (BankAccount) b;
            System.out.println("Konto: "+bankAccount.getNumber()+" saldo: "+bankAccount.getAmount());
        });
        System.out.println();
    }
}
