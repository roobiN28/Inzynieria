package com.robin.bank.repositories;

import com.robin.bank.data.FileWorker;
import com.robin.bank.entity.BankAccount;
import com.robin.bank.entity.Transaction;
import lombok.extern.log4j.Log4j;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rober on 18.05.2016.
 */
@Log4j
public class TransactionRepositoryImpl implements TransactionRepository {
    FileWorker fileWorker = new FileWorker();
    BankAccountRepository bankAccountRepo = new BankAccountRepositoryImpl();
    @Override
    public List<Transaction> getAllTransactions() {
        List<String> input_data = fileWorker.getAllLinesFromFile("src/main/resources/transactions_data");
        List<Transaction> transactions =  new ArrayList<>();
        input_data
                .stream()
                .forEach(log::debug);
        input_data
                .stream()
                .forEach(line -> {
                    Transaction account = new Transaction();
                    String[] list = line.split(" ");
                    BankAccount from = bankAccountRepo.findBankAccountByNumber(Integer.parseInt(list[0]));
                    BankAccount to = bankAccountRepo.findBankAccountByNumber(Integer.parseInt(list[1]));
                    int value = Integer.parseInt(list[2]);
                    transactions.add(new Transaction(from,to,value));
                });
        return transactions;
    }
}
