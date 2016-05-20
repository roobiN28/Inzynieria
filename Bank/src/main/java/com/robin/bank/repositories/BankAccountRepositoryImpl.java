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

    private static BankAccountRepository instance = new BankAccountRepositoryImpl();
    private BankAccountRepositoryImpl() {};
    public static BankAccountRepository getInstance() {
        return instance;
    }



    List<BankAccount> data = null;

    String path = "src/main/resources/bank_account_data";
    @Override
    public List<BankAccount> getAllBankAccount() {
        if(data == null) {
            List<String> input_data = fileWorker.getAllLinesFromFile(path);
            data = new ArrayList<>();
            input_data
                    .stream()
                    .forEach(line -> {
                        BankAccount account = new BankAccount();
                        String[] list = line.split(" ");
                        data.add(new BankAccount(Integer.parseInt(list[0]), Integer.parseInt(list[1])));
                    });
        }
        return data;
    }

    @Override
    public BankAccount findBankAccountByNumber(int number) {
        for (BankAccount b: getAllBankAccount() ) {
            if(b.getNumber() == number)
                return b;
        }
        return null;
    }
}
