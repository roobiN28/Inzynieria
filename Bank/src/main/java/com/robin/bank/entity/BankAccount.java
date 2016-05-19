package com.robin.bank.entity;

import com.robin.bank.exceptions.DebetException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Rober on 18.05.2016.
 */
@Getter @Setter
@lombok.NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    int number;
    int amount;
    public void addMoney(int value) {
        if(value >=0)
            amount+=value;
    }
    public void getMoney(int value) throws DebetException {
        if( (amount - value) < 0 ) {
            throw new DebetException();
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "number=" + number +
                ", amount=" + amount +
                '}';
    }
}
