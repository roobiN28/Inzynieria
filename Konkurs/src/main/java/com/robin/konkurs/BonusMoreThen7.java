package com.robin.konkurs;

/**
 * Created by ${Robert} on 19.05.2016.
 */
public class BonusMoreThen7 extends BonusDecorator {
    Konkurs konkurs;

    public BonusMoreThen7(Konkurs konkurs) {
        this.konkurs = konkurs;
    }

    public int execute(int[] numbers) {
        int premia=0;
        if(numbers.length > 7) {
            premia = 150;
        }
        return konkurs.execute(numbers) + premia;
    }
}
