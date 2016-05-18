package com.robin.bank.repositories;

import com.robin.bank.data.FileWorker;
import com.robin.bank.entity.BankAccount;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rober on 18.05.2016.
 */
@Log4j
public class BankAccountRepositoryImpl implements BankAccountRepository  {
    @Getter
    @Setter
    FileWorker fileWorker = new FileWorker();

    @Override
    public List<BankAccount> getAllBankAccount() {
        List<String> input_data = fileWorker.getAllLinesFromFile("", "input_data");
        List<BankAccount> bankAccounts = new ArrayList<>();
        input_data
                .stream()
                .forEach(log::debug);
        input_data
                .stream()
                .forEach(line -> {
                    BankAccount account = new BankAccount();
                    String[] list = line.split(" ");

                });
        return null;
    }

    @Override
    public BankAccount findBankAccountByNumber(int number) {
        return null;
    }
}
