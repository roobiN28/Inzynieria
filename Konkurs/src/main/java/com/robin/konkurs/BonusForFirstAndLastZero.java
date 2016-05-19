package com.robin.konkurs;

/**
 * Created by ${Robert} on 19.05.2016.
 */
public class BonusForFirstAndLastZero extends BonusDecorator {
    Konkurs konkurs;

    public BonusForFirstAndLastZero(Konkurs konkurs) {
        this.konkurs = konkurs;
    }

    public int execute(int[] numbers) {
        int premia = 0;
        int first = numbers[0];
        int last = numbers[numbers.length-1];
        if(first==0 && last == 0)
            premia = 100;
        return konkurs.execute(numbers) + premia;
    }
}
