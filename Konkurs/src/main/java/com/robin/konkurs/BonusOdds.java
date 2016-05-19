package com.robin.konkurs;

/**
 * Created by ${Robert} on 19.05.2016.
 */
public class BonusOdds extends BonusDecorator {
    Konkurs konkurs;

    public BonusOdds(Konkurs konkurs) {
        this.konkurs = konkurs;
    }

    public int execute(int[] numbers) {
        for (int num : numbers) {
            if(num % 2 == 0) {
                return konkurs.execute(numbers);
            }
        }
        return konkurs.execute(numbers) + 50;
    }
}
