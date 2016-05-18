package com.robin.bank.repositories;

import com.robin.bank.data.FileWorker;
import com.robin.bank.entity.BankAccount;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Rober on 18.05.2016.
 */
@Log4j
public class BankAccountRepositoryImpl implements BankAccountRepository  {
    @Getter
    @Setter
    FileWorker fileWorker = new FileWorker();
    String path = "src/main/resources/bank_account_data";
    @Override
    public List<BankAccount> getAllBankAccount() {
        List<String> input_data = fileWorker.getAllLinesFromFile(path);
        List<BankAccount> bankAccounts = new ArrayList<>();
        input_data
                .stream()
                .forEach(line -> {
                    BankAccount account = new BankAccount();
                    String[] list = line.split(" ");
                    bankAccounts.add(new BankAccount(Integer.parseInt(list[0]),Integer.parseInt(list[1])));
                });
        return bankAccounts;
    }

    @Override
    public BankAccount findBankAccountByNumber(int number) {
        return getAllBankAccount()
                .stream()
                .filter(bankAccount -> bankAccount.getNumber() == number)
                .collect(Collectors.toList()).get(0);

    }
}
