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

    List<Transaction> transactions = null;

    BankAccountRepository bankAccountRepo = BankAccountRepositoryImpl.getInstance();
    private static TransactionRepository instance = new TransactionRepositoryImpl();
    private TransactionRepositoryImpl() {};
    public static TransactionRepository getInstance () {
        return instance;
    }


    @Override
    public List<Transaction> getAllTransactions() {
        if(transactions == null) {
            List<String> input_data = fileWorker.getAllLinesFromFile("src/main/resources/transactions_data");
            transactions = new ArrayList<>();

            input_data
                    .stream()
                    .forEach(line -> {
                        Transaction account = new Transaction();
                        String[] list = line.split(" ");
                        BankAccount from = bankAccountRepo.findBankAccountByNumber(Integer.parseInt(list[0]));
                        BankAccount to = bankAccountRepo.findBankAccountByNumber(Integer.parseInt(list[1]));
                        int value = Integer.parseInt(list[2]);
                        transactions.add(new Transaction(from, to, value));
                    });
        }
        return transactions;
    }
}
